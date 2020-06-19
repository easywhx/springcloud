package cn.how2j.springcloud.service.impl;

import cn.how2j.springcloud.mapper.UserMapper;
import cn.how2j.springcloud.pojo.Role;
import cn.how2j.springcloud.pojo.User;
import cn.how2j.springcloud.pojo.UserExample;
import cn.how2j.springcloud.service.RoleService;
import cn.how2j.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleService roleService;

    @Override
    public void add(User c) {
        userMapper.insert(c);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(User c) {
        userMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public User get(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        Role role = roleService.get(user.getRole_id());
        user.setRole(role);
        return user;
    }



    @Override
    public List list() {
        UserExample example = new UserExample();
        example.createCriteria().andIsDeleteEqualTo(0);
        example.setOrderByClause("id desc");
        List<User> results = userMapper.selectByExample(example);
        user_roles(results);
        return results;
    }

    @Override
    public List search(User c) {
        c.setIsDelete(0);
        List<User> results = userMapper.search(c);
        user_roles(results);
        return results;
    }

    @Override
    public User get(String name, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name).andPassEqualTo(password);
        List<User> results = userMapper.selectByExample(example);
        user_roles(results);
        if(results.isEmpty()){
            return null;
        }
        return results.get(0);
    }

    @Override
    public User get(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> results = userMapper.selectByExample(example);
        user_roles(results);
        if(results.isEmpty()){
            return null;
        }
        return results.get(0);
    }

    public void user_roles(List<User> results){
        for(User user:results){
            Role role=roleService.get(user.getRole_id());
            user.setRole(role);
        }
    }
}
