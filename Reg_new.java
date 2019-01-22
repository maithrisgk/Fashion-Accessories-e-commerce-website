/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class Reg_new {
private String name;
private int phonenumber;
private String city;
private String username;
private String password;

    public Reg_new(String name, int phonenumber, String city, String username, String password) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.city = city;
        this.username = username;
        this.password = password;
    }

    public void addRegister(String name, int phonenumber, String city, String username, String password) {
        try {
        DataSource d=(DataSource) getRegisterDB();
        Connection c=d.getConnection();
        PreparedStatement p=c.prepareStatement("insert into admin values(?,?,?,?,?)");
        p.setString(1,name);
        p.setInt(2,phonenumber);
        p.setString(3,city);
        p.setString(4,username);
        p.setString(5,password);
        
        p.executeUpdate();
      } catch(Exception e) {
          e.printStackTrace();
      }
    }

   
    
   

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private javax.sql.DataSource getRegisterDB() throws NamingException {
        Context c = new InitialContext();
        return (javax.sql.DataSource) c.lookup("java:comp/env/RegisterDB");
    }

    

    


}
