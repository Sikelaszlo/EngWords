/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EngWords;

import java.util.Objects;
import java.util.Scanner;

/**
 * Angol szavak gyakoroltatásához készült osztály.
 * Angol és magyar szópárokat tételez fel, valamint tartalmazza annak a leckének a számát, amiben először előfordul.
 * @author Sike Laszlo
 */
public class Words {
    private String angol; //a szó angolul
    private String magyar; // a szó magyarul
    private int lecke;

    public Words(String angol, String magyar, int lecke) {
        this.angol = angol;
        this.magyar = magyar;
        this.lecke = lecke;
    }

    public String getAngol() {
        return angol;
    }

    public String getMagyar() {
        return magyar;
    }

    public int getLecke() {
        return lecke;
    }

    public void setAngol(String angol) {
        this.angol = angol;
    }

    public void setMagyar(String magyar) {
        this.magyar = magyar;
    }

    public void setLecke(int lecke) {
        this.lecke = lecke;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Words other = (Words) obj;
        if (!Objects.equals(this.angol, other.angol)) {
            return false;
        }
        if (!Objects.equals(this.magyar, other.magyar)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Words{" + "angol=" + angol + ", magyar=" + magyar + ", lecke=" + lecke + '}';
    }
    
    public boolean helyes(String a, String m){
        return (a.equalsIgnoreCase(angol) && m.equalsIgnoreCase(magyar));
    }
    
}
