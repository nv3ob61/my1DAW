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
package org.japo.java.utils;

import java.util.Random;
import org.japo.java.entities.Vehiculo;

/**
 *
 * @author Jonsui
 */
public class UtilesVehiculo {


    public static final int CONTADOR_MAX = 20;
    public static final int MARGEN_REV = 50;

    //Camion
    public static final int DEF_CARGA = 0;
    public static final int CARGA_MIN = 0;
    public static final int CARGA_MAX = 30000;

    public static final boolean validarContador(int contador) {
        return contador >= Vehiculo.DEF_CONTADOR;
    }

    public static final boolean validarPesoCarga(int pesoCarga) {
        return pesoCarga >= CARGA_MIN && pesoCarga <= CARGA_MAX;
    }

    //Km iniciales del vehiculo
    public static final int obtenerInicial() {
        final int CONTADOR_MIN = 0;

        final Random RND = new Random();

        return RND.nextInt(CONTADOR_MAX - CONTADOR_MIN + 1)
                + CONTADOR_MIN;
    }

    //Km hasta siguiente revision
    public static final int obtenerRestante(int contador, int kmRevision) {
        return kmRevision - contador % kmRevision;
    }

    //Decidir si la revision est'a cerca.
    public static final boolean comprobarProximidad(int contador, int kmRevision) {
        return obtenerRestante(contador, kmRevision) <= MARGEN_REV;
    }
}
