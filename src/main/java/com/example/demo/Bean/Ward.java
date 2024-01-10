package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Ward implements Serializable {
    /**
     * 病房ID，主键自增
     */
    @Id
    @Column(name="ward_id")
    @JsonProperty("wardid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wardId;

    /**
     * 病房号
     */
    @Column(name = "ward_number")
    @JsonProperty("wardnumber")
    private int wardNumber;

    /**
     * 病房名
     */
    @Column(name = "ward_name")
    @JsonProperty("wardname")
    private String wardName;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *床位状态
     */
    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    /**
     * 病房容量
     */
    @Column
    private int wardCapacity;

    /**
     * 可用床位数
     */
    @Column
    private int availableBed;

    /**
     * 所属科室ID，外键参考科室表
     */
    @Column(name = "dept_id")
    @JsonProperty("deptid")
    private int deptId;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    /**
     * 病房描述
     */
    @Column
    private String description;
    
    public Ward(){
        this.wardId = 0;
        this.version = 0;
        this.description = "";
        this.availableBed = 10;
        this.wardCapacity = 10;
        this.status="000000";
    }

    private static final long serialVersionUID = 1L;

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public int getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(int wardNumber) {
        this.wardNumber = wardNumber;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public int getWardCapacity() {
        return wardCapacity;
    }

    public void setWardCapacity(int wardCapacity) {
        this.wardCapacity = wardCapacity;
    }

    public int getAvailableBed() {
        return availableBed;
    }

    public void setAvailableBed(int availableBed) {
        this.availableBed = availableBed;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wardId=").append(wardId);
        sb.append(", wardNumber=").append(wardNumber);
        sb.append(", wardName=").append(wardName);
        sb.append(", wardCapacity=").append(wardCapacity);
        sb.append(", availableBed=").append(availableBed);
        sb.append(", deptId=").append(deptId);
        sb.append(", version=").append(version);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}