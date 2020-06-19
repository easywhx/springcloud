package cn.how2j.springcloud.mapper;



import cn.how2j.springcloud.pojo.Curriculum;

import java.util.List;

/**
 * ClassName: CurriculumMapper <br/>
 * Function: TODO. <br/>
 * Date: 2020/5/12 20:33 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
public interface CurriculumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Curriculum record);

    int insertSelective(Curriculum record);

    List<Curriculum> search(Curriculum record);

    Curriculum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Curriculum record);

    int updateByPrimaryKey(Curriculum record);
}
