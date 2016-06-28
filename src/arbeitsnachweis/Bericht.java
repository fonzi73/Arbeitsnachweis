/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsnachweis;

import static arbeitsnachweis.Benutzer.st;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fonzi
 */
public class Bericht {

    // Konnektoren DB
    static Connection con = null;
    static PreparedStatement pst = null;
    static Statement st = null;
    static ResultSet rst = null;

    // Objekt Variablen
    private int id;
    private String dokumentation;
    private String zeit;
    private int nachweis_id;
    private ArrayList<Bericht> berichtL;

    // Konstruktor
    public Bericht(int id, String dokumentation, String zeit, int nachweis_id) {
        this.id = id;
        this.dokumentation = dokumentation;
        this.zeit = zeit;
        this.nachweis_id = nachweis_id;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getDokumentation() {
        return dokumentation;
    }

    public String getZeit() {
        return zeit;
    }

    public int getNachweis_id() {
        return nachweis_id;
    }

    public ArrayList<Bericht> getBerichtL() {
        return berichtL;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setDokumentation(String dokumentation) {
        this.dokumentation = dokumentation;
    }

    public void setNachweis_id(int nachweis_id) {
        this.nachweis_id = nachweis_id;
    }

    public void setBerichtL(ArrayList<Bericht> berichtL) {
        this.berichtL = berichtL;
    }

//    public  ArrayList<Bericht> getBerichtID() {
//        ArrayList<Bericht> auslesen = Bericht.getAllBericht();
//
//        for (int i = 0; i <= auslesen.size(); i++) {
//            System.out.println(i);
//        }
//       
//    }

    // toString
    @Override
    public String toString() {
        return "Bericht{" + "id=" + id + ", dokumentation=" + dokumentation + ", zeit=" + zeit + ", nachweis_id=" + nachweis_id + '}';
    }

    public static ArrayList<Bericht> getAllBericht() {
        ArrayList<Bericht> berichtL = new ArrayList<>();
        try {
            // VERBINDUNG AUFBBAUEN:
            Connection con = MySQLConnection.getConnection();
            // STATEMENT
            String sql = "SELECT * FROM bericht";
            st = con.createStatement();
            rst = st.executeQuery(sql);
            while (rst.next()) { // rst.next bewirkt ein Stop wen keine weiteren Datensätze vorhanden sind
                Bericht bericht = new Bericht(rst.getInt("id"),
                        rst.getString("dokumentation"),
                        rst.getString("zeit"),
                        rst.getInt("nachweis_id"));

                berichtL.add(bericht);
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
        return berichtL;
    }

}
