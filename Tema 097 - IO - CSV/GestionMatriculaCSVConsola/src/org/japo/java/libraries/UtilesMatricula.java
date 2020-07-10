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

import java.text.ParseException;
import java.util.Date;
import org.japo.java.entities.Matricula;
import org.japo.java.enumerations.EstadoAlumn;

/**
 *
 * @author Jonsui
 */
public class UtilesMatricula {

  //largo del NIA
  public static final int NIA_LONG = 8;

  public static final boolean checkDatosAlta(Matricula m) {  //sin fecha
    return m.getNombre().equals("") || m.getApellidos().equals("")
            || m.getDni().equals("") || m.getDomicilio().equals("")
            || m.getDomicilio().equals("")
            || m.getCp().equals("") || m.getLocalidad().equals("")
            || m.getTelefono().equals("") || m.getEmail().equals("")
            || m.getTutor().equals("");
  }

  //método que comprueba en Matricula y muestra null o la fecha.
  public static String formatDateTime(Date dateOrNull) {
    return (dateOrNull == null ? null : Matricula.SDF.format(dateOrNull));
  }

  public static String generarNia() {   //generaba NIA aleatorio
    StringBuilder sb = new StringBuilder(NIA_LONG);
    //Genera nia del 00 hasta el 99 en teoría, añadiendo 8 ceros delante
    for (int i = 0; i < NIA_LONG - 2; i++) {
      int index = 0;
      sb.append(index);
    }
    for (int i = 0; i < NIA_LONG - 6; i++) {
      int index = (int) (Math.random() * 9);
      sb.append((index));
    }
    return sb.toString();
  }

  //generador ACTUAL del NIA. entero es una conversión a String de hacerle 
  //un wrap Integer al nia (y sumarle la siguiente pos. de NIA) para determinar
  //la longitud del dígito, a rellenar con tantos 0 como NIA_LONG
  public static final String generarNia(String nia) {
    StringBuilder sb = new StringBuilder(NIA_LONG);

    //generador siguiente nia
    String entero = String.valueOf(Integer.parseInt(nia) + 1);

    //CUENTA LOS 0 que hay restando la longitud del String entero anterior
    for (int i = 0; i < NIA_LONG - entero.length(); i++) {
      if (nia.charAt(i) == '0') {
        //añade 0
        sb.append('0');
      }
    }
    sb.append(entero);
    //Devuelve el String con el formato de la siguiente matrícula.
    return sb.toString();
  }

  public static final String obtenerNombreEstado(EstadoAlumn estado) {
    String st;

    if (estado == null) {
      st = "en_tramite";
    } else if (estado.equals(EstadoAlumn.ACTIVO)) {
      st = "activo";
    } else if (estado.equals(EstadoAlumn.BAJA)) {
      st = "baja";
    } else if (estado.equals(EstadoAlumn.EN_TRAMITE)) {
      st = "en_tramite";
    } else {
      st = "en_tramite";
    }
    return st;
  }

  public static final EstadoAlumn generarEstado(String estado) {
    EstadoAlumn ea;   // ea, ea, ea...

    if (null == estado) {
      ea = EstadoAlumn.EN_TRAMITE;
    } else {
      switch (estado) {
        case "en_tramite":
          ea = EstadoAlumn.EN_TRAMITE;
          break;
        case "activo":
          ea = EstadoAlumn.ACTIVO;
          break;
        case "baja":
          ea = EstadoAlumn.BAJA;
          break;
        default:
          ea = EstadoAlumn.EN_TRAMITE;
      }
    }
    return ea;
  }
//método que devuelve el estado del getEstado de la Matrícula correspondiente
  public static final EstadoAlumn generarEstado(Matricula m, String estado) {
    EstadoAlumn ea;   // ea, ea, ea...

    if (null == estado) {
      ea = m.getEstadoAlumn();
    } else {
      switch (estado) {
        case "en_tramite":
          ea = EstadoAlumn.EN_TRAMITE;
          break;
        case "activo":
          ea = EstadoAlumn.ACTIVO;
          break;
        case "baja":
          ea = EstadoAlumn.BAJA;
          break;
        default:
          ea = m.getEstadoAlumn();
      }
    }
    return ea;
  }

  public static final boolean validarEstado(EstadoAlumn estado) {
    return estado.equals(EstadoAlumn.ACTIVO)
            || estado.equals(EstadoAlumn.BAJA)
            || estado.equals(EstadoAlumn.EN_TRAMITE);
  }
  
    
  public static final boolean validarRangoAdmision(Date d) throws ParseException{
    boolean isOk = false;
    if(d != null){
      if (d.after(UtilesFecha.fechaMin())
              && d.before(UtilesFecha.fechaMax())) {
        isOk = true;
      }
    }
    return isOk;
  }
}
