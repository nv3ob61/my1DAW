/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;

/**
 *
 * @author Jonsui
 */
public class Maceta implements Serializable {

  private static final long serialVersionUID = -8762856576609112345L;
    
    
    private String nombre;
    
    public Maceta() {
        nombre = "Anita";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
