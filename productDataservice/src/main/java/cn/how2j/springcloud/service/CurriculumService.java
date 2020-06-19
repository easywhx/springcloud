package cn.how2j.springcloud.service;


import cn.how2j.springcloud.pojo.Curriculum;

import java.util.List;

/**
 * Created by wanhongxu on 2020/5/12.
 */
public interface CurriculumService {
    void add(Curriculum c);
    void delete(int id);
    void update(Curriculum c);
    Curriculum get(int id);
    List list();

    List search(Curriculum c);
}
