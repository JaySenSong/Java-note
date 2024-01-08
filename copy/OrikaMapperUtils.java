/**
 * 類別屬性複製工具， 將Object複製到Class， 屬性會自動轉換
 * 無法自動轉換類型 : 
 *    string -> localDateTim
 */
public enum OrikaMapperUtils {

    private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    private static final MapperFacade MAPPER_FACADE = MAPPER_FACTORY.getMapperFacade();

    private static Map<String, MapperFacade> CACHE_MAPPER_FACADE_MAP = new ConcurrentHashMap<>();

    public <E, T> E map(Class<E> toClass, T data) {
        return MAPPER_FACADE.map(data, toClass);
    }

    public <E, T> E map(Class<E> toClass, T data, BiConsumer<T,E> biConsumer) {
        MapperFacade mapperFacade = this.getMapperFacade(toClass, data, callBack);
        return mapperFacade.map(data, toClass);
    }


    public <E, T> List<E> mapAsList(Class<E> toClass, Collection<T> data) {
        return MAPPER_FACADE.mapAsList(data, toClass);
    }

    public <E, T> List<E> mapAsList(Class<E> toClass, Collection<T> data, BiConsumer<T,E> biConsumer) {
        T t = data.stream().findFirst().orElseThrow(() -> new ExceptionInInitializerError("The input collection has not be empty"));
        MapperFacade mapperFacade = this.getMapperFacade(toClass, t, configMap);
        return mapperFacade.mapAsList(data, toClass);
    }

    private <E, T> MapperFacade getMapperFacade(Class<E> toClass, T data, BiConsumer<T,E> biConsumer) {
        String mapKey = data.getClass().getCanonicalName() + "_" + toClass.getCanonicalName();
        MapperFacade mapperFacade = CACHE_MAPPER_FACADE_MAP.get(mapKey);
        if (Objects.isNull(mapperFacade)) {
            MapperFactory factory = new DefaultMapperFactory.Builder().build();
            ClassMapBuilder classMapBuilder = factory.classMap(data.getClass(), toClass);
            classMapBuilder.customize(new CustomMapper(){
              @Override
              public void mapAtoB(Object a, Object b, MappingContext context)->{
                if(Objects.nonNull(callBack)){
                  biConsumer.accept((T) a, (E) b);
                }
                super.mapAtoB(a, b, context);
              });
              
            }          
            classMapBuilder.byDefault().register();
            mapperFacade = factory.getMapperFacade();
            CACHE_MAPPER_FACADE_MAP.put(mapKey, mapperFacade);
        }
        return mapperFacade;
    }

    /**
     * 自訂轉換屬性範例
     */
    public static void main(String[] args){
        UserDto dto = new UserDto(...);
        UserVo vo =OrikaMapperUtils.map(UserVo.class, dto,(source, targe)->{
            targe.setName(source.getCName());
        });
        
    }
}
