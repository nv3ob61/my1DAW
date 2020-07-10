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
package org.japo.java.enumerations;

/**
 *
 * @author mon_mo
 */
public enum Criterio {
  //Matricula
  NINGUNO("ninguno"),
  NIA("nia"),
  NOMBRE("nombre"),
  APELLIDOS("apellidos"),
  FECHA_NAC("fecha_nacimiento"),
  LOCALIDAD("localidad"),
  //ESTADO ALUMNOS
  ACTIVO("activo"),
  BAJA("baja"),
  EN_TRAMITE("en_tramite");
  private final String nombre;

  // Constructor Privado
  private Criterio(String nombre) {
    // Validar Nombre
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }
}
