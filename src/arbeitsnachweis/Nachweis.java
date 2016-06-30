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
import jdk.nashorn.internal.codegen.CompilerConstants;
import java.util.Date;

/**
 *
 * @author fonzi
 */
public class Nachweis {

    // Konnektoren DB
    static Connection con = null;
    static PreparedStatement pst = null;
    static Statement st = null;
    static ResultSet rst = null;

    // Objekt Variablen
    private int id;
    private int nr;
    private int benutzer_id;
    private Date datum;
    private int jahr;
    private ArrayList<Nachweis> nachweisL;
    private ArrayList<Bericht> berichtL;

    // Konstruktor
    public Nachweis(int id, int nr, int benutzer_id, Date datum, int jahr) {
        this.id = id;
        this.nr = nr;
        this.benutzer_id = benutzer_id;
        this.datum = datum;
        this.jahr = jahr;
    }

    public Nachweis(int id, int nr, int benutzer_id, Date datum) {
        this.id = id;
        this.nr = nr;
        this.benutzer_id = benutzer_id;
        this.datum = datum;
    }

    public Nachweis(int id, int nr, int benutzer_id) {
        this.id = id;
        this.nr = nr;
        this.benutzer_id = benutzer_id;
    }

    // Getter
    public int getId() {
        return id;
    }

    public int getNr() {
        return nr;
    }

    public int getBenutzer_id() {
        return benutzer_id;
    }

    public Date getDatum() {
        return datum;
    }

    public ArrayList<Nachweis> getNachweisL() {
        return nachweisL;
    }

    public int getJahr() {
        return jahr;
    }

    public ArrayList<Bericht> getBerichtL() {
        return berichtL;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setBenutzer_id(int benutzer_id) {
        this.benutzer_id = benutzer_id;
    }

    public void setNachweisL(ArrayList<Nachweis> nachweisL) {
        this.nachweisL = nachweisL;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setBerichtL(ArrayList<Bericht> berichtL) {
        this.berichtL = berichtL;
    }

    // toString
    @Override
    public String toString() {
        return "Nachweis{" + "id=" + id + ", nr=" + nr + ", benutzer_id=" + benutzer_id + '}';
    }

    /**
     * CRUD Funktionen
     *
     */
    /**
     * liefert alle Datensätze aus der Tabelle als ArrayList mit Ojekten zurück
     */
    public static ArrayList<Nachweis> getAll() {
        ArrayList<Nachweis> nachweisL = new ArrayList<>();
        try {
            // VERBINDUNG AUFBBAUEN:
            Connection con = MySQLConnection.getConnection();
            // STATEMENT
            String sql = "SELECT * FROM nachweis";
            st = con.createStatement();
            rst = st.executeQuery(sql);
            while (rst.next()) { // rst.next bewirkt ein Stop wen keine weiteren Datensätze vorhanden sind
                Nachweis nachweis = new Nachweis(rst.getInt("id"), rst.getInt("nr"),
                        rst.getInt("benutzer_id"), rst.getDate("datum"),
                        rst.getInt("jahr"));
                nachweisL.add(nachweis);
            }
            for (Nachweis nachweis : nachweisL) {
                nachweis.setBerichtL(Bericht.getAllByNachweisId(nachweis.getId()));
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
        return nachweisL;
    }

    public static void insert(Nachweis nW) {
        try {
            // VERBINDUNG AUFBBAUEN:
            Connection con = MySQLConnection.getConnection();
            // STATEMENT
            String Sql = "INSERT INTO nachweis VALUES (null, ?, ?, ?, ?)";
            pst = con.prepareStatement(Sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, nW.getNr());
            pst.setInt(2, nW.getBenutzer_id());
            pst.setString(3, "" + nW.getDatum());
            pst.setInt(4, nW.getJahr());
            pst.executeUpdate();
            rst = pst.getGeneratedKeys();
            while (rst.next()) {
                nW.setId(rst.getInt(1));
            }

            for (Bericht tB : nW.getBerichtL()) {
                Bericht.insert(tB);
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
            String sql = "UPDATE lernkarte SET nr=?, benutzer_id=?, jahr=? WHERE id=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, nW.getNr());
            pst.setInt(2, nW.getBenutzer_id());
            pst.setInt(3, nW.getJahr());
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

}
