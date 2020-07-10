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
package org.japo.java.libraries;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesPrimitivos {

    // Constantes referenciales
    public static final int MAYOR = 1;
    public static final int MENOR = -1;
    public static final int IGUAL = 0;

    // Comprueba la paridad de un número entero
    public static final boolean validarParidad(int num) {
        return num % 2 == 0;
    }

    // Comprueba la paridad de un número real
    public static final boolean validarParidad(double num) {
        return num % 2 == 0;
    }

    // Comprueba el signo de un número entero
    public static final boolean validarSigno(int num) {
        return num >= 0;
    }

    // Comprueba el signo de un número real
    public static final boolean validarSigno(double num) {
        return num >= 0;
    }

    // Devuelve el mayor de dos números enteros
    public static final int obtenerMayor(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    // Devuelve el mayor de dos números reales
    public static final double obtenerMayor(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    // Devuelve el menor de dos números enteros
    public static final int obtenerMenor(int n1, int n2) {
        return n1 < n2 ? n1 : n2;
    }

    // Devuelve el menor de dos números reales
    public static final double obtenerMenor(double n1, double n2) {
        return n1 < n2 ? n1 : n2;
    }

    // Devuelve la relación entre dos números
    public static final int obtenerRelacion(double n1, double n2) {
        return n1 > n2 ? MAYOR : n1 < n2 ? MENOR : IGUAL;
    }
}
