/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsnachweis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fonzi
 */
public class Benutzer {
    
    // Konnektoren DB
    static Connection con = null;
    static PreparedStatement pst = null;
    static Statement st = null;
    static ResultSet rst = null;
    
    // Objekt Variablen
    private int id;
    private String name;
      
    
    // Konstruktor
    public Benutzer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return "Benutzer{" + "id=" + id + ", name=" + name + '}';
    }
    
    /**
     * CRUD Funktionen
     * 
     * 
     * 
     */
    
    public static void insert(Benutzer user){
        try {
            // VERBINDUNG AUFBBAUEN:
            Connection con = MySQLConnection.getConnection();
            // STATEMENT
            String Sql = "INSERT INTO benutzer VALUES (null, ?)";
            pst = con.prepareStatement(Sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getName());
            pst.executeUpdate();
            rst = pst.getGeneratedKeys();
            while (rst.next()) {
                user.setId(rst.getInt(1));
            }         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rst != null) {
                    rst.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
