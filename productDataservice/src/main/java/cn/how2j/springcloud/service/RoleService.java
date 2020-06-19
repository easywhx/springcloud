package cn.how2j.springcloud.service;


import cn.how2j.springcloud.pojo.Role;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/16.
 */
public interface RoleService {
    void add(Role c);
    void delete(int id);
    void update(Role c);
    Role get(int id);
    List list();
}
