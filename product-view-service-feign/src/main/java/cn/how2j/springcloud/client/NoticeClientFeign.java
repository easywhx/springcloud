package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Notice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by wanhongxu on 2020/6/15.
 */
@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback = NoticeClientFeignHystrix.class)
public interface NoticeClientFeign {

    @RequestMapping(value = "/notice_list",method = RequestMethod.GET)
    List<Notice> search(@RequestParam(value = "id",required = false) Integer id, @RequestParam(value = "name",required = false) String name);

    @RequestMapping(value = "/notice_get",method = RequestMethod.GET)
    Notice get(@RequestParam("id") Integer id);

    @RequestMapping(value = "/notice_save",method = RequestMethod.POST,consumes = "application/json")
    void add(@RequestBody Notice c);

    @RequestMapping(value = "/notice_update",method = RequestMethod.POST)//加上consume属性转化json会出问题，因为notice对象中的属性字段date为空时，转化为json时传输报错
    void update(@RequestBody Notice c);
}
