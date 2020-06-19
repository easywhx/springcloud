package cn.how2j.springcloud.mapper;



import cn.how2j.springcloud.pojo.Equipment;

import java.util.List;

public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

//    List<Equipment> selectByExample(EquipmentExample example);

    List<Equipment> search(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}