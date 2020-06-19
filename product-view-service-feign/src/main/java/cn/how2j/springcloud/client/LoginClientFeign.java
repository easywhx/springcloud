package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Notice;
import cn.how2j.springcloud.pojo.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by wanhongxu on 2020/6/15.
 */
@FeignClient(value = "PRODUCT-DATA-SERVICE")
public interface LoginClientFeign {


    @RequestMapping(value = "/login_index",method = RequestMethod.POST)
    User get(@RequestParam("name") String name, @RequestParam("password") String password);
}
