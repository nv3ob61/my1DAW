/* 
 * Copyright (C) 2020 CicloM
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

/**
 *
 * @author CicloM
 */
public class UtilesEmpleado {

    //Tipos empleados
    public static final String DEF_TIPO1 = "Operario";
    public static final String DEF_TIPO2 = "Encargado";
    //Tipos seccion    
    public static final String SEC_PROD = "Produccion";
    public static final String SEC_ALMA = "Almacen";
    public static final String SEC_MANT = "Mantenimient";

    public static boolean validarCargo(String cargo) {
        boolean isOk = false;
        if (cargo.equals(DEF_TIPO1) || cargo.equals(DEF_TIPO2)) {
            isOk = true;
        }
        return isOk;
    }

    public static boolean validarSeccion(String sec) {
        boolean isOk = false;
        if (sec.equals(SEC_ALMA) || sec.equals(SEC_MANT)
                || sec.equals(SEC_PROD)) {
            isOk = true;
        }
        return isOk;
    }

    public static boolean validarProduccion(int prod) {
        return prod >= 0;
    }
}
