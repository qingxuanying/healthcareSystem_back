package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Discharge implements Serializable {
    /**
     * 出院表ID，主键自增
     */
    @Id
    @Column(name="discharge_id")
    @JsonProperty("dischargeid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dischargeId;

    /**
     * 患者ID，外键参考患者表
     */
    @Column(name = "patient_id")
    @JsonProperty("patientid")
    private int patientId;

    /**
     * 主治医师ID，外键参考医生表
     */
    @Column(name = "doctor_id")
    @JsonProperty("doctorid")
    private int doctorId;

    /**
     * 科室ID，外键参考科室表
     */
    @Column(name = "dept_id")
    @JsonProperty("deptid")
    private int deptId;

    /**
     * 病房ID，外键参考病房表
     */
    @Column(name = "ward_id")
    @JsonProperty("wardid")
    private int wardId;

    /**
     * 床位ID，外键参考床位表
     */
    @Column(name = "bed_id")
    @JsonProperty("bedid")
    private int bedId;

    /**
     * 出院日期
     */
    @Column
    private Date dischargeDate;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    /**
     * 出院原因
     */
    @Column
    private String dischargeReason;

    /**
     * 结算信息
     */
    @Column
    private String settlementInfo;

    /**
     * 备注信息
     */
    @Column
    private String remarks;

    public Discharge(){
        this.dischargeId = 0;
        this.version = 0;
        this.settlementInfo = "";
        this.dischargeReason = "";
        this.remarks = "";
        this.dischargeDate = new Date();
    }

    private static final long serialVersionUID = 1L;

    public Integer getDischargeId() {
        return dischargeId;
    }

    public void setDischargeId(Integer dischargeId) {
        this.dischargeId = dischargeId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDischargeReason() {
        return dischargeReason;
    }

    public void setDischargeReason(String dischargeReason) {
        this.dischargeReason = dischargeReason;
    }

    public String getSettlementInfo() {
        return settlementInfo;
    }

    public void setSettlementInfo(String settlementInfo) {
        this.settlementInfo = settlementInfo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dischargeId=").append(dischargeId);
        sb.append(", patientId=").append(patientId);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", deptId=").append(deptId);
        sb.append(", wardId=").append(wardId);
        sb.append(", bedId=").append(bedId);
        sb.append(", dischargeDate=").append(dischargeDate);
        sb.append(", version=").append(version);
        sb.append(", dischargeReason=").append(dischargeReason);
        sb.append(", settlementInfo=").append(settlementInfo);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}