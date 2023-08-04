package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Bonds")
public class Bonds
{ @Id
    private int isin;
    private String cusip;
    private String name;
    private String clientName;
    private Date maturityDate;
    private boolean isSettled;

    @Id
    @Column(name = "isin", nullable = false)
    public int getIsin() {
        return isin;
    }
    public void setIsin(int isin) {
        this.isin = isin;
    }

    @Column(name = "cusip", nullable = false)
    public String getcusip() { return cusip; }
    public void setcusip(int cusip) {
        this.cusip = String.valueOf(cusip);
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "clientName", nullable = false)
    public String getclientName() {return clientName;}
    public void setclientName(String clientName) {
        this.clientName = clientName;
    }

    @Column(name = "maturityDate", nullable = false)
    public Date maturityDate() {return maturityDate;}
    public void setMaturityDate(Date maturityDate) {this.maturityDate = maturityDate;}

    @Column(name = "isSettled", nullable = false)
    public boolean isSettled() {return isSettled;}
    public void isSettled(boolean isSettled) {this.isSettled = isSettled;}

}
