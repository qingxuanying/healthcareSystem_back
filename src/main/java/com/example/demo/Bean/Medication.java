package com.example.demo.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Medication implements Serializable {
    /**
     * 药品ID，自增主键
     */
    @Id
    @Column(name = "medication_id")
    @JsonProperty("medicationid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicationId;

    /**
     * 药品类别
     */
    @Column(name = "category")
    @JsonProperty("category")
    private String category;

    /**
     * 药品名称，非空
     */
    @Column(name = "medication_name")
    @JsonProperty("medicationname")
    private String medicationName;

    /**
     * 药品进价，非空
     */
    @Column(name = "purchase_price")
    @JsonProperty("purchaseprice")
    private BigDecimal purchasePrice;

    /**
     * 药品售价，非空
     */
    @Column(name = "selling_price")
    @JsonProperty("sellingprice")
    private BigDecimal sellingPrice;

    /**
     * 生产厂商
     */
    @Column(name = "manufacturer")
    @JsonProperty("manufacturer")
    private String manufacturer;

    /**
     * 库存量，非空，默认为0
     */
    @Column(name = "inventory")
    @JsonProperty("inventory")
    private int inventory;

    /**
     * 有效期
     */
    @Column(name = "expiration_date")
    @JsonProperty("expirationdate")
    private Date expirationDate;

    /**
     * 乐观锁
     */
    @Column
    private int version;

    public Medication(){
        this.medicationId = 0;
        this.version = 0;
        this.category = "";
        this.expirationDate = new Date(1900,0,1,0,0,0);
        this.inventory = 0;
        this.manufacturer = "";
        this.sellingPrice = new BigDecimal("0.00");
        this.purchasePrice = new BigDecimal("0.00");
        this.medicationName = "";
    }

    private static final long serialVersionUID = 1L;

    public Integer getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Integer medicationId) {
        this.medicationId = medicationId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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
        sb.append(", medicationId=").append(medicationId);
        sb.append(", category=").append(category);
        sb.append(", medicationName=").append(medicationName);
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", sellingPrice=").append(sellingPrice);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", inventory=").append(inventory);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}