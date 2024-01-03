
public class RestartSpringBoot{

  @Autowired
  private ConfigurableApplicationContext applicationContext;
  

  public void restart(){
    ApplicationArguments args = applicationContext.getBean(ApplicationArguments.class);
    Thread thread = new Thread(()->{
      applicationContext.close();
      SpringApplication.run(xxxApplication.class,args.getSourceArgs());
    });
  
    //關閉守護進程
    thread.setDaemon(false);
    thread.start();
  }

}
