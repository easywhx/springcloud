package cn.how2j.springcloud.pojo;



import cn.how2j.springcloud.util.DateUtils;

import java.util.Date;

public class Notice {
    private Integer id;

    private Integer isDelete;

    private String name;

    private String nr;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr == null ? null : nr.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = DateUtils.convert(time);
    }
}