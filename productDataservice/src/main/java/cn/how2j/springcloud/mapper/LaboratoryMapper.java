package cn.how2j.springcloud.mapper;



import cn.how2j.springcloud.pojo.Laboratory;

import java.util.List;

public interface LaboratoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Laboratory record);

    int insertSelective(Laboratory record);

//    List<Laboratory> selectByExample(LaboratoryExample example);

    List<Laboratory> search(Laboratory record);

    Laboratory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Laboratory record);

    int updateByPrimaryKey(Laboratory record);
}