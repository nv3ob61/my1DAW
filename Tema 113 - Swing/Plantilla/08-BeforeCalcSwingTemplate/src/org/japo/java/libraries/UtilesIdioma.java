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
public final class UtilesIdioma {

    // Dias de la Semana
    public static final int LUNES = 1;
    public static final int MARTES = 2;
    public static final int MIERCOLES = 3;
    public static final int JUEVES = 4;
    public static final int VIERNES = 5;
    public static final int SABADO = 6;
    public static final int DOMINGO = 7;

    // Código
    public static final int CODIGO_ESP = 34;
    public static final int CODIGO_ING = 44;
    public static final int CODIGO_ALE = 49;

    // Idiomas
    public static final String NOMBRE_ESP = "Español";
    public static final String NOMBRE_ING = "Inglés";
    public static final String NOMBRE_ALE = "Alemán";

    // Códigos de Idioma
    public static final int[] LISTA_IDIOMAS = {
        UtilesIdioma.CODIGO_ESP, UtilesIdioma.CODIGO_ING, UtilesIdioma.CODIGO_ALE
    };

    // Dias - Español
    public static final String[] DIAS_ESP = {
        "Lunes", "Martes", "Miércoles", "Jueves",
        "Viernes", "Sábado", "Domingo"
    };

    // Dias - Inglés
    public static final String[] DIAS_ING = {
        "Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday"};

    // Dias - Alemán
    public static final String[] DIAS_ALE = {
        "Montag", "Dienstag", "Mittwoch", "Donnerstag",
        "Freitag", "Samstag", "Sontag"};

    // ATENCION >>> Lunes: 1 - Domingo: 7 <<<
    public static final String generarNombreDia(int dia, int idioma) {
        // Día actual
        String nombre;

        // Análisis idioma
        try {
            switch (idioma) {
                case CODIGO_ESP:
                    nombre = String.format("%s (%s)",
                            DIAS_ESP[dia - 1], NOMBRE_ESP);
                    break;
                case CODIGO_ING:
                    nombre = String.format("%s (%s)",
                            DIAS_ING[dia - 1], NOMBRE_ING);
                    break;
                case CODIGO_ALE:
                    nombre = String.format("%s (%s)",
                            DIAS_ALE[dia - 1], NOMBRE_ALE);
                    break;
                default:
                    nombre = "Desconocido";
            }
        } catch (Exception e) {
            nombre = "Desconocido";
        }

        // Devuelve nombre
        return nombre;
    }
}
