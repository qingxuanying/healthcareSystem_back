package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class PrescriptionMedication implements Serializable {
    /**
     * 关联ID，主键自增
     */
    @Id
    @Column(name="p_m_id")
    @JsonProperty("pmid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pMId;

    /**
     * 取药单ID，外键参考取药单表
     */
    @Column(name = "prescription_id")
    @JsonProperty("prescriptionid")
    private int prescriptionId;

    /**
     * 药品ID，外键参考药品表
     */
    @Column(name = "medication_id")
    @JsonProperty("medicationid")
    private int medicationId;

    /**
     * 药品名，外键参考药品表
     */
    @Column(name = "medication_name")
    @JsonProperty("medicationname")
    private String medicationname;

    /**
     * 服药剂量
     */
    @Column
    private String dosage;

    /**
     * 药物用法
     */
    @Column
    private String frequency;

    /**
     * 取药数量，非空，默认为0
     */
    @Column
    private int number;

    public PrescriptionMedication(){
        this.prescriptionId = 0;
        this.frequency = "";
        this.number = 0;
        this.dosage = "";
    }

    private static final long serialVersionUID = 1L;

    public int getpMId() {
        return pMId;
    }

    public void setpMId(int pMId) {
        this.pMId = pMId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public String getDosage() {
        return dosage;
    }

    public String getMedicationname() {
        return medicationname;
    }

    public void setMedicationname(String medicationname) {
        this.medicationname = medicationname;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pMId=").append(pMId);
        sb.append(", prescriptionId=").append(prescriptionId);
        sb.append(", medicationId=").append(medicationId);
        sb.append(", dosage=").append(dosage);
        sb.append(", frequency=").append(frequency);
        sb.append(", number=").append(number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}