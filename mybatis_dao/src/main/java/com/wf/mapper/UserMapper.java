package com.wf.mapper;

import com.wf.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /*
        根据id 查询用户
     */
    public User findUserById(int id);

    /*
        查询所有用户
     */
    public List<User> findAllResultMap();
    /*
        多条件查询方法
    */
    public  List<User> findByIdAndUsername(int id,String username);

    /*
        多条件查询方法二
    */
    public  List<User> findByIdAndUsername2(@Param("id")  int id,@Param("username") String username);

    /*
       多条件查询方法三
   */
    public  List<User> findByIdAndUsername3(User user);

    /*
      模糊查询
  */
    public  List<User> findByUsername(String username);

    /*
     模糊查询2
 */
    public  List<User> findByUsername2(String username);

    /*
     添加用户
     */
    public  void SaveUser(User user);

    /*
    添加用户2
    */
    public  void SaveUser2(User user);

    /*
    动态sql语句，if多条件查询
    */
    public List<User> findByIdAndUsernameIf (User user);

    /*
    动态sql语句， set更新
     */
    public void updateIf(User user);

    /*
    动态sql语句， foreach  多指查询： 集合
     */
    public List<User> findByList(List<Integer> ids);

    /*
    动态sql语句， foreach  多指查询：数组
     */
    public List<User> findByArray(Integer [] ids);
}
