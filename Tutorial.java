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
  }

  public <T> T inputSupplier(Supplier<T> input){
    return input.get();
  }

  
}
