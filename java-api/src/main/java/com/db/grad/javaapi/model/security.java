package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "security")
public class security {
    @Id
    private long id;
    private String isin;
    private String cusip;
    private String issuer_name;
    private Double coupon_percent;
    private String bond_currency;
    private String face_value_mn;
    private String type;
    private Date bond_maturity_date;
    private String bond_holder;
    private String status;


    @Id
    @Column(name = "security_id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }
    public void setIsin(String name) {
        this.isin = isin;
    }
    @Column(name = "cusip", nullable = false)
    public String getCusip() {
        return cusip;
    }
    public void setCusip(String cusip) {
        this.cusip = cusip;
    }
    @Column(name = "issuer_name", nullable = false)
    public String getIssuer_name() {
        return issuer_name;
    }
    public void setIssuer_name(String cusip) {
        this.issuer_name = issuer_name;
    }
    @Column(name = "coupon_percent", nullable = false)
    public Double getCoupon_percent() {
        return coupon_percent;
    }
    public void setCoupon_percent(Double coupon_percent) {
        this.coupon_percent = coupon_percent;
    }
    @Column(name = "bond_currency", nullable = false)
    public String getBond_currency() {
        return bond_currency;
    }
    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }
    @Column(name = "face_value_mn", nullable = false)
    public String getFace_value_mn() {
        return face_value_mn;
    }
    public void setFace_value_mn(String face_value_mn) {
        this.face_value_mn = face_value_mn;
    }
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Column(name = "bond_maturity_date", nullable = false)
    public Date getBond_maturity_date() {
        return bond_maturity_date;
    }
    public void setBond_maturity_date(Date bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
    }
    @Column(name = "bond_holder", nullable = false)
    public String getBond_holder() {
        return bond_holder;
    }
    public void setBond_holder(String bond_holder) {
        this.bond_holder = bond_holder;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}