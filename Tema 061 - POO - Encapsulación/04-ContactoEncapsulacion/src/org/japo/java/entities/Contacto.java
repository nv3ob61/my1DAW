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
public class Contacto implements Serializable {

    private static final long serialVersionUID = 2L;

    private String alias;

    private int edad;
    // Instanciar Scanner

    public Contacto() {
        alias = "Achilipú";
        edad = 18;
    }

    public Contacto(String alias, int edad) {
        this.alias = alias;
        this.edad = edad;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 18) {
            this.edad = edad;
        }
    }
    
    public boolean esMayorDe() {
        boolean check = false;
        if (edad >= 18 ) {
            check = true;
        }
        return check;
    }

    @Override
    public String toString() {
        return this.getAlias() + "  -  " + this.getEdad();
    }
}
