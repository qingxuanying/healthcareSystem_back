package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "admin")
public class Admin implements Serializable {
    /**
     * 管理员ID,主键
     */
    @Id
    @Column(name="admin_id")
    @JsonProperty("adminid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    /**
     * 管理员姓名
     */
    @Column
    @JsonProperty("adminname")
    private String adminName;

    /**
     * 管理员密码
     */
    @Column
    @JsonProperty("adminpassword")
    private String adminPassword;

    public Admin() {
        this.adminId = 0;
        this.adminName = "";
        this.adminPassword = "";
    }

    private static final long serialVersionUID = 1L;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("adminId:").append(adminId);
        sb.append(", adminName:").append(adminName);
        sb.append(", adminPassword:").append(adminPassword);
        sb.append(", serialVersionUID:").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}