/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA;

import TOBA.data.DBUtil;
import javax.persistence.EntityManager;


public class NewClass {
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
}
