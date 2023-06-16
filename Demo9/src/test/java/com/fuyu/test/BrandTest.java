package com.fuyu.test;

import com.fuyu.mapper.BrandMapper;
import com.fuyu.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BrandTest {
    @Test
    public void testSelectAll() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> Brands= mapper.selectAll();
        System.out.println(Brands);
        //4.释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectBrandById() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int id =1;
        Brand brand = mapper.selectBranfById(id);
        System.out.println(brand);
        //4.释放资源
        sqlSession.close();

    }
    @Test
    public void testSelectByCondition() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //接收参数
        int status =1;
        String companyName="华为";
        String brandName="华为";

        //处理参数
        companyName="%" +companyName +"%";
        brandName="%"+brandName+"%";

        List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
        System.out.println(brands);
        //4.释放资源
        sqlSession.close();
    }


}
