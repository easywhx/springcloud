package cn.how2j.springcloud.pojo;


import cn.how2j.springcloud.util.DateUtils;

import java.util.Date;

public class Repair {
    private Integer id;

    private Date bxTime;

    private String bz;

    private Date endTime;

    private Integer isDelete;

    private String title;

    private String wz;

    private Integer equipment_id;

    private Equipment equipment;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBxTime() {
        return bxTime;
    }

    public void setBxTime(Date bxTime) {
        this.bxTime = DateUtils.convert(bxTime);
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = DateUtils.convert(endTime);
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz == null ? null : wz.trim();
    }

    public Integer getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(Integer equipment_id) {
        this.equipment_id = equipment_id;
    }
}