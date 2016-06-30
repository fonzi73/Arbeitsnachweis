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
public class Methoden {
    
    private ArrayList<Benutzer> benutzerL = Benutzer.getAll();
    private ArrayList<Nachweis> nWs = Nachweis.getAll();
    private ArrayList<Bericht> nBs = Bericht.getAll();
    private int aktuellerNWIndex;
    
    public Methoden(){
        
    }

    @Override
    public String toString() {
        return "Methoden{" + "benutzerL=" + benutzerL + ", nWs=" + nWs + ", nBs=" + nBs + ", aktuellerNWIndex=" + aktuellerNWIndex + '}';
    }
    
    public Nachweis getAktuellenNachweis(){
        return nWs.get(aktuellerNWIndex);
    }
    
    public void setAktuellenNachweis(Nachweis nW) {
        Nachweis.update(nW);
        nWs.set(aktuellerNWIndex, nW);
        
    }
    
    public void addNachweis(Nachweis nW) {
        Nachweis.insert(nW);
        nWs.add(nW);
        aktuellerNWIndex = nWs.size() - 1;
    }
    
    
    public Nachweis getNextNachweis(){
        if (aktuellerNWIndex == nWs.size() - 1) {
            aktuellerNWIndex = 0;
        } else {
            aktuellerNWIndex++;
        }
        return getAktuellenNachweis();
    }
    
    public Nachweis getPrevNachweis() {
        if (aktuellerNWIndex == 0) {
            aktuellerNWIndex = nWs.size() - 1;
        } else {
            aktuellerNWIndex--;
        }
        return getAktuellenNachweis();
    }

    public Nachweis getById(int id) {
        for (int i = 0; i < nWs.size(); i++) {
            if (nWs.get(i).getId() == id) {
                aktuellerNWIndex = i;
                break;
            }
        }
        return getAktuellenNachweis();
    }
    
    
    
}
