package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Admission implements Serializable {
    /**
     * 入院ID，主键自增
     */
    @Id
    @Column(name="admission_id")
    @JsonProperty("admissionid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admissionId;

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
     * 入院诊断
     */
    @Column
    private String diagnosis;

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
     * 预交金
     */
    @Column
    private BigDecimal admissionFee;

    /**
     * 备注
     */
    @Column
    private String remark;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    public Admission() {
        this.admissionId = 0;
        this.diagnosis = "";
        this.admissionFee = new BigDecimal("0.00");
        this.remark = "";
        this.version = 0;
    }

    private static final long serialVersionUID = 1L;

    public Integer getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Integer admissionId) {
        this.admissionId = admissionId;
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

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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

    public BigDecimal getAdmissionFee() {
        return admissionFee;
    }

    public void setAdmissionFee(BigDecimal admissionFee) {
        this.admissionFee = admissionFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", admissionId=").append(admissionId);
        sb.append(", patientId=").append(patientId);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", deptId=").append(deptId);
        sb.append(", diagnosis=").append(diagnosis);
        sb.append(", wardId=").append(wardId);
        sb.append(", bedId=").append(bedId);
        sb.append(", admissionFee=").append(admissionFee);
        sb.append(", remark=").append(remark);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}