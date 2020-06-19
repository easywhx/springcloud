package cn.how2j.springcloud.pojo;



import cn.how2j.springcloud.util.DateUtils;

import java.util.Date;

public class LaboratoryLog {
    private Integer id;

    private Integer isYy;

    private Date time;

    private Integer laboratory_id;

    private Integer user_id;

    private Date endTime;

    private Integer userQx_id;

    private User user;

    private Laboratory laboratory;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsYy() {
        return isYy;
    }

    public void setIsYy(Integer isYy) {
        this.isYy = isYy;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = DateUtils.convert(time);
    }

    public Integer getLaboratory_id() {
        return laboratory_id;
    }

    public void setLaboratory_id(Integer laboratory_id) {
        this.laboratory_id = laboratory_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = DateUtils.convert(endTime);
    }

    public Integer getUserQx_id() {
        return userQx_id;
    }

    public void setUserQx_id(Integer userQx_id) {
        this.userQx_id = userQx_id;
    }
}