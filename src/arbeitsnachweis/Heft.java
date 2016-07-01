/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbeitsnachweis;

import java.util.ArrayList;

/**
 *
 * @author fonzi
 */
public class Heft {
    
    
    private int id;
    private int benutzer_id;
    ArrayList<Nachweis> nWs = null;
    private Benutzer benutzer;

    // Konstruktor
    public Heft(int id, Benutzer benutzer) {
        this.id = id;
        this.benutzer = benutzer;
    }

    public Heft(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

   
    
    
    
    
    
}
