package cn.how2j.springcloud.web;

import cn.how2j.springcloud.client.NoticeClientFeign;
import cn.how2j.springcloud.pojo.Notice;
import cn.how2j.springcloud.pojo.User;
import cn.how2j.springcloud.util.Pager;
import cn.how2j.springcloud.util.SystemContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: NoticeController <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/15 9:20 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@Controller
public class NoticeController {

    @Autowired
    NoticeClientFeign noticeClientFeign;

    private Map<Object, Object> map = new HashMap();

    @RequestMapping(value = "/notice_list")
    public String list(HttpSession session, Model model, Pager pager, Notice notice){
        User user = (User)session.getAttribute("user");
        if(user==null){
            session.setAttribute("login", 1);
            return "notice/list";
        }else {
            PageHelper.offsetPage(pager.getOffset(),pager.getSize());
            List<Notice> pgs = noticeClientFeign.search(notice.getId(),notice.getName());
            int total = (int)new PageInfo<>(pgs).getTotal();
            pager.setTotal(total);
            model.addAttribute("pgs", pgs);
            model.addAttribute("pagers", pager);
            model.addAttribute("role",user.getRole());
            model.addAttribute("bean",notice);
            return "notice/list";
        }
    }

    //添加通知界面
    @RequestMapping("notice_add")
    public String user_add(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        if (user!=null){
            return "notice/add";
        }
        return "";
    }


    //添加通知信息
    @RequestMapping("notice_save")
    @ResponseBody
    public Map<Object, Object> save(Notice c)throws IOException {
        c.setTime(new Date());
        c.setIsDelete(0);
        noticeClientFeign.add(c);
        map.put("flag",true);
        map.put("url","notice_list");
        return map;

    }

    //通知详情页面
    @RequestMapping("notice_details")
    public String details(int id,Model model) {
        Notice notice = noticeClientFeign.get(id);
        model.addAttribute("bean",notice);
        return "notice/details";
    }

    //通知编辑界面
    @RequestMapping("notice_edit")
    public String edit(int id,Model model) {
        Notice notice = noticeClientFeign.get(id);
        model.addAttribute("bean",notice);
        return "notice/edit";
    }

    //通知修改
    @RequestMapping("notice_update")
    @ResponseBody
    public Map<Object, Object> update(Notice c) throws IOException {
        c.setTime(new Date());
        noticeClientFeign.update(c);
        map.put("flag", true);
        map.put("url", "notice_list");
        return map;
    }

    //删除通知
    @RequestMapping("notice_delete")
    @ResponseBody
    public Map<Object,Object> delete(int id) throws IOException {
        Notice notice = noticeClientFeign.get(id);
        notice.setIsDelete(1);
        noticeClientFeign.update(notice);
        map.put("flag", true);
        map.put("url", "notice_list");
        return map;
    }


}
