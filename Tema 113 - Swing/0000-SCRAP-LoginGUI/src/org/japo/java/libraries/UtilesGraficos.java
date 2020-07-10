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

import java.awt.Color;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesGraficos {

    // Color > Nombre Color
    public static final String obtenerNombreColor(Color color) {
        String nombreColor;
        if (color == null) {
            nombreColor = "indefinido";
        } else if (color.equals(Color.BLACK)) {
            nombreColor = "negro";
        } else if (color.equals(Color.BLUE)) {
            nombreColor = "azul";
        } else if (color.equals(Color.CYAN)) {
            nombreColor = "celeste";
        } else if (color.equals(Color.GRAY)) {
            nombreColor = "gris";
        } else if (color.equals(Color.GREEN)) {
            nombreColor = "verde";
        } else if (color.equals(Color.MAGENTA)) {
            nombreColor = "púrpura";
        } else if (color.equals(Color.ORANGE)) {
            nombreColor = "naranja";
        } else if (color.equals(Color.PINK)) {
            nombreColor = "rosa";
        } else if (color.equals(Color.RED)) {
            nombreColor = "rojo";
        } else if (color.equals(Color.WHITE)) {
            nombreColor = "blanco";
        } else if (color.equals(Color.YELLOW)) {
            nombreColor = "amarillo";
        } else {
            nombreColor = "indefinido";
        }
        return nombreColor;
    }

    // Nombre Color > Color
    public static Color generarColor(String nombreColor) {
        Color c;
        if (null == nombreColor) {
            c = Color.BLACK;
        } else {
            switch (nombreColor.toLowerCase()) {
                case "negro":
                    c = Color.BLACK;
                    break;
                case "azul":
                    c = Color.BLUE;
                    break;
                case "celeste":
                    c = Color.CYAN;
                    break;
                case "gris":
                    c = Color.GRAY;
                    break;
                case "verde":
                    c = Color.GREEN;
                    break;
                case "púrpura":
                    c = Color.MAGENTA;
                    break;
                case "naranja":
                    c = Color.ORANGE;
                    break;
                case "rosa":
                    c = Color.PINK;
                    break;
                case "rojo":
                    c = Color.RED;
                    break;
                case "blanco":
                    c = Color.WHITE;
                    break;
                case "amarillo":
                    c = Color.YELLOW;
                    break;
                default:
                    c = Color.BLACK;
                    break;
            }
        }
        return c;
    }

}
