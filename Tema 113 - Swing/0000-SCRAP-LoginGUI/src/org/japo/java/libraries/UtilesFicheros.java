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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesFicheros {

    // Nombre predeterminado del Fichero
    public static final String FICHERO = "datos.txt";

//    // Linea texto > Fichero (Nuevo)
//    public static final boolean escribirLineaFichero(String dato, String fichero) {
//        // Semáforo
//        boolean procesoOK = true;
//
//        // Proceso Escritura
//        try (FileWriter fw = new FileWriter(fichero)) {
//            fw.append(dato + System.getProperty("line.separator"));
//        } catch (Exception e) {
//            procesoOK = false;
//        }
//
//        // Devolución Semáforo
//        return procesoOK;
//    }
//
    // Linea texto > Fichero (Nuevo)
    public static final boolean escribirLineaFichero(String dato, String fichero) {
        return escribirLineaFichero(dato, fichero, false);
    }

    // Linea texto > Fichero (Nuevo)
    public static final boolean escribirLineaFichero(String dato) {
        return escribirLineaFichero(dato, FICHERO, false);
    }

    // Linea texto + Semáforo > Fichero
    public static final boolean escribirLineaFichero(String dato, String fichero, boolean append) {
        // Semáforo
        boolean procesoOK = true;

        // Proceso Escritura
        try (FileWriter fw = new FileWriter(fichero, append)) {
            fw.append(dato + System.getProperty("line.separator"));
        } catch (Exception e) {
            procesoOK = false;
        }

        // Devolución Semáforo
        return procesoOK;
    }

    // Linea texto + Semáforo > Fichero
    public static final boolean escribirLineaFichero(String dato, boolean append) {
        return escribirLineaFichero(dato, FICHERO, append);
    }

    // Array Lineas de Texto > Fichero
    public static final boolean escribirArrayFichero(String[] array, String fichero) {
        // Semáforo
        boolean procesoOK = true;

        // Proceso Escritura
        try (FileWriter fw = new FileWriter(fichero)) {
            for (String linea : array) {
                fw.append(linea + System.getProperty("line.separator"));
            }
        } catch (Exception e) {
            procesoOK = false;
        }

        // Devolución Semáforo
        return procesoOK;
    }

    // Array Lineas de Texto > Fichero
    public static final boolean escribirArrayFichero(String[] array) {
        return escribirArrayFichero(array, FICHERO);
    }

    // Fichero > Linea de texto
    public static final String leerLineaFichero(String fichero) {
        // Referencia Linea
        String linea;

        // Proceso Lectura
        try (
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr)) {
            linea = br.readLine();
        } catch (Exception e) {
            linea = null;
        }

        // Devolución Linea
        return linea;
    }

    // Fichero > Linea de texto
    public static final String leerLineaFichero() {
        return leerLineaFichero(FICHERO);
    }

    // Fichero > Múltiples Lineas de texto
    public static final String leerTextoFichero(String fichero) {
        // Referencia texto
        String texto;

        // Almacén de Lineas de Texto
        StringBuilder buffer = new StringBuilder();

        // Proceso Lectura
        try (
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr)) {
            // Referencia Linea de Texto Actual
            String linea;

            // Bucle Recorrido Lineas Fichero
            do {
                // Lectura Linea Actual
                linea = br.readLine();

                // Incorporación Linea Actual
                if (linea != null) {
                    if (buffer.length() > 0) {
                        buffer.append(System.getProperty("line.separator"));
                    }
                    buffer.append(linea);
                }
            } while (linea != null);

            // Extracción del Texto Acumulado
            texto = buffer.toString();
        } catch (Exception e) {
            texto = null;
        }

        // Devolución Linea
        return texto;
    }

    // Fichero > Múltiples Lineas de texto
    public static final String leerTextoFichero() {
        return leerTextoFichero(FICHERO);
    }

    // Fichero > Array Lineas de texto
    public static final String[] leerArrayFichero(String fichero) {
        // Referencia Array
        String[] array;

        // Lista Lineas de Texto
        List<String> lista = new ArrayList<>();

        // Proceso Lectura
        try (
                FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr)) {
            // Referencia Linea de Texto Actual
            String linea;

            // Bucle Recorrido Lineas Fichero
            do {
                // Lectura Linea Actual
                linea = br.readLine();

                // Incorporación Linea Actual
                if (linea != null) {
                    lista.add(linea);
                }
            } while (linea != null);

            // Extracción del Texto Acumulado
            array = lista.toArray(new String[lista.size()]);
        } catch (Exception e) {
            array = null;
        }

        // Devolución Linea
        return array;
    }

    // Fichero > Array Lineas de texto
    public static final String[] leerArrayFichero() {
        return leerArrayFichero(FICHERO);
    }
}
