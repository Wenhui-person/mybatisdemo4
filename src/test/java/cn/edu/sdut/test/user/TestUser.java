package cn.edu.sdut.test.user;

import cn.edu.sdut.entity.Tbuser;
import cn.edu.sdut.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUser {
    private String mybatisconfig="mybatis.xml";

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private UserMapper userMapper;
    @Before
    public void init() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(mybatisconfig);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        this.session=this.sqlSessionFactory.openSession();
        userMapper=session.getMapper(UserMapper.class);
    }
    @After
    public void destory(){
        session.commit();
        session.close();
    }
    private void print(int row){
        if(row>0){
            System.out.println("操作成功");
        }else{
            System.out.println("操作失败");
        }
    }
    @Test
    public void testAddUser(){
        Tbuser tbuser=new Tbuser(0,"yangxinyue","99999","02","tufei",null);
        int row=this.userMapper.addUser(tbuser);
        print(row);
    }
    @Test
    public void testUpdateUser(){
        Tbuser tbuser=new Tbuser(19,"songlaoshi","888888","02","laoshi",null);
        int row=this.userMapper.updateUser(tbuser);
        print(row);
    }
    @Test
    public void testDeleteUser(){
        int userid=12;
        int row=this.userMapper.deleteUser(userid);
        print(row);
    }
    @Test
    public void testCountUser(){
        int row=this.userMapper.queryUserCount();
        System.out.println("row = " + row);
    }
    @Test
    public void testqueryUserById(){
        int userid=4;
        Tbuser tbuser=this.userMapper.queryUserById(userid);
        System.out.println("tbuser = " + tbuser);
    }
    @Test
    public void testQueryUsers(){
        Tbuser tbuser=new Tbuser();
        List<Tbuser> tbusers=this.userMapper.queryUsers(tbuser);
        tbusers.forEach(u->System.out.println(u));
    }


}
