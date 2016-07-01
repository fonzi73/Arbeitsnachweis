/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsnachweis;

import static arbeitsnachweis.Benutzer.pst;
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
public class Heft {

    // Konnektoren DB
    static Connection con = null;
    static PreparedStatement pst = null;
    static Statement st = null;
    static ResultSet rst = null;

    private int id;
    private int benutzer_id;
    ArrayList<Nachweis> nWs = null;
    private Benutzer benutzer;
    private int aktuellerNWIndex;

    // Konstruktor
    public Heft(int id, int benutzer_id) {
        this.id = id;
        this.benutzer_id = benutzer_id;
    }

    public Heft(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public void ladeBenutzer() {
        benutzer = Benutzer.getById(1);
    }

    public void ladeNachweise() {
        nWs = Nachweis.getAllByHeftId(id);

    }

    public Nachweis getAktuellenNachweis() {
        return nWs.get(aktuellerNWIndex);
    }

    // Blättern vor
    public Nachweis getNextNachweis() {
        if (aktuellerNWIndex == nWs.size() - 1) {
            aktuellerNWIndex = 0;
        } else {
            aktuellerNWIndex++;
        }
        return getAktuellenNachweis();
    }

    // Blättern zurück
    public Nachweis getPrevNachweis() {
        if (aktuellerNWIndex == 0) {
            aktuellerNWIndex = nWs.size() - 1;
        } else {
            aktuellerNWIndex--;
        }
        return getAktuellenNachweis();
    }
    
    // Getter

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public ArrayList<Nachweis> getnWs() {
        return nWs;
    }
    
    
    
    // Setter

    public void setAktuellerNWIndex(int aktuellerNWIndex) {
        this.aktuellerNWIndex = aktuellerNWIndex;
    }
    

    @Override
    public String toString() {
        return "Heft{" + "id=" + id + ", benutzer_id=" + benutzer_id + ", nWs=" + nWs + ", benutzer=" + benutzer + '}';
    }

    public static Heft getById(int id) {
        ArrayList<Heft> heftL = new ArrayList<>();

        try {
            // VERBINDUNG AUFBBAUEN:
            Connection con = MySQLConnection.getConnection();
            // STATEMENT
            String sql = "SELECT * FROM heft WHERE id=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rst = pst.executeQuery();

            while (rst.next()) { // rst.next bewirkt ein Stop wenn keine weiteren Datensätze vorhanden sind
                Heft heft = new Heft(rst.getInt("id"), rst.getInt("benutzer_id"));
                heft.ladeBenutzer();
                heft.ladeNachweise();
                heft.setAktuellerNWIndex(heft.nWs.size() -1);
                heftL.add(heft);
                
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
        return heftL.get(0);
    }

}
