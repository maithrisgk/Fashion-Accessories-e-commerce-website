package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Admin {
private String orna;
private int qua;


    public Admin(String orna, int qua) {
        this.orna = orna;
        this.qua = qua;
    }

    public void addAdmin(String name, int qua1) {
        try {
        DataSource d=getAdminDB();
        Connection c=d.getConnection();
        PreparedStatement p=c.prepareStatement("insert into admin values(?,?,?)");
        p.setString(1,orna);
        p.setInt(2,qua);
        p.executeUpdate();
      } catch(Exception e) {
          e.printStackTrace();
      }
    }

    public String getOrna() {
        return orna;
    }

    public void setOrna(String orna) {
        this.orna = orna;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    private DataSource getAdminDB() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/adminDB");
    }
}
