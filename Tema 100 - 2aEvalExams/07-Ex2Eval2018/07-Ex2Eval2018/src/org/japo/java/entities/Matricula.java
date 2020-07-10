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
 * 
 * Todo nace de esta clase, que no es abstracta aunque es la que extiende
 * la clase vehículo. Podríamos añadir un bastidor que también es un atributo
 *  unívoco en todos los vehículos.
 */
public class Matricula implements Serializable {

  private static final long serialVersionUID = 4052803894942037078L;

  public static final int MATRICULA_LEN = 8;
  public static final int DIGI_LEN = 4;
  public static final int CHAR_LEN = 3;
  public static final String LISTA_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String LISTA_DIGI = "0123456789";

  //                  formato de la matrícula: 1111-XXX
  public static final String EXP_MATRICULA = "^[0-9]{4}-[A-Z]{3}$";

  String matricula;

  public Matricula() {
    matricula = generaMatricula();
  }
//En este constr se debería validar la matrícula

  public Matricula(String matricula) {
    if (matricula.matches(EXP_MATRICULA)) {
      this.matricula = matricula;
    } else {
      this.matricula = generaMatricula();
    }
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    if (matricula.matches(EXP_MATRICULA)) {
      this.matricula = matricula;
    }
  }

  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Matricula)) {
      testOk = false;
    } else {
      testOk = matricula.equals(((Matricula) o).getMatricula());
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 89 * hash + Objects.hashCode(this.matricula);
    return hash;
  }
  
  
  //Se genera una matrícula llamando al constructor por defecto o cuando
  //al parametrizado se le pasa un formato fuera del correcto: 1111-XXX
  private String generaMatricula() {
    StringBuilder sb = new StringBuilder(MATRICULA_LEN);
    //Generamos 4 números  (resta -1 por el guión  (regulero.....)
    for (int i = 0; i < MATRICULA_LEN - CHAR_LEN - 1; i++) {
      int index = (int) (LISTA_DIGI.length() * Math.random());
      sb.append(LISTA_DIGI.charAt(index));
    }
    //Añadimos el guión de la matrícula
    sb.append('-');
    //Falta generar 3 char y añadirlos al sb
    for (int i = 0; i < MATRICULA_LEN - DIGI_LEN - 1; i++) {
      int index = (int) (LISTA_CHAR.length() * Math.random());
      sb.append(LISTA_CHAR.charAt(index));
    }
    return sb.toString();
  }


}
