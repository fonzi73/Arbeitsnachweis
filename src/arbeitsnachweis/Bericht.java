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

    

    // toString
    @Override
    public String toString() {
        return "Bericht{" + "id=" + id + ", dokumentation=" + dokumentation + ", zeit=" + zeit + ", nachweis_id=" + nachweis_id + '}';
    }

    public static ArrayList<Bericht> getAll() {
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

    public static ArrayList<Bericht> getAllByNachweisId(int nachweis_id) {
        ArrayList<Bericht> berichtL = new ArrayList<>();
        try {
            // VERBINDUNG AUFBBAUEN:
            Connection con = MySQLConnection.getConnection();
            // STATEMENT
            String sql = "SELECT * FROM bericht WHERE nachweis_id=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, nachweis_id);
            rst = pst.executeQuery();

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

    public static void insert(Bericht bericht) {

        try {
            // VERBINDUNG AUFBBAUEN:
            Connection con = MySQLConnection.getConnection();
            // STATEMENT

            // Erster Eintrag Zeile
            String Sql = "INSERT INTO nachweis VALUES (null, ?, ?, ?)";
            pst = con.prepareStatement(Sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, bericht.getDokumentation());
            pst.setString(2, bericht.getZeit());
            pst.setInt(3, bericht.getNachweis_id());
            pst.executeUpdate();
            rst = pst.getGeneratedKeys();
            while (rst.next()) {
                bericht.setId(rst.getInt(1));

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

    public static void update(Nachweis nW) {
        try {
            Connection con = MySQLConnection.getConnection();
            String sql = "UPDATE nachweis SET nr=?, heft_id=? WHERE id=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, nW.getNr());
            pst.setInt(2, nW.getHeft_id());
            pst.setInt(4, nW.getId());
            pst.executeUpdate();

            Nachweis.insert(nW);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
    
    
//    public static void insert(Bericht bericht){
//        try {
//            // VERBINDUNG AUFBBAUEN:
//            Connection con = MySQLConnection.getConnection();
//            // STATEMENT
//            String Sql = "INSERT INTO nachweis VALUES (null, ?, ?, ?)";
//            pst = con.prepareStatement(Sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            pst.setString(1, bericht.getDokumentation());
//            pst.setString(2, bericht.getZeit());
//            pst.setInt(3, bericht.getNachweis_id());
//            pst.executeUpdate();
//            rst = pst.getGeneratedKeys();
//            while (rst.next()) {
//                bericht.setId(rst.getInt(1));
//            }         
//            
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (pst != null) {
//                    pst.close();
//                }
//                if (rst != null) {
//                    rst.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }
}
