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
    private long transactionId;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transactionDate;
    
    private double amount;
    
    @ManyToOne
    private Account account;
    
    private long userID;
    
    public Transaction (double amount, User user, Account account) {
        this.amount = amount;

    }
}
