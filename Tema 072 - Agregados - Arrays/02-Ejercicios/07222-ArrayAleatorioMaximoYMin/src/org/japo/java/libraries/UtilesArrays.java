/*
 * Copyright (C) 2020 Jonsui
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.japo.java.libraries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jonsui
 */
public class UtilesArrays {

  public static final double obtenerMaximo(double[] lista) {
    List<Double> list = new ArrayList<>();
    for (int i = 0; i < lista.length; i++) {
      list.add(lista[i]);
    }
    return Collections.max(list);
  }

  public static final double obtenerMinimo(double[] lista) {
    List<Double> list = new ArrayList<>();
    for (int i = 0; i < lista.length; i++) {
      list.add(lista[i]);
    }
    return Collections.min(list);
  }

  public static final int posMaximo(double[] lista) {
    // Primero es maximo
    int posicion = 0;

    // Recorrer a partir del segundo
    for (int actual = 1; actual < lista.length; actual++) {
      posicion = lista[actual] > lista[posicion] ? actual : posicion;
    }

    // Devolver posicion
    return posicion + 1;
  }

  // int[] > Posición (Primera) Valor Mínimo
  public static final int posMinimo(double[] lista) {
    // Primero es maximo
    int posicion = 0;

    // Recorrer a partir del segundo
    for (int actual = 1; actual < lista.length; actual++) {
      posicion = lista[actual] < lista[posicion] ? actual : posicion;
    }

    // Devolver posicion
    return posicion + 1;
  }
}
