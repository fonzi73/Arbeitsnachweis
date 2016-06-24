/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsnachweis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
    
    
    
    
}
