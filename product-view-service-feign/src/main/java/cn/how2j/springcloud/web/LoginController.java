package cn.how2j.springcloud.web;

import cn.how2j.springcloud.client.LoginClientFeign;
import cn.how2j.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    LoginClientFeign loginClientFeign;



    //登录界面
    @RequestMapping("login_tuichu")
    public String login_tuichu(){
        return "login/login";
    }

    /**
     * 登录验证
     */
    @RequestMapping("login_index")
    @ResponseBody
    public Map<Object,Object> index(@RequestParam("name") String name, @RequestParam("pass") String password, Model model, HttpSession session) throws IOException {
        User user1 = loginClientFeign.get(name,password);
        HashMap<Object,Object> map = new HashMap<>();
        if (user1 != null){
            if (user1.getIsSh() == 1){
                if (user1.getRole().getEnName().equals("admin")){
                    session.removeAttribute("login");
                    session.setAttribute("user", user1);
                }
                if (user1.getRole().getEnName().equals("js")){
                    session.removeAttribute("login");
                    session.setAttribute("user", user1);
                }
                if (user1.getRole().getEnName().equals("xs")){
                    session.removeAttribute("login");
                    session.setAttribute("user", user1);
                }

                map.put("flag",1);
                map.put("url","login_indexs");
                map.put("id",user1.getId()+user1.getRole().getEnName());
            } else {
                map.put("flag", 2);
            }
        } else {
            map.put("flag", 3);

        }
        return map;
    }
    //进入到主界面
    @RequestMapping("login_indexs")
    public String indexs(HttpSession session, Model model) throws IOException {
        User u = (User) session.getAttribute("user");
        if (u != null){
            model.addAttribute("role",u.getRole().getEnName());
        }
        return "login/indexs";
    }

}
