package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Notice;
import cn.how2j.springcloud.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhongxu on 2020/4/1.
 */
@Component
public class NoticeClientFeignHystrix implements NoticeClientFeign {

//    @Override
//    public List<Notice> search(Notice notice) {
//        List<Notice> result = new ArrayList<>();
//        Notice notice1 = new Notice();
//        notice1.setName(notice.getName()+"这个字段查询错误");
//        result.add(notice1);
//        return result;
//    }

    @Override
    public List<Notice> search(Integer id, String name) {
        List<Notice> result = new ArrayList<>();
        Notice notice1 = new Notice();
        notice1.setName(name+"这个字段查询错误");
        notice1.setId(id);
        result.add(notice1);
        return result;
    }

    @Override
    public Notice get(Integer id) {
        return null;
    }

    @Override
    public void add(Notice c) {
    }

    @Override
    public void update(Notice c) {

    }
}
