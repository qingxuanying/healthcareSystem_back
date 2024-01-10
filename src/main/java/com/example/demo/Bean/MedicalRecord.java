package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class MedicalRecord implements Serializable {
    /**
     * 病历ID，主键自增
     */
    @Id
    @Column(name="rid")
    @JsonProperty("rid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;

    /**
     * 患者ID，外键参考患者表
     */
    @Column(name ="patient_id")
    @JsonProperty("patientid")
    private int patientId;

    /**
     * 就诊部门ID，外键参考部门表
     */
    @Column(name = "dept_id")
    @JsonProperty("deptid")
    private int deptId;

    /**
     * 就诊的时间，非空，默认为当前时间
     */
    @Column
    private String visitTime;

    /**
     * 医生ID，外键参考医生表
     */
    @Column(name = "doctor_id")
    @JsonProperty("doctorid")
    private int doctorId;

    /**
     * 挂号ID，外键参考
     */
    @Column(name = "registration_id")
    @JsonProperty("registrationid")
    private int registrationid;

    /**
     * 逻辑删除标志，非空，默认为0（未删除）
     */
    @Column
    private Boolean isDelete;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    /**
     * 病史
     */
    @Column
    private String medicalHistory;

    /**
     * 初步诊断
     */
    @Column(name = "preliminary_diagnosis")
    @JsonProperty("preliminaryDiagnosis")
    private String preliminaryDiagnosis;

    /**
     * 治疗意见
     */
    @Column(name = "treatment_advice")
    @JsonProperty("treatmentAdvice")
    private String treatmentAdvice;

    public MedicalRecord(){
        this.rid = 0;
        this.treatmentAdvice = "";
        this.preliminaryDiagnosis ="";
        this.medicalHistory ="";
        this.version = 0;
        this.isDelete = false;
        this.visitTime = String.valueOf(LocalDateTime.now());
    }


    private static final long serialVersionUID = 1L;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(int registrationid) {
        this.registrationid = registrationid;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getPreliminaryDiagnosis() {
        return preliminaryDiagnosis;
    }

    public void setPreliminaryDiagnosis(String preliminaryDiagnosis) {
        this.preliminaryDiagnosis = preliminaryDiagnosis;
    }

    public String getTreatmentAdvice() {
        return treatmentAdvice;
    }

    public void setTreatmentAdvice(String treatmentAdvice) {
        this.treatmentAdvice = treatmentAdvice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", patientId=").append(patientId);
        sb.append(", deptId=").append(deptId);
        sb.append(", visitTime=").append(visitTime);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", version=").append(version);
        sb.append(", medicalHistory=").append(medicalHistory);
        sb.append(", preliminaryDiagnosis=").append(preliminaryDiagnosis);
        sb.append(", treatmentAdvice=").append(treatmentAdvice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}