package cn.how2j.springcloud.mapper;


import cn.how2j.springcloud.pojo.Role;
import cn.how2j.springcloud.pojo.RoleExample;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}