package com.wf.test;

import com.wf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    @Test
    public void MybatisQuickStar() throws IOException {
        //1 .加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2. 获取sqlSesionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4. 执行
        List<User> users = sqlSession.selectList("userMapper.findAll");

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void testSave() throws IOException {
        //1 .加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2. 获取sqlSesionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("wf");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("闻喜");
        sqlSession.insert("userMapper.saveUser", user);

        //手动提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //测试更新用户
    @Test
    public void tesrUpdate() throws IOException {
        //1 .加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2. 获取sqlSesionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(4);
        user.setUsername("lucy");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("日本");

        sqlSession.insert("userMapper.updateUser", user);

        //手动提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDelete() throws IOException {
        //1 .加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2. 获取sqlSesionFactory 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("userMapper.deleteUser",4);

        //手动提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
