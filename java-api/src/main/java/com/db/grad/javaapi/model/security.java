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
    public void setName(String cusip) {
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




}