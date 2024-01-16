private User compareLevelAndDate(List<User> userList){
  List<User> userList = userList.stream()
    .sorted(Comparator.comparing(User::getLevel),(after, before)->{
      if(!before.equals("Admin") && after.equals("Admin")){
        return 1;  //往前
      }
      return 0 ;  //不動
    }).thenComparing(GroupMember::getDate).reversed()).collect(Collectors.toList());
}
