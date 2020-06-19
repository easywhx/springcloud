package cn.how2j.springcloud.service.impl;


import cn.how2j.springcloud.mapper.RoleMapper;
import cn.how2j.springcloud.pojo.Role;
import cn.how2j.springcloud.pojo.RoleExample;
import cn.how2j.springcloud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/16.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Override
    public void add(Role c) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Role c) {

    }

    @Override
    public Role get(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list() {
        RoleExample example = new RoleExample();
        example.setOrderByClause("id desc");
        return roleMapper.selectByExample(example);
    }
}
