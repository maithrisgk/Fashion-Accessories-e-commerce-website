package model;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Ornaments {
    private String name;
    private int dob;
    private String address;

    public Ornaments(String name, int dob, String address) {
        this.name=name;
        this.dob=dob;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private DataSource getOrnamentDB() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/ornamentDB");
    }

    public void addOrnament(String title, int year, String season) {
      try {
        DataSource d=getOrnamentDB();
        Connection c=d.getConnection();
        PreparedStatement p=c.prepareStatement("insert into regist values(?,?,?)");
        p.setString(1,name);
        p.setInt(2,dob);
        p.setString(3,address);
        p.executeUpdate();
      } catch(Exception e) {
          e.printStackTrace();
      }
    }
}
