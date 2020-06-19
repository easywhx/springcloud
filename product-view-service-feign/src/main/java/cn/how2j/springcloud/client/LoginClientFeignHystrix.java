package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Notice;
import cn.how2j.springcloud.pojo.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanhongxu on 2020/4/1.
 */
@Component
public class LoginClientFeignHystrix implements LoginClientFeign {

//    @Override
//    public List<Notice> search(Notice notice) {
//        List<Notice> result = new ArrayList<>();
//        Notice notice1 = new Notice();
//        notice1.setName(notice.getName()+"这个字段查询错误");
//        result.add(notice1);
//        return result;
//    }



    @Override
    public User get(String name, String password) {
        return null;
    }
}
