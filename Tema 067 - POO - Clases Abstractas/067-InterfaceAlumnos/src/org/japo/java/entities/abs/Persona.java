/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities.abs;

import java.io.Serializable;
import org.japo.java.interfaces.ISocial;

/**
 *
 * @author Adrián Pérez Rodríguez - Adrianp899.estudios@gmail.com
 */
public abstract class Persona implements ISocial, Serializable {

    private static final long serialVersionUID = -1934983399710832379L;
    public static final String DEF_NOMBRE = "Óscar Maricón";

    private String nombre;

    public Persona() {
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String saludar() {
        return String.format("paco", nombre);
    }

}
