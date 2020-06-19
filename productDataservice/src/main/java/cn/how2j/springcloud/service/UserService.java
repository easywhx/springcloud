package cn.how2j.springcloud.service;



import cn.how2j.springcloud.pojo.User;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/16.
 */
public interface UserService {

    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
//    List list(User c);
    List list();

    List search(User c);

    User get(String name, String password);

    User get(String name);

}
