/**
 * Supplier : 0 input, 1 result
 * Function : 1 input, 1 result
 * BiFunction : 2 input, 1 result
 * Consumer : 1 input, 0 result
 * BiConsumer : 2 input, 0 result
 */

public class Tutorial{

  public void main(){
    
    User resUser = inputSupplier(()->{
      User user = new User();
      user.setName("Jay");
      return user;
    });

    List<A> distinctA = aList.stream().filter(distinctByInput(a::getId)).collect(Collectors.toList());
    
  }

  public <T> T inputSupplier(Supplier<T> input){
    return input.get();
  }

  // Predicate返回給Filter使用
  public <T> Predicate<T> distinctByInput(Function<? super T, Object> func){
    // 安全線程 ConcurrentHashMap.newKeySet();
    Set<Object> set = new HashSet<>();
    return t -> set add(func.apply(t))
  }

  
}
