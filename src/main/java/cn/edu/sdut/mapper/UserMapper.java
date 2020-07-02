package cn.edu.sdut.mapper;

import cn.edu.sdut.entity.Tbuser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    Tbuser queryUserById(int userid);
    int queryUserCount();
    Tbuser queryUserByusername(String username);
    Tbuser login(Tbuser tbuser);
    List<Tbuser> queryUsers(Tbuser tbuser);
    @Insert(" insert into tbuser values(null,#{username},#{password},#{userroles},#{nickname},now())")
    int addUser(Tbuser tbuser);
    @Update("update tbuser set username=#{username},password=#{password},nickname=#{nickname} where userid=#{userid}")
    int updateUser(Tbuser tbuser);
    int deleteUser(int userid);
    //全选删除
    int deleteUsers(@Param("ids") int ids[]);
}
