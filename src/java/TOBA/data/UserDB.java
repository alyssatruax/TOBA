/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.data;

import TOBA.business.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDB {
    
    public static void insert (User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try {
            em.persist(user);
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
    
    public static void update (User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try {
            em.merge(user);
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
    
    public static void delete(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        try { 
            em.remove(em.merge(user));
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
    
    public static User selectUser(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.username = :username";
        
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("username", username);
        
        User user = null;
        
        try {
            user = q.getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println(e);
        }
        finally {
            em.close();
        }
        return user;
    }
    
    public static User getUserById(long userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            User user = em.find(User.class, userID);
            return user;
        }
        finally {
            em.close();
        }
    }
    
    public static boolean usernameExists(String username) {
        User u = selectUser(username);
        return u != null;
    }
    
    public static User getUserByID(long userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, userID);
            return user;
        }
        finally {
            em.close();
        }
    }
}
