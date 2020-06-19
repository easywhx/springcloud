package cn.how2j.springcloud.service;

import cn.how2j.springcloud.pojo.Notice;

import java.util.List;

/**
 * Created by wanhongxu on 2020/6/15.
 */
public interface NoticeService {
    void add(Notice c);
    void delete(int id);
    void update(Notice c);
    Notice get(int id);
    List list();
    List search(Notice c);
}
