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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mon_mo
 */
public class UtilesFecha {

  public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

  public static final String DEF_FECHA_MIN = "01/01/1920";
  public static final String DEF_FECHA_MAX = "31/12/2100";

  // ExpReg - Día del mes hasta 28 - [1..28] / [01..28]
  public static final String ER_DIA28 = "(0?[1-9]|1[0-9]|2[0-8])";

  // ExpReg - Mes del año - [1..12] / [01..12]
  public static final String ER_MES = "(0?[1-9]|1[0-2])";

  // ExpReg - Año - [0..9999]
  public static final String ER_ANY
          = "([0-9]|[1-9][0-9]|[1-9][0-9]{2}|[1-9][0-9]{3})";

  // ExpReg - Separador de campos de fecha: "/" o "-"
  public static final String ER_SEP_FECHA = "[/-]";

  // ExpReg - Fecha válida entre el 1 y el 28 de cualquier mes
  public static final String ER_FECHA_DIA28
          = "(" + ER_DIA28 + ER_SEP_FECHA + ER_MES + ER_SEP_FECHA + ER_ANY + ")";

  // ExpReg - Años SI divisibles por 400 (Hasta 4 digitos)
  public static final String ER_ANYS_MOD400
          = "(" + "0?[48]00|[13579][26]00|[2468][048]00" + ")";

  // ExpReg - Años NO divisibles por 100 pero SI divisibles por 4 (Hasta 4 dígitos)
  public static final String ER_ANYS_MOD4_NO100
          = "(" + "[0-9]{0,2}" + "((0?|[2468])[48]|[13579][26]|[2468]0)" + ")";
  // Desde 4 hasta 96

  // ExpReg - Años Bisiestos (Hasta 4 digitos)
  public static final String ER_ANYS_BISIESTOS
          = "(" + ER_ANYS_MOD400 + "|" + ER_ANYS_MOD4_NO100 + ")";

  // ExpReg - Fecha válida para 29 de Febreros BISIESTOS
  public static final String ER_FECHA_DIA29_BISIESTO
          = "(" + "29" + ER_SEP_FECHA + "(2|02)"
          + ER_SEP_FECHA + ER_ANYS_BISIESTOS + ")";

  // ExpReg - Meses que tienen 30 dias (Todos menos Febrero)
  public static final String ER_MESES_30DIAS = "(0?[13456789]|1[012])";

  // ExpReg - Fecha válida para el 29 de cualquier Mes EXCEPTO Febrero
  public static final String ER_FECHA_DIA29_NORMAL
          = "(" + "29" + ER_SEP_FECHA + ER_MESES_30DIAS
          + ER_SEP_FECHA + ER_ANY + ")";

  // ExpReg - Fecha válida para el 29 de cualquier Mes INCLUIDO Febrero
  public static final String ER_FECHA_DIA29
          = "(" + ER_FECHA_DIA29_BISIESTO + "|" + ER_FECHA_DIA29_NORMAL + ")";

  // ExpReg - Fecha válida para el 30 de cualquier Mes
  public static final String ER_FECHA_DIA30
          = "(" + "30" + ER_SEP_FECHA + ER_MESES_30DIAS
          + ER_SEP_FECHA + ER_ANY + ")";

  // ExpReg - Meses que tienen 31 dias
  public static final String ER_MESES_31DIAS = "(0?[13578]|1[02])";

  // ExpReg - Fecha válida para el 31 de cualquier Mes 
  public static final String ER_FECHA_DIA31
          = "(" + "31" + ER_SEP_FECHA + ER_MESES_31DIAS
          + ER_SEP_FECHA + ER_ANY + ")";

  // ExpReg - Fecha válida (Cualquiera)
  public static final String ER_FECHA
          = "(" + ER_FECHA_DIA28 + "|" + ER_FECHA_DIA29
          + "|" + ER_FECHA_DIA30 + "|" + ER_FECHA_DIA31 + ")";
  public static final String REG_FECHA
          = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])/([0]?[1-9]|"
          + "[1][0-2])/([0-9]{4}|[0-9]{2})$";

  public static final int EDAD_MIN = 18;

//creamos un método similar al anterior con la entrada de un array.
  public static boolean validarFecha(int[] fecha) {
    boolean fechaOK = false;
    if (fecha[1] == 2) {
      if (validarBisiesto(fecha[2]) && fecha[0] == 29) {
        fechaOK = true;
      } else if (fecha[0] >= 1 && fecha[0] <= 28) {
        fechaOK = true;
      }
    } else if (fecha[1] == 4 || fecha[1] == 6 || fecha[1] == 9
            || fecha[1] == 11) {
      if (fecha[0] >= 1 && fecha[0] <= 30) {
        fechaOK = true;
      }
    } else if (fecha[1] == 1 || fecha[1] == 3 || fecha[1] == 5
            || fecha[1] == 7 || fecha[1] == 8 || fecha[1] == 10
            || fecha[1] == 12) {
      if (fecha[0] >= 1 && fecha[0] <= 31) {
        fechaOK = true;
      }
    }
    return fechaOK;
  }

  public static final int[] splitFecha(String fecha) {
    int[] decom = new int[3];

    String delim = "/";
    String[] descom = fecha.split(delim);

    for (int i = 0; i < descom.length; i++) {
      decom[i] = Integer.valueOf(descom[i]);
    }

    return decom;
  }

  public static boolean validarBisiesto(int anytest) {
    return anytest % 400 == 0 || anytest % 100 != 0 && anytest % 4 == 0;
  }

  public static final boolean validarRegistroEdad(String pideFecha)
          throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date instant = Calendar.getInstance().getTime();  //Coge referencia del momnt
    //semáforo de la fecha
    boolean fechaOk;
    fechaOk = false;

    if (UtilesValidacion.validaFecha(pideFecha)) {
      if (validarFecha(splitFecha(pideFecha))) {
        if (instant.after(sdf.parse(pideFecha))) {  //si la fecha es anterior 
          fechaOk = true;
        } else if (instant.before(sdf.parse(pideFecha))) { //si es fecha futura
          System.out.println("ERROR: FECHA INTRODUCIDA FUTURA");
        }
      }
    }
    return fechaOk;
  }

  public static final boolean esMayorde(Date d) {
    boolean isOk = false;

    Calendar c = Calendar.getInstance();
    c.setTime(d);

    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH) + 1;
    int date = c.get(Calendar.DATE);

    LocalDate da = LocalDate.of(year, month, date);
    LocalDate now = LocalDate.now();

    Period diff = Period.between(da, now);

    if (diff.getYears() >= EDAD_MIN) {
      isOk = true;
    }
    return isOk;
  }

  public static final Date fechaMin() throws ParseException {
    Date d = SDF.parse(DEF_FECHA_MIN);
    return d;
  }

  public static final Date fechaMax() throws ParseException {
    Date d = SDF.parse(DEF_FECHA_MAX);
    return d;
  }

}
