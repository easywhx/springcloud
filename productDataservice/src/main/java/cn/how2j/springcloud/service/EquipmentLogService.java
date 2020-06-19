package cn.how2j.springcloud.service;

import cn.how2j.springcloud.pojo.EquipmentLog;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/25.
 */
public interface EquipmentLogService {

    void add(EquipmentLog c);
    void delete(int id);
    void update(EquipmentLog c);
    EquipmentLog get(int id);
    List list();
}
