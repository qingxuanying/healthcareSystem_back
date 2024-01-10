package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Registration implements Serializable {
    /**
     * 挂号记录ID，主键自增
     */
    @Id
    @Column(name="registration_id")
    @JsonProperty("registrationid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationId;

    /**
     * 患者ID，外键参考患者表
     */
    @Column(name = "patient_id")
    @JsonProperty("patientid")
    private int patientId;

    /**
     * 医生ID，外键参考医生表
     */
    @Column(name = "doctor_id")
    @JsonProperty("doctorid")
    private int doctorId;

    /**
     * 就诊状态，默认为0
     */
    @Column(name = "status")
    @JsonProperty("status")
    private int status;

    /**
     * 患者情况自述，默认为空
     */
    @Column(name = "decrept")
    @JsonProperty("decrept")
    private String decrept;

    /**
     * 患者姓名，由患者id自动插入
     */
    @Column(name = "patient_name")
    @JsonProperty("patientname")
    private String patientname;


    /**
     * 号码余量
     */
    @Column
    private int availableSlots;

    /**
     * 挂号日期
     */
    @Column
    private String registrationDate;

    /**
     * 挂号费用
     */
    @Column
    private int fee;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    public Registration(){
        this.registrationId = 0;
        this.version = 0;
        this.fee = 0;
        this.registrationDate = String.valueOf(LocalDateTime.now());
        this.availableSlots = 100;
        this.decrept="";
        this.status=0;
        this.patientname="";
    }

    private static final long serialVersionUID = 1L;

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getDecrept() {
        return decrept;
    }

    public void setDecrept(String decrept) {
        this.decrept = decrept;
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
        sb.append(", registrationId=").append(registrationId);
        sb.append(", patientId=").append(patientId);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", availableSlots=").append(availableSlots);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", fee=").append(fee);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}