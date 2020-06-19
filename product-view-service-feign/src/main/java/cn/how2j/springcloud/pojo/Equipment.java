package cn.how2j.springcloud.pojo;



import cn.how2j.springcloud.util.DateUtils;

import java.util.Date;

public class Equipment {
    private Integer id;

    private String bz;

    private Integer isBx;

    private Integer isDelete;

    private Double jg;

    private String sbxlh;

    private Date time;

    private String xh;

    private String zzs;

    private Integer laboratory_id;

    private Date fwTime;

    private String ht;

    private Integer isFw;

    private String photo;

    private Integer bxLogid;

    private Integer isJy;

    private Integer jyId;

    private Integer jyUser_id;

    private Laboratory laboratory;

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

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Integer getIsBx() {
        return isBx;
    }

    public void setIsBx(Integer isBx) {
        this.isBx = isBx;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Double getJg() {
        return jg;
    }

    public void setJg(Double jg) {
        this.jg = jg;
    }

    public String getSbxlh() {
        return sbxlh;
    }

    public void setSbxlh(String sbxlh) {
        this.sbxlh = sbxlh == null ? null : sbxlh.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = DateUtils.convert(time);
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public String getZzs() {
        return zzs;
    }

    public void setZzs(String zzs) {
        this.zzs = zzs == null ? null : zzs.trim();
    }

    public Integer getLaboratory_id() {
        return laboratory_id;
    }

    public void setLaboratory_id(Integer laboratory_id) {
        this.laboratory_id = laboratory_id;
    }

    public Date getFwTime() {
        return fwTime;
    }

    public void setFwTime(Date fwTime) {
        this.fwTime = fwTime;
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht == null ? null : ht.trim();
    }

    public Integer getIsFw() {
        return isFw;
    }

    public void setIsFw(Integer isFw) {
        this.isFw = isFw;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getBxLogid() {
        return bxLogid;
    }

    public void setBxLogid(Integer bxLogid) {
        this.bxLogid = bxLogid;
    }

    public Integer getIsJy() {
        return isJy;
    }

    public void setIsJy(Integer isJy) {
        this.isJy = isJy;
    }

    public Integer getJyId() {
        return jyId;
    }

    public void setJyId(Integer jyId) {
        this.jyId = jyId;
    }

    public Integer getJyUser_id() {
        return jyUser_id;
    }

    public void setJyUser_id(Integer jyUser_id) {
        this.jyUser_id = jyUser_id;
    }
}