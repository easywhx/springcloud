package cn.how2j.springcloud.mapper;

import cn.how2j.springcloud.pojo.Notice;
import cn.how2j.springcloud.pojo.NoticeExample;

import java.util.List;

/**
 * Created by wanhongxu on 2020/6/15.
 */
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    List<Notice> search(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    Notice get(int id);

}
