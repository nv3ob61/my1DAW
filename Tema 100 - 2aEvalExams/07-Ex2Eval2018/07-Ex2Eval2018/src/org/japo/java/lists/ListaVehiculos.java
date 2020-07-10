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
package org.japo.java.lists;

import java.util.ArrayList;
import java.util.Iterator;
import org.japo.java.entities.Vehiculo;
import org.japo.java.entities.Camion;
import org.japo.java.entities.Coche;
import org.japo.java.entities.MicroBus;

/**
 *
 * @author Jonsui
 */
public class ListaVehiculos {

  private final ArrayList<Vehiculo> lista;

  public ListaVehiculos() {
    lista = new ArrayList<>();
  }

  public ListaVehiculos(ArrayList<Vehiculo> lista) {
    this.lista = lista;
  }

  //Método para añadir un vehículo
  public boolean addVehiculo(Vehiculo v) {
    boolean isOk = false;
    if (v != null) {
      isOk = lista.add(v);
    }
    return isOk;
  }

  //método para borrar un vehículo
  public boolean delVehiculo(Vehiculo v) {
    boolean del = false;
    if (v != null) {
      del = lista.remove(v);
    }
    return del;
  }

  //borrar vehículo por MAtrícula
  public boolean delMatriVehiculo(String mat) {
    boolean del = false;
    Vehiculo v;
    v = buscaVehiculo(mat);
    if (v != null) {
      del = lista.remove(v);
    }
    return del;
  }

  //método para mostrar todos los precios de alquileres
  public void mostrarPrecios(int dias) {
    System.out.printf("Precio Alquiler: x %d días%n%n", dias);
    for (Vehiculo vehiculo : lista) {
      vehiculo.muestraVehiculo();
      System.out.printf("Precio: %.2f €%n%n", vehiculo.precioAlquiler(dias));
    }
  }

  //método que muestra todos los datos de vehículos
  public void mostrarVehiculos(String tipo) {
    if (tipo.equalsIgnoreCase("Coche")) {
      for (Vehiculo vehiculo : lista) {
        if (vehiculo instanceof Coche) {
          vehiculo.muestraVehiculo();
        }
      }
      //separador
      System.out.println();
    } else if (tipo.equalsIgnoreCase("Camion")) {
      for (Vehiculo vehiculo : lista) {
        if (vehiculo instanceof Camion) {
          vehiculo.muestraVehiculo();
        }
      }
      //separador
      System.out.println();
    } else if (tipo.equalsIgnoreCase("MicroBus")) {
      for (Vehiculo vehiculo : lista) {
        if (vehiculo instanceof MicroBus) {
          vehiculo.muestraVehiculo();
        }
      }
      //separador
      System.out.println();
    }
  }

  //Método que busca vehículo por la matrícula.
  public Vehiculo buscaVehiculo(String mat) {
    Vehiculo v;
    Vehiculo enc = null;
    boolean exit = false;
    Iterator<Vehiculo> it = lista.iterator();

    while (exit == false && it.hasNext()) {
      v = it.next();
      if (v.getMatricula().equalsIgnoreCase(mat)) {
        exit = true;
        enc = v;
      }
    }
    return enc;
  }

  //Método para contar el total de vehículos en la lista
  public int numVehiculos() {
    return lista.size();
  }
}
