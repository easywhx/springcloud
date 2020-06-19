package cn.how2j.springcloud.pojo;

import cn.how2j.springcloud.util.DateUtils;

import java.util.Date;

public class Laboratory {
    private Integer id;

    private String address;

    private String bz;

    private String fzr;

    private String fzrDh;

    private Integer isDelete;

    private Integer isYy;

    private String name;

    private Date time;

    private Integer user_id;

    private Integer laboratoryLogId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr == null ? null : fzr.trim();
    }

    public String getFzrDh() {
        return fzrDh;
    }

    public void setFzrDh(String fzrDh) {
        this.fzrDh = fzrDh == null ? null : fzrDh.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsYy() {
        return isYy;
    }

    public void setIsYy(Integer isYy) {
        this.isYy = isYy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = DateUtils.convert(time);
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getLaboratoryLogId() {
        return laboratoryLogId;
    }

    public void setLaboratoryLogId(Integer laboratoryLogId) {
        this.laboratoryLogId = laboratoryLogId;
    }
}