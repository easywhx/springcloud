package cn.how2j.springcloud.controller;

import cn.how2j.springcloud.pojo.Notice;
import cn.how2j.springcloud.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "/notice_list")
    public List search(Notice notice){
        List<Notice> pgs = noticeService.search(notice);
        return pgs;
    }

    @RequestMapping("/notice_get")
    public Notice get(int id) {
        Notice notice = noticeService.get(id);
        return notice;
    }

    @PostMapping("/notice_save")
    public void add(@RequestBody Notice c){
        noticeService.add(c);
    }

    @PostMapping("/notice_update")
    public void update(@RequestBody Notice c){
        noticeService.update(c);
    }
}
