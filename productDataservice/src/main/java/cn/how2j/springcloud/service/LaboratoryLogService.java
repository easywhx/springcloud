package cn.how2j.springcloud.service;

import cn.how2j.springcloud.pojo.LaboratoryLog;

import java.util.List;

/**
 * Created by wanhongxu on 2020/3/25.
 */
public interface LaboratoryLogService {
    LaboratoryLog get(int id);
    List list();
    void add(LaboratoryLog c);
    void update(LaboratoryLog c);
}
