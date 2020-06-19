package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Role;
import cn.how2j.springcloud.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wanhongxu on 2020/4/1.
 */
@Component
public class RoleClientFeignHystrix implements RoleClientFeign {


    @Override
    public List<Role> list() {
        return null;
    }
}
