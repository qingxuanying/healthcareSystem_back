package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Nurse implements Serializable {
    /**
     * 护士ID
     */
    @Id
    @Column(name = "nurse_id")
    @JsonProperty("nurseid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nurseId;

    /**
     * 护士密码
     */
    @Column(name = "nurse_password")
    @JsonProperty("nursepassword")
    private String nursePassword;

    /**
     * 护士姓名
     */
    @Column
    @JsonProperty("nursename")
    private String nurseName;

    /**
     * 护士年龄，默认为0
     */
    @Column
    @JsonProperty("nurseage")
    private int nurseAge;

    /**
     * 护士性别，0为未知，1为男，2为女
     */
    @Column
    @JsonProperty("nursegender")
    private int nurseGender;

    /**
     * 护士照片
     */
    @Column
    private String nursePhoto;

    /**
     * 护士联系方式
     */
    @Column
    private String nursePhone;

    /**
     * 护士身份证号
     */
    @Column
    private String nurseCertificatesNo;

    /**
     * 护士职称
     */
    @Column
    private String nurseTitle;

    /**
     * 护士科室
     */
    @Column
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

    public Nurse(){
        this.nurseId = 0;
        this.version = 0;
        this.isDelete = false;
        this.nurseTitle = "";
        this.nursePhone = "";
        this.nurseCertificatesNo = "";
        this.nurseAge = 0;
        this.nurseGender= 0;
        this.deptId = 0;
    }

    private static final long serialVersionUID = 1L;

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getNursePassword() {
        return nursePassword;
    }

    public void setNursePassword(String nursePassword) {
        this.nursePassword = nursePassword;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public int getNurseAge() {
        return nurseAge;
    }

    public void setNurseAge(int nurseAge) {
        this.nurseAge = nurseAge;
    }

    public int getNurseGender() {
        return nurseGender;
    }

    public void setNurseGender(int nurseGender) {
        this.nurseGender = nurseGender;
    }

    public String getNursePhoto() {
        return nursePhoto;
    }

    public void setNursePhoto(String nursePhoto) {
        this.nursePhoto = nursePhoto;
    }

    public String getNursePhone() {
        return nursePhone;
    }

    public void setNursePhone(String nursePhone) {
        this.nursePhone = nursePhone;
    }

    public String getNurseCertificatesNo() {
        return nurseCertificatesNo;
    }

    public void setNurseCertificatesNo(String nurseCertificatesNo) {
        this.nurseCertificatesNo = nurseCertificatesNo;
    }

    public String getNurseTitle() {
        return nurseTitle;
    }

    public void setNurseTitle(String nurseTitle) {
        this.nurseTitle = nurseTitle;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nurseId=").append(nurseId);
        sb.append(", nursePassword=").append(nursePassword);
        sb.append(", nurseName=").append(nurseName);
        sb.append(", nurseAge=").append(nurseAge);
        sb.append(", nurseGender=").append(nurseGender);
        sb.append(", nursePhoto=").append(nursePhoto);
        sb.append(", nursePhone=").append(nursePhone);
        sb.append(", nurseCertificatesNo=").append(nurseCertificatesNo);
        sb.append(", nurseTitle=").append(nurseTitle);
        sb.append(", deptId=").append(deptId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}