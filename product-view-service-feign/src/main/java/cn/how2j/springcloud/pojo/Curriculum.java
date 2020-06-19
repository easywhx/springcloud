package cn.how2j.springcloud.pojo;



import cn.how2j.springcloud.util.DateUtils;

import java.util.Date;

/**
 * ClassName: Curriculum <br/>
 * Function: TODO. <br/>
 * Date: 2020/5/12 20:26 <br/>
 *
 * @author wanhongxu
 * @version 1.0
 * @since JDK 1.7
 */
public class Curriculum {
    private Integer id;

    private String curriculum;

    private Integer isDelete;

    private Integer laboratory_id;

    private Date time;

    private String ht;

    private Laboratory laboratory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum == null ? null : curriculum.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getLaboratory_id() {
        return laboratory_id;
    }

    public void setLaboratory_id(Integer laboratory_id) {
        this.laboratory_id = laboratory_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = DateUtils.convert(time);
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht == null ? null : ht.trim();
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }
}
