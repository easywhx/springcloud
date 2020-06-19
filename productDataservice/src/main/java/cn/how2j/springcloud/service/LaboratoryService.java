package cn.how2j.springcloud.service;


import cn.how2j.springcloud.pojo.Laboratory;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/19.
 */
public interface LaboratoryService {

    void add(Laboratory c);
    void delete(int id);
    void update(Laboratory c);
    Laboratory get(int id);
    List list();
    List search(Laboratory c);
}
