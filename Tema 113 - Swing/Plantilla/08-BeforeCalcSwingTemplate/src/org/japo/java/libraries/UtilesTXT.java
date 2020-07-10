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

import java.util.StringJoiner;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesTXT {

    // Longitud predeterminada Título formateado
    public static final int LONGITUD = 21;

    // Archivo TXT > Array Lineas Texto
    public static final String[] importar(String fichero) throws Exception {
        return UtilesFicheros.leerArrayFichero(fichero);
    }

    // Titulo > Titulo + SPC + puntos + ':' + SPC [longitud]
    public static final String formatearTitulo(String titulo, int longitud) {
        // Titulo > Mayúscula Inicial
        titulo = capitalizarTexto(titulo);

        // Genera Linea Puntos
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            buffer.append('.');
        }

        // Recorta Linea Puntos
        String puntos = buffer.toString().substring(titulo.length() + 2);

        // Genera y devuelve título formateado
        return String.format("%s %s: ", titulo, puntos);
    }

    // Titulo > Titulo + SPC + puntos + ':' + SPC [longitud]
    public static final String formatearTitulo(String titulo) {
        return formatearTitulo(titulo, LONGITUD);
    }

    // String > Mayuscula Inicial (capitalize)
    public static final String capitalizarTexto(String titulo) {
        return titulo.substring(0, 1).toUpperCase() + titulo.substring(1).toLowerCase();
    }

    // Array String + Separador > Enumeración String
    public static final String enumerar(String[] items, String separador) {
        // Buffer de Texto
        StringJoiner buffer = new StringJoiner(separador);

        // Acumulación de ítems
        for (String item : items) {
            buffer.add(item);
        }

        // Devolución enumeración
        return buffer.toString();
    }

    // Array String > Enumeración String
    public static final String enumerar(String[] items) {
        return enumerar(items, UtilesCSV.SEPARADOR_ESCRITURA);
    }
}
