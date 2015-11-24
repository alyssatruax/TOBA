/*
 * Create a User JavaBean.
The User Bean should have all the attributes collected from the new customer form.
Also give it a username and password property.
 */
package TOBA.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "TOBA.USER")
public class User implements Serializable {
    
    // Declare variables from new customer form
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String email;
    private String city;
    private String state;
    private String zipcode;
    private String username;
    private String password;
    
    public User() {
        userID = 0;
        firstName = "";
        lastName = "";
        phone = "";
        address = "";
        city = "";
        state = "";
        zipcode = "";
        email = "";
        username = "";
        password = "";
    }
    
    public User (String firstName, String lastName, String phone,
            String address,String city, String state, String zipcode,
            String email, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    // Getters and setters
    public long getUserID () {
        return userID;
    }
    
    public void setUserID (long userID) {
        this.userID = userID;
    }
    
    public String getFirstName () {
        return firstName;
    }
    
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName () {
        return lastName;
    }
    
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhone () {
        return phone;
    }
    
    public void setPhone (String phone) {
        this.phone = phone;
    }
    
    public String getAddress () {
        return address;
    }
    
    public void setAddress (String address) {
        this.address = address;
    }
    
    public String getCity () {
        return city;
    }
    
    public void setCity (String city) {
        this.city = city;
    }
    
    public String getState () {
        return state;
    }
    
    public void setState (String state) {
        this.state = state;
    }
    
    public String getZipcode () {
        return zipcode;
    }
    
    public void setZipcode (String zipcode) {
        this.zipcode = zipcode;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getUsername () {
        return username;
    }
    
    public void setUsername (String username) {
        this.username = username;
    }
    
    public String getPassword () {
        return password;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
}
