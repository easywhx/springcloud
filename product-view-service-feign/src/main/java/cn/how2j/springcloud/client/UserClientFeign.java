package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ClassName: UserClientFeign <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/17 14:43 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback = UserClientFeignHystrix.class)
public interface UserClientFeign {
    @RequestMapping(value = "/user_list",method = RequestMethod.POST,consumes = "application/json")
    List<User> search(@RequestBody User c);

    @RequestMapping(value = "/user_get",method = RequestMethod.GET)
    User get(@RequestParam("id") Integer id);

    @RequestMapping(value = "/user_get",method = RequestMethod.GET)
    User get(@RequestParam("name") String name);

    @RequestMapping(value = "/user_save",method = RequestMethod.POST,consumes = "application/json")
    void add(@RequestBody User c);

    @RequestMapping(value = "/user_update",method = RequestMethod.POST)//加上consume属性转化json会出问题，因为User对象中的属性字段date为空时，转化为json时传输报错
    void update(@RequestBody User c);
}
