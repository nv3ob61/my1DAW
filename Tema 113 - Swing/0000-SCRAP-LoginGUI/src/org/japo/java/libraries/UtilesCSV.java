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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesCSV {

    // Separadores
    public static final String SEPARADOR_LECTURA = "\\s*,\\s*";
    public static final String SEPARADOR_ESCRITURA = ", ";

    // Primera Linea Archivo CSV > Lista Items
    public static final String[] importarLinea(String fichero)
            throws Exception {
        // Lista Items (Vacio)
        String[] items;

        // Importar Items
        try (
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr)) {
            // Fichero CSV > Linea Items (1ª Linea)
            String linea = br.readLine();

            // Linea Items > Lista Items
            items = convertir(linea);
        }

        // Devolver Items
        return items;
    }

    // Lista Items > Primera Linea Archivo CSV
    public static final void exportarLinea(String[] items, String fichero)
            throws Exception {
        // Lectura de un fichero de texto
        try (
                FileWriter fw = new FileWriter(fichero);
                PrintWriter pw = new PrintWriter(fw)) {

            // Lista Items > Linea Items
            String linea = convertir(items);

            // Primer item por separado
            pw.print(linea);

            // Confirmacion
            pw.flush();
        }
    }

    // Array String > Secuencia String
    public static final String convertir(String[] items, String separador) {
        // Acumulador
        StringBuilder sb = new StringBuilder();

        // Primer item por separado
        sb.append(items[0]);

        // Resto de los items
        for (int i = 1; i < items.length; i++) {
            sb.append(separador);
            sb.append(items[i]);
        }

        // Devuelve Secuencia
        return sb.toString();
    }

    // Array String > Secuencia String - Separador Predeterminado
    public static final String convertir(String[] items) {
        return convertir(items, SEPARADOR_ESCRITURA);
    }

    // Secuencia String > Array String
    public static final String[] convertir(String secuencia, String separador) {
        return secuencia.split(separador);
    }

    // Secuencia String > Array String - Separador Predeterminado
    public static final String[] convertir(String secuencia) {
        return convertir(secuencia, SEPARADOR_LECTURA);
    }
}
