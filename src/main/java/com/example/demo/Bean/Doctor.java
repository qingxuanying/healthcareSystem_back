package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Doctor implements Serializable {
    /**
     * 医生ID
     */
    @Id
    @Column(name="doctor_id")
    @JsonProperty("doctorid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    /**
     * 医生密码
     */
    @Column(name = "doctor_password")
    @JsonProperty("doctorpassword")
    private String doctorPassword;

    /**
     * 医生姓名
     */
    @Column(name = "doctor_name")
    @JsonProperty("doctorname")
    private String doctorName;

    /**
     * 医生年龄，默认为0
     */
    @Column(name = "doctor_age")
    @JsonProperty("doctorage")
    private int doctorAge;

    /**
     * 医生性别，0为未知，1为男，2为女
     */
    @Column(name = "doctor_gender")
    @JsonProperty("doctorgender")
    private int doctorGender;

    /**
     * 医生挂号费，默认0
     */
    @Column(name = "fee")
    @JsonProperty("fee")
    private int fee;

    /**
     * 医生照片，存文件路径或者base64编码
     */
    @Column
    private String doctorPhoto;

    /**
     * 医生联系方式
     */
    @Column(name = "doctor_phone")
    @JsonProperty("doctorphone")
    private String doctorPhone;

    /**
     * 医生身份证号
     */
    @Column(name = "doctor_certificates_no")
    @JsonProperty("doctorcertificates_no")
    private String doctorCertificatesNo;

    /**
     * 医生职称
     */
    @Column(name = "doctor_title")
    @JsonProperty("doctortitle")
    private String doctorTitle;

    /**
     * 医生科室
     */
    @Column(name = "dept_id")
    @JsonProperty("deptid")
    private int deptId;

    /**
     * 逻辑删除，默认为false
     */
    @Column
    private Boolean isDelete;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    /**
     * 医生介绍
     */
    @Column(name = "doctor_introduction")
    @JsonProperty("doctorintroduction")
    private String doctorIntroduction;

    public Doctor(){
        this.doctorId = 0;
        this.version = 0;
        this.doctorIntroduction = "无";
        this.isDelete = false;
        this.doctorTitle = "无";
        this.doctorPhone = "无";
        this.doctorCertificatesNo = "未知";
        this.doctorAge = 0;
        this.doctorGender= 0;
        this.deptId = 0;
        this.fee=0;
    }

    private static final long serialVersionUID = 1L;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(int doctorAge) {
        this.doctorAge = doctorAge;
    }

    public int getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(int doctorGender) {
        this.doctorGender = doctorGender;
    }

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorCertificatesNo() {
        return doctorCertificatesNo;
    }

    public void setDoctorCertificatesNo(String doctorCertificatesNo) {
        this.doctorCertificatesNo = doctorCertificatesNo;
    }

    public String getDoctorTitle() {
        return doctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDoctorIntroduction() {
        return doctorIntroduction;
    }

    public void setDoctorIntroduction(String doctorIntroduction) {
        this.doctorIntroduction = doctorIntroduction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
        sb.append(" {");
//        sb.append("Hash = ").append(hashCode());
        sb.append("doctorId:").append(doctorId);
        sb.append(",doctorPassword:").append(doctorPassword);
        sb.append(",doctorName:").append(doctorName);
        sb.append(",doctorAge:").append(doctorAge);
        sb.append(",doctorGender:").append(doctorGender);
        sb.append(",doctorPhoto:").append(doctorPhoto);
        sb.append(",doctorPhone:").append(doctorPhone);
        sb.append(",doctorCertificatesNo:").append(doctorCertificatesNo);
        sb.append(",doctorTitle:").append(doctorTitle);
        sb.append(",deptId:").append(deptId);
        sb.append(",isDelete:").append(isDelete);
        sb.append(",version:").append(version);
        sb.append(",doctorIntroduction:").append(doctorIntroduction);
        sb.append(",serialVersionUID:").append(serialVersionUID);
        sb.append("}");
        return sb.toString();
    }
}