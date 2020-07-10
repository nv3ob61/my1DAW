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
import org.japo.java.entities.Alquiler;

/**
 *
 * @author Jonsui
 */
public class ListaAlquilados {

  private final ArrayList<Alquiler> listaAlquiler;

  public ListaAlquilados() {
    listaAlquiler = new ArrayList<>();
  }

  public ListaAlquilados(ArrayList<Alquiler> listaAlquiler) {
    this.listaAlquiler = listaAlquiler;
  }

  //añadir un alquiler
  public boolean addAlquiler(Alquiler al) {
    boolean isOk = false;
    if (al != null) {
      isOk = this.listaAlquiler.add(al);
    }
    return isOk;
  }

  //Comprobar que el vehículo ya está alquilado
  public boolean estaAlquilado(String mat) {
    boolean found = false;
    int i = 0;

    while (i < listaAlquiler.size() && !found) {
      if (listaAlquiler.get(i).getVehi().getMatricula().equalsIgnoreCase(mat)) {
        found = true;
      }
      i++;
    }
    return found;
  }

  //Devuelve el alquiler de un vehículo por la matrícula
  //null si no existe
  public Alquiler devuelveAlquiler(String mat) {
    Alquiler al;
    Alquiler found = null;
    boolean exit = false;

    Iterator<Alquiler> it = listaAlquiler.iterator();

    while (exit == false && it.hasNext()) {
      al = it.next();
      if (al.getVehi().getMatricula().equalsIgnoreCase(mat)) {
        exit = true;
        found = al;
      }
    }
    return found;
  }

  //Boora un alquiler de la lista distinto a null,
  //Devuelve true si lo borra
  public boolean borrarAlquiler(String mat) {
    boolean del = false;
    Alquiler a;
    a = devuelveAlquiler(mat);
    if (a != null) {
      del = listaAlquiler.remove(a);
    }
    return del;
  }

  //borra un elemento Alquiler de la lista.
  public boolean borrarAlquiler(Alquiler a) {
    boolean del = false;
    if (a != null) {
      del = listaAlquiler.remove(a);
    }
    return del;
  }

  //Falta el método para mostrar Alquilados por DNI
  public Alquiler dimeAlquilados(String dni) {
    Alquiler al;
    Alquiler found = null;
    boolean exit = false;
    Iterator<Alquiler> it = listaAlquiler.iterator();

    while (exit == false && it.hasNext()) {
      al = it.next();
      if (al.getConductor().getDni().equalsIgnoreCase(dni)) {
        exit = true;
        found = al;
      }
    }
    return found;
  }
}
