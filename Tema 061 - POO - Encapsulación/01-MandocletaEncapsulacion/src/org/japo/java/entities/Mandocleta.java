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
public class Mandocleta implements Serializable {

    private static final long serialVersionUID = 1L;

    private double velocidad;

    public Mandocleta() {
        velocidad = 0.0;
    }

    public final double getVelocidad() {
        return velocidad;
    }

    public final void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
}
