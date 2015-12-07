/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.data;

import TOBA.business.Account;
import TOBA.business.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class AccountDB {
    
    public static void insert (Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try {
            em.persist(account);
            trans.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    /*
        public static Account selectAccount(long userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                "WHERE a.userID = :userID";
        
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("userID", userID);
        
        Account account = null;
        
        try {
            account = q.getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println(e);
        }
        finally {
            em.close();
        }
        return account;
    }*/
    
    public static List<Account> selectAccount(long userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                "WHERE a.userid = " + userID;
        
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        
        List<Account> accounts;
        
        try {
            accounts = q.getResultList();
            if (accounts == null || accounts.isEmpty())
                accounts = null;
        }
        finally {
            em.close();
        }
        return accounts;
    }
    
        public static void update (Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try {
            em.merge(account);
            trans.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
}