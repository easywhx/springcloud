package cn.how2j.springcloud.controller;

import cn.how2j.springcloud.pojo.Role;
import cn.how2j.springcloud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: RoleController <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/17 15:10 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/role_list")
    public List<Role> list(){
        return roleService.list();
    }
}
