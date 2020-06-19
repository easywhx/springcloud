package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by wanhongxu on 2020/6/17.
 */
@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback = RoleClientFeignHystrix.class)
public interface RoleClientFeign {
    @RequestMapping(value = "/role_list",method = RequestMethod.GET)
    List<Role> list();
}
