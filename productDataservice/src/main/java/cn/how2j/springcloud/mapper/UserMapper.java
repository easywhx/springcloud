package cn.how2j.springcloud.mapper;

import cn.how2j.springcloud.pojo.User;
import cn.how2j.springcloud.pojo.UserExample;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    List<User> search(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}