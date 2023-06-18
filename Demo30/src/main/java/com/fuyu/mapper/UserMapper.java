package com.fuyu.mapper;

import com.fuyu.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {


  //注解开发
   @Select("select  *from tb_brand where id= #{id}")
   User selectById(int id);
}
