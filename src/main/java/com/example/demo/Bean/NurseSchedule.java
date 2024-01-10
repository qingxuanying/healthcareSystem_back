package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class NurseSchedule implements Serializable {
    /**
     * 排班ID，主键自增
     */
    @Id
    @Column(name="n_schedule_id")
    @JsonProperty("nscheduleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nScheduleId;

    /**
     * 护士ID，外键参考护士表
     */
    @Column(name = "nurse_id")
    @JsonProperty("nurseid")
    private int nurseId;

    /**
     * 科室ID，外键参考科室表
     */
    @Column(name = "dept_id")
    @JsonProperty("deptid")
    private int deptId;

    /**
     * 排班日期
     */
    @Column(name = "date")
    @JsonProperty("date")
    private Date date;

    /**
     * 上班时间
     */
    @Column(name = "start_time")
    @JsonProperty("starttime")
    private Date startTime;

    /**
     * 下班时间
     */
    @Column(name = "end_time")
    @JsonProperty("endtime")
    private Date endTime;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    public NurseSchedule(){
        this.nScheduleId = 0;
        this.version = 0;
        this.date = new Date(1900,0,1,0,0,0);
        this.startTime = new Date(1900,0,1,0,0,0);
        this.endTime = new Date(1900,0,1,0,0,0);
    }

    private static final long serialVersionUID = 1L;

    public int getnScheduleId() {
        return nScheduleId;
    }

    public void setnScheduleId(int nScheduleId) {
        this.nScheduleId = nScheduleId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nScheduleId=").append(nScheduleId);
        sb.append(", nurseId=").append(nurseId);
        sb.append(", deptId=").append(deptId);
        sb.append(", date=").append(date);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}