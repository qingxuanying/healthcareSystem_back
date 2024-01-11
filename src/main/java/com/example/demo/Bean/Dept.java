package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Dept implements Serializable {
    /**
     * 科室ID
     */
    @Id
    @Column(name="dept_id")
    @JsonProperty("deptid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    /**
     * 科室名称
     */
    @Column(name = "dept_name")
    @JsonProperty("deptname")
    private String deptName;


    /**
     * 科室值班状态
     */
    @Column(name = "state")
    @JsonProperty("state")
    private String state;

    /**
     * 值班医生ID
     */
    @Column(name = "duty_doctor")
    @JsonProperty("dutydoctor")
    private int dutyDoctor;

    /**
     * 逻辑删除，默认为false
     */
    @Column
    private Boolean isDelete;

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDutyDoctor(int dutyDoctor) {
        this.dutyDoctor = dutyDoctor;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }



    public Dept(){
        this.deptId = 0;
        this.isDelete = false;
        this.deptName = "";
        this.state="0000000";
        this.dutyDoctor=0;
    }

    private static final long serialVersionUID = 1L;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDutyDoctor() {
        return dutyDoctor;
    }

    public void setDutyDoctor(Integer dutyDoctor) {
        this.dutyDoctor = dutyDoctor;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }


    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", deptName=").append(deptName);
        sb.append(", dutyDoctor=").append(dutyDoctor);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }*/
}