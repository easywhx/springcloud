package cn.how2j.springcloud.pojo;

import cn.how2j.springcloud.util.DateUtils;

import java.util.Date;

/**
 * ClassName: User <br/>
 * Function: TODO. <br/>
 * Date: 2020/6/16 10:35 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
public class User {
    private Integer id;

    private String bj;

    private Integer isDelete;

    private Integer isSh;

    private String name;

    private String number;

    private String pass;

    private String phone;

    private String realName;

    private Date time;

    private String xy;

    private Integer role_id;

    private String address;

    private String bz;

    private String fzr;

    private String fzrDh;

    private Integer isYy;

    private Integer user_id;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj == null ? null : bj.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsSh() {
        return isSh;
    }

    public void setIsSh(Integer isSh) {
        this.isSh = isSh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = DateUtils.convert(time);
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy == null ? null : xy.trim();
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
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

    public Integer getIsYy() {
        return isYy;
    }

    public void setIsYy(Integer isYy) {
        this.isYy = isYy;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
