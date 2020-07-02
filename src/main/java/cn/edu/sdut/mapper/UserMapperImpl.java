package cn.edu.sdut.mapper;

import cn.edu.sdut.entity.Tbuser;

public class UserMapperImpl {

    public String queryUsers(Tbuser tbuser){
        String sql="select * from tbuser order by userid desc";
        return sql;
    }
}
