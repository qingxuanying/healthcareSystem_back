package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Bed implements Serializable {
    /**
     * 床位ID，主键自增
     */
    @Id
    @Column(name="bed_id")
    @JsonProperty("bedid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bedId;

    /**
     * 病房ID，外键参考病房表
     */
    @Column(name = "ward_id")
    @JsonProperty("wardid")
    private int wardId;

    /**
     * 患者姓名
     */
    @Column(name = "patient_name")
    @JsonProperty("patientname")
    private String patient_name;

    /**
     * 患者状态
     */
    @Column(name = "patient_status")
    @JsonProperty("patientstatus")
    private String patientstatus;


    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatientstatus() {
        return patientstatus;
    }

    public void setPatientstatus(String patientstatus) {
        this.patientstatus = patientstatus;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    /**
     * 患者ID，无特别外键参考
     */
    @Column(name = "patient_id")
    @JsonProperty("patientid")
    private int patientid;

    /**
     * 床位号
     */
    @Column(name = "bed_number")
    private int bedNumber;

    /**
     * 床位状态，0表示空，1表示占用
     */
    @Column(name = "bed_status")
    private int bedStatus;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public void setBedStatus(int bedStatus) {
        this.bedStatus = bedStatus;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Bed(){
        this.bedId = 0;
        this.version = 0;
        this.bedStatus = 0;
        this.bedNumber =0;
        this.patient_name="";
        this.patientid=0;
        this.patientstatus="";
    }


    private static final long serialVersionUID = 1L;

    public Integer getBedId() {
        return bedId;
    }

    public int getWardId() {
        return wardId;
    }

//    public String getBedNumber() {
//        return bedNumber;
//    }
//
//    public void setBedNumber(String bedNumber) {
//        this.bedNumber = bedNumber;
//    }

    public Integer getBedStatus() {
        return bedStatus;
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
        sb.append(", bedId=").append(bedId);
        sb.append(", wardId=").append(wardId);
        sb.append(", bedNumber=").append(bedNumber);
        sb.append(", bedStatus=").append(bedStatus);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}