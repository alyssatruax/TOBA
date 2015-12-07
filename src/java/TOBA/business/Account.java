/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountNum;
    private double balance;
    private long joinUserID;
    private final Type type;
    
    @ManyToOne
    @JoinColumn(name="userid")
    private User user;
    
    @OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Account> accounts;
   
    public Account () {
        type = null;
        balance = 0;
        user = null;
    }
    
    public Account (User user, double balance, Type type){
        this.type = type;
        this.user = user;
        this.balance = balance;
        this.joinUserID = user.getUserID();
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
    
    public long getUserID() {
        return this.joinUserID;
    }
    
     public long getAccountNum() {
        return this.accountNum;
    }
    
}
/*
package TOBA.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountNum;
    private double balance;
    private long joinUserID;
    
    @ManyToOne
    @JoinColumn(name="USERID")
    private final User user;
    private final Type type;    
    //@OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    //private List<Account> accounts;
   
    public Account () {
       // user = new User();
        type = null;
        balance = 0;
        user = null;
    }
    
    public Account (User user, double balance, Type type){
        this.type = type;
        this.user = user;
        this.balance = balance;
        //this.joinUserID = user.getUserID();
    }

    // Getters and setters
    public double getBalance () {
        return balance;
    }
   
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void Credit (double credit) {
        this.balance += credit;
    }
    
    public void Debit (double debit) {
        this.balance -= debit;
    }
    
    /*public long getUserID() {
        return this.userID;
    }
    
    public void setUserId(long userID){
        this.userID = userID;
    }*/
    
     /*public long getAccountNum() {
        return this.accountNum;
    }
    
}*/