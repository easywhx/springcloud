package cn.how2j.springcloud.pojo;

import cn.how2j.springcloud.util.DateUtils;

import java.util.Date;

public class EquipmentLog {
    private Integer id;

    private Date endTime;

    private Integer isYy;

    private Date time;

    private Integer equipment_id;

    private Integer qx_id;

    private Integer user_id;

    private User users;

    private Equipment equipment;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    private byte[] qx;

    private byte[] user;

    public byte[] getQx() {
        return qx;
    }

    public void setQx(byte[] qx) {
        this.qx = qx;
    }

    public byte[] getUser() {
        return user;
    }

    public void setUser(byte[] user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = DateUtils.convert(endTime);
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

    public Integer getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(Integer equipment_id) {
        this.equipment_id = equipment_id;
    }

    public Integer getQx_id() {
        return qx_id;
    }

    public void setQx_id(Integer qx_id) {
        this.qx_id = qx_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}