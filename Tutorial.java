public class Tutorial{

  public void main(){
    User resUser = inputSupplier(()->{
      User user = new User();
      user.setName("Jay");
      return user;
    });
  }

  public <T> T inputSupplier(Supplier<T> input){
    return input.get();
  }

  
}
