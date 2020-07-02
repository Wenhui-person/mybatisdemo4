package cn.edu.sdut.mapper;

import cn.edu.sdut.entity.Tbuser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from tbuser where userid=#{userid}")
    Tbuser queryUserById(int userid);
    @Select("select count(*) from tbuser")
    int queryUserCount();
    Tbuser queryUserByusername(String username);
    Tbuser login(Tbuser tbuser);
    @SelectProvider(type = UserMapperImpl.class,method = "queryUsers")
    List<Tbuser> queryUsers(Tbuser tbuser);
    @Insert(" insert into tbuser values(null,#{username},#{password},#{userroles},#{nickname},now())")
    int addUser(Tbuser tbuser);
    @Update("update tbuser set username=#{username},password=#{password},nickname=#{nickname} where userid=#{userid}")
    int updateUser(Tbuser tbuser);
    @Delete("delete from tbuser where userid=#{userid}")
    int deleteUser(int userid);
    //全选删除
    int deleteUsers(@Param("ids") int ids[]);
}
