package cn.how2j.springcloud.service;


import cn.how2j.springcloud.pojo.Equipment;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/19.
 */
public interface EquipmentService {
    void add(Equipment c);
    void delete(int id);
    void update(Equipment c);
    Equipment get(int id);
    List list();

    List search(Equipment c);
}
