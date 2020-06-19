package cn.how2j.springcloud.controller;

import cn.how2j.springcloud.pojo.User;
import cn.how2j.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoginController <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/16 10:34 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@RequestMapping("")
@Controller
public class LoginController {

    @Autowired
    UserService userService;
    /**
     * 登录验证
     */
    @PostMapping("/login_index")
    @ResponseBody
    public User index(@RequestParam("name") String name, @RequestParam("password") String password) throws IOException {
        User user = userService.get(name,password);
        return user;
    }


}
