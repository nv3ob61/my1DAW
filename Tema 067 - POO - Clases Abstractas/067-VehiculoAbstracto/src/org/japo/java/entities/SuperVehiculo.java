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

import org.japo.java.utils.UtilesVehiculo;

/**
 *
 * @author Jonsui
 */
public abstract class SuperVehiculo extends Vehiculo {

    private static final long serialVersionUID = -119606274953117798L;

    public static final int KM_REVISION = 5000;
    public static final int CONTADOR_MAX = 20;
    public static final int MARGEN_REV = 50;

    public SuperVehiculo() {
        super();
    }

    public SuperVehiculo(int contador) {
        super(contador);
    }

    @Override
    public int obtenerRevisiones() {

        return getContador() / KM_REVISION;
    }

    @Override
    public void mostrarInfo(int kmRevision) {
        String tipo = getClass().getSimpleName();
        int contador = getContador();
        int revisiones = obtenerRevisiones();
        int kmRestantes = UtilesVehiculo.obtenerRestante(contador, kmRevision);
//        int kmRestantes = KM_REVISION - contador % KM_REVISION;
//        boolean revisionOk = kmRestantes <= MARGEN_REVISION;
        if(UtilesVehiculo.comprobarProximidad(contador, kmRevision)) {
            System.out.printf("%s - %07d km - %03d revisiones - %d km restantes"
                    + "para la siguiente revisi'on%n", tipo, contador, 
                    revisiones, kmRestantes);
        } else {
                        System.out.printf("%s - %07d km - %03d revisiones%n"
                    , tipo, contador, revisiones);
        }
    }
}
