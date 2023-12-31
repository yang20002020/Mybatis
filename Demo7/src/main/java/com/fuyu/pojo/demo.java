package com.fuyu.pojo;
import com.fuyu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
mybatis代理开发
 */
public class demo {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.执行sql
        // List<User> users = sqlSession.selectList("test.selectAll");

        //3.1 获取userMapper 接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
        //4.释放资源
        sqlSession.close();

    }
}
