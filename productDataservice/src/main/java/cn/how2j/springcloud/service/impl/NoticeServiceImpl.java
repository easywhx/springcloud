package cn.how2j.springcloud.service.impl;

import cn.how2j.springcloud.mapper.NoticeMapper;
import cn.how2j.springcloud.pojo.Notice;
import cn.how2j.springcloud.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: NoticeServiceImpl <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/15 9:25 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public void add(Notice c) {
        noticeMapper.insert(c);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Notice c) {
        noticeMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public Notice get(int id) {
        return noticeMapper.get(id);
    }

    @Override
    public List list() {
        return null;
    }

    @Override
    public List search(Notice c) {
        c.setIsDelete(0);
        return noticeMapper.search(c);
    }
}
