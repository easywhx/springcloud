package cn.how2j.springcloud.mapper;


import cn.how2j.springcloud.pojo.LaboratoryLog;
import java.util.List;

public interface LaboratoryLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LaboratoryLog record);

    int insertSelective(LaboratoryLog record);

//    List<LaboratoryLog> selectByExample(LaboratoryLogExample example);

    LaboratoryLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LaboratoryLog record);

    int updateByPrimaryKey(LaboratoryLog record);
}