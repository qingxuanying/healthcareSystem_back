package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Patient implements Serializable {
    /**
     * 患者ID，主键
     */
    @Id
    @Column(name="patient_id")
    @JsonProperty("patientid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    /**
     * 患者密码
     */
    @Column(name = "patient_password")
    @JsonProperty("patientpassword")
    private String patientPassword;

    /**
     * 患者姓名
     */
    @Column(name = "patient_name")
    @JsonProperty("patientname")
    private String patientName;

    /**
     * 患者年龄，默认为0
     */
    @Column(name = "patient_age")
    @JsonProperty("patientage")
    private int patientAge;

    /**
     * 患者性别，0为未知，1为男，2为女
     */
    @Column(name = "patient_gender")
    @JsonProperty("patientgender")
    private int patientGender;

    /**
     * 患者联系方式
     */
    @Column
    private String patientPhone;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 患者照片
     */
    @Column(name = "photo")
    @JsonProperty("photo")
    private String photo;

    /**
     * 患者身份证号
     */
    @Column(name = "patient_certificates_no")
    @JsonProperty("patient_certificates_no")
    private String patientCertificatesNo;

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

    public Patient(){
        this.patientId = 0;
        this.version = 0;
        this.isDelete = false;
        this.patientCertificatesNo = "";
        this.patientPhone = "";
        this.patientGender = 0;
        this.patientAge = 0;
        this.photo="avatar.jpg";
    }

    private static final long serialVersionUID = 1L;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public int getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(int patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientCertificatesNo() {
        return patientCertificatesNo;
    }

    public void setPatientCertificatesNo(String patientCertificatesNo) {
        this.patientCertificatesNo = patientCertificatesNo;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patientId=").append(patientId);
        sb.append(", patientPassword=").append(patientPassword);
        sb.append(", patientName=").append(patientName);
        sb.append(", patientAge=").append(patientAge);
        sb.append(", patientGender=").append(patientGender);
        sb.append(", patientPhone=").append(patientPhone);
        sb.append(", patientCertificatesNo=").append(patientCertificatesNo);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}