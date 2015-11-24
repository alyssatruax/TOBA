/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountNum;
    private double balance;
    private final Type type;
    
    @ManyToOne
    private User user;
   
    public Account () {
        type = null;
        balance = 0;
        user = null;
    }
    
    public Account (User user, double balance, Type type){
        this.type = type;
        this.user = user;
        this.balance = balance;
    }

    // Getters and setters
    public double getBalance () {
        return balance;
    }
    
    
    
    public void Credit (double credit) {
        this.balance += credit;
    }
    
    public void Debit (double debit) {
        this.balance -= debit;
    }
    
}