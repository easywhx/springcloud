package cn.how2j.springcloud.mapper;



import cn.how2j.springcloud.pojo.Repair;

import java.util.List;

public interface RepairMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Repair record);

    int insertSelective(Repair record);

//    List<Repair> selectByExample(RepairExample example);

    List<Repair> search(Repair record);

    Repair selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
}