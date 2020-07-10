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
package org.siesta.java.entities;

import java.util.ArrayList;

/**
 *
 * @author Jonsui
 */
public class Cantante {

  public static final String ER_ANY = "([0-9]|[1-9][0-9]|[1-9][0-9]{2}|[1-9][0-9]{3})";
  public static final String DEF_NOMBRE = "Nombre Artista";
  public static final String DEF_DEBUT = "2020";
  public static final String DEF_ESTILO = "Estilo por defecto";
  public static final boolean DEF_ESGRUPO = false;

  private String nombre;
  private String anyoDebut;
  private String estilo;
  private boolean esGrupo;
  private ArrayList<String> discog = new ArrayList<>();

  public Cantante() {
    nombre = DEF_NOMBRE;
    anyoDebut = DEF_DEBUT;
    estilo = DEF_ESTILO;
    esGrupo = DEF_ESGRUPO;
    discog = new ArrayList<>();
  }

  public Cantante(String nombre, String anyoDebut, String estilo, boolean esGrupo) {
    this.nombre = nombre;
    if (validaAnyo(anyoDebut)) {
      this.anyoDebut = anyoDebut;
    } else {
      this.anyoDebut = DEF_DEBUT;
    }
    this.estilo = estilo;
    this.esGrupo = esGrupo;
    this.discog = new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }

  public String getAnyoDebut() {
    return anyoDebut;
  }

  public String getEstilo() {
    return estilo;
  }

  public boolean isEsGrupo() {
    return esGrupo;
  }


  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setAnyoDebut(String anyoDebut) {
    if (validaAnyo(anyoDebut)) {
      this.anyoDebut = anyoDebut;
    }
  }

  public void setEstilo(String estilo) {
    this.estilo = estilo;
  }

  public void setEsGrupo(boolean esGrupo) {
    this.esGrupo = esGrupo;
  }

  //Método que valida el año
  public final boolean validaAnyo(String anyo) {
    return anyo.matches(ER_ANY);
  }
}
