package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wanhongxu on 2020/4/1.
 */
@Component
public class UserClientFeignHystrix implements UserClientFeign {

    @Override
    public List<User> search(User c) {
        return null;
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public User get(String name) {
        return null;
    }

    @Override
    public void add(User c) {

    }

    @Override
    public void update(User c) {

    }
}
