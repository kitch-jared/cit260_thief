/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thief.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Tish
 */
public class Game implements Serializable {
    
    // class instance variables
    private int turnsRemaining;

    public Game() {
    }
    
    

    public int getTurnsRemaining() {
        return turnsRemaining;
    }

    public void setTurnsRemaining(int turnsRemaining) {
        this.turnsRemaining = turnsRemaining;
        
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.turnsRemaining;
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
        final Game other = (Game) obj;
        if (this.turnsRemaining != other.turnsRemaining) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Game{" + "turnsRemaining=" + turnsRemaining + '}';
    }

    
    

    
    
    
}