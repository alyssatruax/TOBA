/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Transaction implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transactionID;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transactionDate;
    
    private double amount;
    
    @ManyToOne
    private Account fromAccount;
    @ManyToOne
    private Account toAccount;
    
    public Transaction () {
        this.transactionID = 0;
        this.amount = 0;
        this.fromAccount = null;
        this.toAccount = null;
        this.transactionDate = null;
    }
    
    public Transaction (double amount, Account fromAccount, Account toAccount) {
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transactionDate = transactionDate;
    }
    
    // Getters and setters
    public Account getFromAccount () {
        return fromAccount;
    }
    
    public void setFromAccount (Account fromAccount) {
        this.fromAccount = fromAccount;
    }
    
    public Account getToAccount () {
        return toAccount;
    }
    
    public void setToAccount (Account toAccount) {
        this.toAccount = toAccount;
    }
    
    public double getAmount () {
        return amount;
    }
    
    public void setAmount (double amount) {
        this.amount = amount;
    }
    
    public long getTransactionID () {
        return transactionID;
    }
    
    public void setTransactionID (long transactionID) {
        this.transactionID = transactionID;
    }
}
