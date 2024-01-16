/**
 * Supplier : a result
 * Function : a input, a result
 * BiFunction : two input, a result
 * Consumer : a input
 * BiConsumer : two input
 */

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
