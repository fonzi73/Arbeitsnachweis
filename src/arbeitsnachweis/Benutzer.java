/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsnachweis;

import static arbeitsnachweis.Nachweis.pst;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    private ArrayList<Benutzer> benutzerL;
      
    
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

    public ArrayList<Benutzer> getBenutzerL() {
        return benutzerL;
    }
    
    
    
    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBenutzerL(ArrayList<Benutzer> benutzerL) {
        this.benutzerL = benutzerL;
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
    /**
     * liefert alle Datensätze aus der Tabelle als ArrayList mit Ojekten zurück
     */
    public static Benutzer getById(int id) {
        ArrayList<Benutzer> benutzerL = new ArrayList<>();
        try {
             // VERBINDUNG AUFBBAUEN:
            Connection con = MySQLConnection.getConnection();
            // STATEMENT
            String sql = "SELECT * FROM benutzer WHERE id=?";
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rst = pst.executeQuery();
            
            while (rst.next()) { // rst.next bewirkt ein Stop wen keine weiteren Datensätze vorhanden sind
                Benutzer benutzer = new Benutzer(rst.getInt("id"), rst.getString("name"));
                benutzerL.add(benutzer);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                
                if (st != null) {
                    st.close();
                }
                if (rst != null) {
                    rst.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return benutzerL.get(0);
    }
    
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
     public void updaten() {
        // Verbindung zu MySQL
        try {
            Connection con = MySQLConnection.getConnection();
            // Prepared Statement
            String sql = "UPDATE benutzer SET name=? WHERE id=?";
            pst = con.prepareStatement(sql);
            // Übernimmt werte aus dem GUI
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // Output Meldung wenn Fehler
        } finally {
            try {
                
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
