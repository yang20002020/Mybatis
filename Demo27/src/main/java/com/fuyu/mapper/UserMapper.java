package com.fuyu.mapper;
import com.fuyu.pojo.User;
import org.apache.ibatis.annotations.Param;
public interface UserMapper {
/*
    多个参数：封装成为map集合
     map.put("arg0",参数值1)
     map.put("param1",参数值1)
     map.put("arg1",参数值2)
     map.put("param2",参数值2)
 */
     public User select(@Param("username") String username,@Param("password") String password);

}
