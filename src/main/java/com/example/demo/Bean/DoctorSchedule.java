package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class DoctorSchedule implements Serializable {
    /**
     * 排班ID，主键自增
     */
    @Id
    @Column(name="d_schedule_id")
    @JsonProperty("doctorscheduleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorScheduleId;

    /**
     * 医生ID，外键参考医生表
     */
    @Column(name = "doctor_id")
    @JsonProperty("doctorid")
    private int doctorId;

    /**
     * 医生ID，外键参考医生表
     */
    @Column(name = "doctor_name")
    @JsonProperty("doctorname")
    private String doctorName;

    /**
     * 科室ID，外键参考科室表
     */
    @Column(name = "dept_id")
    @JsonProperty("deptid")
    private int deptId;

    /**
     * 排班日期
     */
    @Column
    private Date date;

    /**
     * 状态
     */
    @Column(name = "state")
    @JsonProperty("state")
    private int state;

    /**
     * 周几
     */
    @Column(name = "week")
    @JsonProperty("week")
    private int week;


    public DoctorSchedule(){
        this.doctorScheduleId = 0;
        this.date = new Date();
        this.week = 1;
        this.state = 0;
        this.doctorName="";
    }

    private static final long serialVersionUID = 1L;

    public Integer getdoctorScheduleId() {
        return doctorScheduleId;
    }

    public void setdoctorScheduleId(Integer dScheduleId) {
        this.doctorScheduleId = dScheduleId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getweek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getState() {
        return state;
    }
    public String getDoctorName(){
        return doctorName;
    }
    public  void  setDoctorName(String name){
        doctorName = name;
    }

    public void setState(int state) {
        this.state = state;
    }



}