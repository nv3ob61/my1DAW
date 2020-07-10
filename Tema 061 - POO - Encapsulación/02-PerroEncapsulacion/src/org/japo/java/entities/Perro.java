/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;

/**
 *
 * @author CicloM
 */
public class Perro implements Serializable {
    
    private static final long serialVersionUID = 2L;
    
    private boolean cuarentena;
    
    public Perro() {
        cuarentena = false;
    }

    public boolean isCuarentena() {
        return cuarentena;
    }

    public void setCuarentena(boolean cuarentena) {
        this.cuarentena = cuarentena;
    }
}
