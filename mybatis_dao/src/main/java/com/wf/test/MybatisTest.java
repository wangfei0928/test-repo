package com.wf.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.domain.User;
import com.wf.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    /*
        mybatis_dao层代理方式测试
     */
    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);


    }

    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allResultMap = mapper.findAllResultMap();
        for (User user : allResultMap) {
            System.out.println(user);
        }
        sqlSession.close();
    }
// 多条件查询方式一
    @Test
    public void test3() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findByIdAndUsername(6,"wf");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    // 多条件查询方式二
    @Test
    public void test4() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findByIdAndUsername2(6,"wf");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    // 多条件查询方式三
    @Test
    public void test5() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = new User();
        user1.setId(1);
        user1.setUsername("子慕");
        List<User> users = mapper.findByIdAndUsername3( user1);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    // 模糊查询
    @Test
    public void test6() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> username = mapper.findByUsername("%wf%");
        for (User user : username) {
            System.out.println(username);
        }
        sqlSession.close();
    }

    // 模糊查询
    @Test
    public void test7() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> username = mapper.findByUsername2("%wf%");
        for (User user : username) {
            System.out.println(username);
        }
        sqlSession.close();
    }

    // 添加用户 获取主键返回值
    @Test
    public void test8() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("某斐");
        user.setBirthday(new Date());
        user.setAddress("东湖路");
        user.setSex("男");

        System.out.println(user);
       mapper.SaveUser(user);
       System.out.println(user);

       sqlSession.commit();
        sqlSession.close();
    }

    // 添加用户 获取主键返回值
    @Test
    public void test9() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("某F");
        user.setBirthday(new Date());
        user.setAddress("东湖路");
        user.setSex("男");

        System.out.println(user);
        mapper.SaveUser2(user);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    // 动态sql if标签，多条件查询
    @Test
    public void test10() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(6);
        user.setUsername("wf");

        List<User> users  = mapper.findByIdAndUsernameIf(user);
        System.out.println(users);


        sqlSession.close();
    }

    // 动态sql set标签，更新
    @Test
    public void test11() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(1);
        user.setUsername("王斐最帅");
        user.setAddress("北京");
        user.setBirthday(new Date());
        mapper.updateIf(user);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    // 动态sql foreach ,多指查询
    @Test
    public void test12() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(9);

        List<User> users = mapper.findByList(ids);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    // 动态sql foreach ,多指查询
    @Test
    public void test13() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

       Integer [] ids = {2,6,9};


        List<User> byArray = mapper.findByArray(ids);
        for (User user : byArray) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    // 核心配置文件深入： plugin标签：pageHelper
    @Test
    public void test14() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当前返回的是 基于UserMapper所产生的User对象，   底层JDK动态代理，实际类型：proxy
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页参数
        //参数1：当前页
        //参数2：每页显示的条数
        PageHelper.startPage(1,2);
        List<User> users = mapper.findAllResultMap();
        for (User user : users) {
            System.out.println(user);
        }

        //获取分页相关的其他参数
        PageInfo pageInfo = new PageInfo<User>(users);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("是否是第一页"+pageInfo.isIsFirstPage());
        sqlSession.close();
    }
}
