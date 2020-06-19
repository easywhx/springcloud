package cn.how2j.springcloud.web;

import cn.how2j.springcloud.client.RoleClientFeign;
import cn.how2j.springcloud.client.UserClientFeign;
import cn.how2j.springcloud.pojo.Role;
import cn.how2j.springcloud.pojo.User;
import cn.how2j.springcloud.util.Pager;
import cn.how2j.springcloud.util.SystemContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * ClassName: UserController <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/17 14:42 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    UserClientFeign userClientFeign;
    @Autowired
    RoleClientFeign roleClientFeign;

    private Map<Object, Object> map = new HashMap();
    private List pgs;

    //用户列表
    @RequestMapping("/user_list")
    public String list(HttpSession session, Model model, Pager pager, User user) throws IOException {
        User user1 = (User) session.getAttribute("user");
        if (user1 == null || user1.getId() == null) {
            session.setAttribute("login", 1);
            return "user/list";
        }
        Role role = user1.getRole();
        PageHelper.offsetPage(pager.getOffset(),pager.getSize());
        if (role.getEnName().equals("admin")) {
            pgs = userClientFeign.search(user);
        } else {
            user.setRole_id(3);
            pgs = userClientFeign.search(user);
        }

        System.out.println("user不是空" + user.toString());
        int total = (int) new PageInfo<>(pgs).getTotal();
        pager.setTotal(total);
        model.addAttribute("pgs", pgs);
        model.addAttribute("pagers", pager);
        model.addAttribute("role", role);
        model.addAttribute("bean", user);
        return "user/list";
    }

    //用户添加界面
    @RequestMapping("user_add")
    public String user_add(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Role> ros = roleClientFeign.list();
            model.addAttribute("datas", ros);
            return "user/add";
        }
        return "";
    }

    //用户信息添加
    @PostMapping("/user_save")
    @ResponseBody
    public Map<Object, Object> user_save(User user) throws IOException {
        if (userClientFeign.get(user.getName()) != null) {
            map.put("flag", false);
            return map;
        } else {
            user.setIsYy(0);
            user.setTime(new Date());
            user.setIsDelete(0);
            user.setIsSh(0);
            userClientFeign.add(user);
            map.put("flag", true);
            map.put("url", "user_list");
            return map;
        }
    }


    /**
     * 审核
     *
     * @return
     */
    @RequestMapping("user_updateSh")
    @ResponseBody
    public Map<Object, Object> updateSh(int id) throws IOException {
        User user = userClientFeign.get(id);
        user.setIsSh(1);
        userClientFeign.update(user);
        map.put("flag", true);
        map.put("url", "user_list");
        return map;
    }

    /**
     * 查询修改页面
     *
     * @return
     */
    @RequestMapping("user_edit")
    public String edit(int id, Model model) {
        User user = userClientFeign.get(id);
        model.addAttribute("bean", user);
        return "user/edit";
    }

    /**
     * 个人信息修改页面
     *
     * @return
     */
    @RequestMapping("person_info")
    public String person_info(Model model, HttpSession session) {
        User user1 = (User) session.getAttribute("user");
        User user = userClientFeign.get(user1.getId());
        model.addAttribute("bean", user);
        return "user/edit";
    }

    /**
     * 用户更新修改
     *
     * @return
     */
    @RequestMapping("user_update")
    @ResponseBody
    public Map<Object, Object> update(User user) throws IOException {
        if (user.getPass().equals("")) {
            user.setPass(null);
        }
        user.setTime(new Date());
        userClientFeign.update(user);
        map.put("flag", true);
        map.put("url", "user_list");
        return map;
    }

    //用户删除
    @RequestMapping("user_delete")
    @ResponseBody
    public Map<Object, Object> delete(int id) throws IOException {
        User user1 = userClientFeign.get(id);
        user1.setIsDelete(1);
        userClientFeign.update(user1);
        map.put("flag", true);
        map.put("url", "user_list");
        return map;
    }

    //用户密码修改
    @RequestMapping("user_updatePw")
    @ResponseBody
    public Map<Object, Object> updatePwd(User u) throws IOException {
        userClientFeign.update(u);
        map.put("flag", true);
        map.put("url", "user_list");
        return map;
    }

    /**
     * 导入学员数据清单Excel
     *
     * @param file
     * @param clientid
     * @return
     * @throws IOException
     */
    @PostMapping("/importUsers")
    @ResponseBody
    public Map<Object, Object> importUsers(@RequestParam MultipartFile file, Integer clientid, HttpServletRequest request) throws IOException {

        List<User> list = new ArrayList<User>();
        Workbook workbook = null;
//      System.out.println(file.getOriginalFilename());
        //创建Excel，读取文件内容
        workbook = new XSSFWorkbook(file.getInputStream());

        //获取第一个工作表
        Sheet sheet = workbook.getSheetAt(0);

        //获取sheet中第一行行号
        int firstRowNum = sheet.getFirstRowNum();
        //获取sheet中最后一行行号
        int lastRowNum = sheet.getLastRowNum();

        try {
            //循环插入数据
            for (int i = firstRowNum + 1; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);

                User user = new User();
                Cell bj = row.getCell(0);
                if (bj != null) {
                    bj.setCellType(Cell.CELL_TYPE_STRING);
                    user.setBj((bj.getStringCellValue()));
                }
                user.setIsDelete(0);
                user.setIsSh(1);
                Cell name = row.getCell(1);
                if (name != null) {
                    name.setCellType(Cell.CELL_TYPE_STRING);
                    user.setName(name.getStringCellValue());
                }
                Cell number = row.getCell(2);
                if (number != null) {
                    number.setCellType(Cell.CELL_TYPE_STRING);
                    user.setNumber(number.getStringCellValue());
                }
                Cell pass = row.getCell(3);
                if (pass != null) {
                    pass.setCellType(Cell.CELL_TYPE_STRING);
                    user.setPass(pass.getStringCellValue());
                }
                Cell phone = row.getCell(4);
                if (phone != null) {
                    phone.setCellType(Cell.CELL_TYPE_STRING);
                    user.setPhone(phone.getStringCellValue());
                }
                Cell realName = row.getCell(5);
                if (realName != null) {
                    realName.setCellType(Cell.CELL_TYPE_STRING);
                    user.setRealName(realName.getStringCellValue());
                }
                user.setTime(new Date());
                Cell xy = row.getCell(6);
                if (xy != null) {
                    xy.setCellType(Cell.CELL_TYPE_STRING);
                    user.setXy(xy.getStringCellValue());
                }
                user.setRole_id(3);
                user.setIsYy(0);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", false);
            return map;
        }
        for (User user : list) {
            userClientFeign.add(user);
        }
        map.put("flag", true);
        map.put("url", "user_list");
        return map;
    }

}
