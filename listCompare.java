Map<String, User> userGroupById = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));


for(User user : userList2){
  User user = userGroupById.get(user.getId());
  if(Objects.nonNull(dept)){
    sout("is exist")
  }else{
    sout("not exist")
  }
}
