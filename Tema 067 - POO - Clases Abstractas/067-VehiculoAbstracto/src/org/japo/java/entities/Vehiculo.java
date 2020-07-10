/*
 * Copyright (C) 2020 mon_mode   0mon.mode@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Random;
import org.japo.java.interfaces.IVehiculo;
import org.japo.java.utils.UtilesVehiculo;

/**
 *
 * @author Jonsui
 */
public abstract class Vehiculo implements IVehiculo, Serializable {

    private static final long serialVersionUID = -5342745202200964198L;
    public static final int MIN_KM = 0;
    public static final int MAX_KM_MOTO = 5;
    public static final int MAX_KM_CAMION = 20;
    public static final int MARGEN_REVISION = 50;
    public static final int MARGEN_CAMION = 5000;
    public static final int MARGEN_MOTO = 12500;

    public static final int DEF_CONTADOR;

    static {
        final int CONTADOR_MIN = 0;
        final int CONTADOR_MAX = 20;

        final Random RND = new Random();

        DEF_CONTADOR = RND.nextInt(CONTADOR_MAX - CONTADOR_MIN + 1)
                + CONTADOR_MIN;
    }

    private String tipoVehiculo;
    private double kmRecorridos;
    private int revisiones;
    private int contador;

    public Vehiculo() {
        contador = DEF_CONTADOR;
    }

    public Vehiculo(int contador) {
        if (UtilesVehiculo.validarContador(contador)) {
            this.contador = contador;
        } else {
            this.contador = DEF_CONTADOR;
        }
    }

    public Vehiculo(String tipoVehiculo, double kmRecorridos, int revisiones, int contador) {
        this.tipoVehiculo = tipoVehiculo;
        this.kmRecorridos = kmRecorridos;
        this.revisiones = revisiones;
        if (validar(contador)) {
            this.contador = contador;
        } else {
            this.contador = DEF_CONTADOR;
        }
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }

    public int getRevisiones() {
        return revisiones;
    }

    public int getContador() {
        return contador;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public void setRevisiones(int revisiones) {
        this.revisiones = revisiones;
    }

    public void setContador(int contador) {
        if (validar(contador)) {
            this.contador = contador;
        }
    }

    private boolean validar(int contador) {
        return contador >= DEF_CONTADOR;
    }

}
