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
    
    // Konstruktor
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
    
    // toString
    @Override
    public String toString() {
        return "Nachweis{" + "id=" + id + ", nr=" + nr + ", benutzer_id=" + benutzer_id + '}';
    }
    
    /**
     * CRUD Funktionen
     * 
     */
    
    
}
