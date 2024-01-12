
@Data
@Document(collection = "user")    //mongo collection
public class User{

  @JsonIgnore        //不會包含在response JSON 
  private ObjectId id;

  @Indexed(unique = true)      //mongo unique
  private String name;

  @JsonPreperty(access = JsonProperty.Access.WRITE_ONLY)         //前端只能寫
  private String password;

  @JsonPreperty(access = JsonProperty.Access.READ_ONLY)         //前端只能讀
  @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss z", timezone="GMT=+8")        //時間回傳格是 +8小時
  private updateTime
  

  
}
