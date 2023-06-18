package com.fuyu.test;
import com.fuyu.mapper.UserMapper;
import com.fuyu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

public class userTest {
    @Test
    public void selectTest() throws IOException {

        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //执行方法
        String username="zhangsan";
        String password="123";
        User user = userMapper.selectById(1);

        System.out.println(user);
        //4.释放资源
        sqlSession.close();
    }


}
