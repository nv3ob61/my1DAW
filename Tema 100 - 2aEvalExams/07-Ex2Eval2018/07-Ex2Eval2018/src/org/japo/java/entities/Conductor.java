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
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jonsui
 */
public class Conductor implements Serializable {

  private static final long serialVersionUID = 8681655436913251248L;

  public static final String DEF_DNI = "12345678X";
  public static final String DEF_NOMBRE = "PacoPrueba";
  public static final String DEF_APELLIDO = "ACaballoApellido";
  public static final int DEF_EDAD = 58;

  private String dni;
  private String nombre;
  private String apellido1;
  private int edad;

  public Conductor() {
    dni = DEF_DNI;
    nombre = DEF_NOMBRE;
    apellido1 = DEF_APELLIDO;
    edad = DEF_EDAD;
  }
  
  public Conductor(String dni){
    this.dni = dni;
  }

  public Conductor(String dni, String nombre, String apellido1, int edad) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.edad = edad;
  }

  public String getDni() {
    return dni;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido1() {
    return apellido1;
  }

  public int getEdad() {
    return edad;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Conductor)) {
      testOk = false;
    } else {
      testOk = dni.equals(((Conductor) o).getDni())
              && nombre.equals(((Conductor) o).getNombre())
              && apellido1.equals(((Conductor) o).getApellido1())
              && edad == ((Conductor) o).getEdad();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + Objects.hashCode(this.dni);
    hash = 53 * hash + Objects.hashCode(this.nombre);
    hash = 53 * hash + Objects.hashCode(this.apellido1);
    hash = 53 * hash + this.edad;
    return hash;
  }

  @Override
  public String toString() {
    return String.format("INFO CONDUCTOR%n"
            + "--------------%n"
            + "DNI .........: %s%n"
            + "Nombre ......: %s%n"
            + "Apellido ....: %s%n"
            + "Edad ........: %d%n", dni, nombre, apellido1, edad);
  }

  public void mostrarInfoConductor(){
    System.out.println(toString());
  }
}
