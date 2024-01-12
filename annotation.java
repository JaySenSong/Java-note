
@Data
@Document(collection = "user")    //mongo collection
public class User{

  @JsonIgnore        //不會包含在response JSON 
  @Column(name ="id")     //映射到mongo collection
  private ObjectId key;

  @Transient        //不存入 DB
  private Boolean save;

  @Indexed(unique = true)      //mongo unique
  private String name;

  @JsonPreperty(access = JsonProperty.Access.WRITE_ONLY)         //前端只能寫
  private String password;

  @JsonPreperty(access = JsonProperty.Access.READ_ONLY)         //前端只能讀
  @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss z", timezone="GMT=+8")        //時間回傳格是 +8小時
  private updateTime
  

  
}
