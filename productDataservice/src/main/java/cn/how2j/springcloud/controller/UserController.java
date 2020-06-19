package cn.how2j.springcloud.controller;

import cn.how2j.springcloud.pojo.User;
import cn.how2j.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: UserController <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/17 14:36 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user_save")
    public void add(@RequestBody User c){
        userService.add(c);
    }
    public void delete(int id){}

    @PostMapping("/user_update")
    public void update(@RequestBody User c){
        userService.update(c);
    }

    @RequestMapping("/user_get")
    public User get(int id){
        return userService.get(id);
    }

    public List list(){
        return null;
    }

    @RequestMapping("/user_list")
    @ResponseBody
    public List search( User c){
        return userService.search(c);
    }

    public User get(String name, String password){
        return userService.get(name,password);
    }

    public User get(String name){
        return userService.get(name);
    }
}
