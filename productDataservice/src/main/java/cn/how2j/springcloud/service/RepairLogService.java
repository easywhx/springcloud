package cn.how2j.springcloud.service;


import cn.how2j.springcloud.pojo.Repair;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/25.
 */
public interface RepairLogService {

    List<Repair> getList(Repair c);
    void add(Repair c);
    void delete(int id);
    void update(Repair c);
    Repair get(int id);
    List list();

    List search(Repair c);
}
