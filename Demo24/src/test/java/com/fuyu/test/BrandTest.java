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
        List<Brand> Brands = mapper.selectAll();
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

        int id = 1;
        Brand brand = mapper.selectBranfById(id);
        System.out.println(brand);
        //4.释放资源
        sqlSession.close();

    }

    @Test
    public void selectByConditionSingle() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        // brand.setStatus(status);
        // brand.setCompanyName(companyName);
        // brand.setBrandName(brandName);


        //执行方法
        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);
        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //接收参数
        int status = 1;
        String companyName = "小米1";
        String brandName = "小米手机1";
        String description = "小米手机世界的手机1";
        int ordered = 100;


        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);


        //执行方法
        mapper.add(brand);

        Integer id = brand.getId();
        System.out.println(id);

        //提交事务
        sqlSession.commit();
        System.out.println(id);
        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //接收参数
        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机1996";
        int ordered = 200;
        int id = 5;


        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        // brand.setCompanyName(companyName);
        // brand.setBrandName(brandName);
         brand.setDescription(description);
        // brand.setOrdered(ordered);
        brand.setId(id);


        //执行方法
        int count = mapper.update(brand);
        System.out.println(count);


        //提交事务
        sqlSession.commit();

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //接收参数
        int id = 5;


        //执行方法
        mapper.deleteById(id);

        //提交事务
        sqlSession.commit();

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        //1.加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1 获取userMapper 接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //接收参数
        int[] ids={3,4};


        //执行方法
        mapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();

        //4.释放资源
        sqlSession.close();
    }

}
