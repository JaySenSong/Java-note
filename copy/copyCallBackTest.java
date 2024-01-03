@Test
public void listCopyUpWithCallback() {
    List<UserDO> userDOList = new ArrayList();
    userDOList.add(new UserDO(1L, "Jay", 18, 1));
    userDOList.add(new UserDO(2L, "Jay", 20, 2));
    List<UserVO> userVOList = BeanUtilCopy.copyListProperties(userDOList, UserVO::new, (userDO, userVO) -> { 
        userVO.setSex(userDO.getSex()==1 ?"男":"女");
    });
    log.info("userVOList:{}",userVOList);
}
