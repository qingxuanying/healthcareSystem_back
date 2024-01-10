package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Prescription implements Serializable {
    /**
     * 取药单ID
     */
    @Id
    @Column(name="prescription_id")
    @JsonProperty("prescriptionid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;

    /**
     * 患者ID，外键参考患者表
     */
    @Column(name = "patient_id")
    @JsonProperty("patientid")
    private int patientId;

    /**
     * 挂号单ID
     */
    @Column(name = "registration_id")
    @JsonProperty("registrationid")
    private int registrationid;

    /**
     * 医生ID，外键参考医生表
     */
    @Column(name = "doctor_id")
    @JsonProperty("doctorid")
    private int doctorId;

    /**
     * 开单时间
     */
    @Column
    private String prescriptionDate;

    /**
     * 是否取了药，非空，默认值为"待取药"
     */
    @Column
    private String status;

    public Prescription(){
        this.patientId = 0;
        this.status="待取药";
        this.prescriptionDate = String.valueOf(LocalDateTime.now());
    }

    private static final long serialVersionUID = 1L;

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
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

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getStatus() {
        return status;
    }

    public int getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(int registrationid) {
        this.registrationid = registrationid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prescriptionId=").append(prescriptionId);
        sb.append(", patientId=").append(patientId);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", prescriptionDate=").append(prescriptionDate);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}