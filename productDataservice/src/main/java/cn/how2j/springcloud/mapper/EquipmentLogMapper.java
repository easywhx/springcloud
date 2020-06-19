package cn.how2j.springcloud.mapper;


import cn.how2j.springcloud.pojo.EquipmentLog;

import java.util.List;

public interface EquipmentLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentLog record);

    int insertSelective(EquipmentLog record);


//    List<EquipmentLog> selectByExample(EquipmentLogExample example);

    EquipmentLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentLog record);

    int updateByPrimaryKeyWithBLOBs(EquipmentLog record);

    int updateByPrimaryKey(EquipmentLog record);
}