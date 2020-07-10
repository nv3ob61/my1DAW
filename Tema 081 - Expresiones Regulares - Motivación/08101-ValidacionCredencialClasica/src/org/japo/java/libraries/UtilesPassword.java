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

import java.util.Random;

/**
 *
 * @author mon_mode
 */
public final class UtilesPassword {

  // Mensajes - user
  public static final String MSG_ERR_LEN_USER = "ERROR: Longitud fuera de rango";
  public static final String MSG_ERR_LWR_USER = "ERROR: Ausencia de minúsculas";
  public static final String MSG_ERR_UPR_USER = "ERROR: Ausencia de mayúsculas";
  public static final String MSG_ERR_DIG_USER = "ERROR: Ausencia de dígitos numéricos";
  public static final String MSG_ERR_EXT_USER = "ERROR: Ausencia de caracteres extendidos";
  public static final String MSG_ERR_USER = "ERROR: Caracteres NO permitidos";
  public static final String MSG_SUC_USER = "Formato de Usuario Correcto";

  // Mensajes - pass
  public static final String MSG_ERR_LEN_PASS = "ERROR: Longitud fuera de rango";
  public static final String MSG_ERR_LWR_PASS = "ERROR: Ausencia de minúsculas";
  public static final String MSG_ERR_UPR_PASS = "ERROR: Ausencia de mayúsculas";
  public static final String MSG_ERR_DIG_PASS = "ERROR: Ausencia de dígitos numéricos";
  public static final String MSG_ERR_EXT_PASS = "ERROR: Ausencia de caracteres extendidos";
  public static final String MSG_ERR_PASS = "ERROR: Caracteres NO permitidos";
  public static final String MSG_SUC_PASS = "Formato de Contraseña Correcto";

  // Longitudes - user
  public static final int LEN_MIN_USER = 4;
  public static final int LEN_MAX_USER = 12;

  // Longitudes - pass
  public static final int LEN_MIN_PASS = 8;
  public static final int LEN_MAX_PASS = 16;

  // Conjuntos - user
  public static final String SET_LWR_USER = "abcdeéfghiíjklmnñoópqrstuúüvwxyz";
  public static final String SET_UPR_USER = "ABCDEÉFGHIÍJKLMNÑOÓPQRSTUÚÜVWXYZ";
  public static final String SET_DIG_USER = "0123456789";
  public static final String SET_EXT_USER = "_@#$~%&";

  // Conjuntos - pass
  public static final String SET_LWR_PASS = "abcdefghijklmnopqrstuvwxyz";
  public static final String SET_UPR_PASS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String SET_DIG_PASS = "0123456789";
  public static final String SET_EXT_PASS = "_@#$~%&";

  // Número de Categorias
  public static final int NUM_CAT = 4;

  // Categorias de caracteres
  public static final int CAT_LWR = 0;
  public static final int CAT_UPR = 1;
  public static final int CAT_DIG = 2;
  public static final int CAT_EXT = 3;

  // Símbolos categoria - Arrays
  public static final char[] LST_PASS_LWR = SET_LWR_PASS.toCharArray();
  public static final char[] LST_PASS_UPR = SET_UPR_PASS.toCharArray();
  public static final char[] LST_PASS_DIG = SET_DIG_PASS.toCharArray();
  public static final char[] LST_PASS_PUN = SET_EXT_PASS.toCharArray();

  // Sistema aleatorio
  public static final Random RND = new Random();

  public static final boolean validarPassword(String pass) {
    return validarStrMin(pass)
            && validarStrMay(pass)
            && validarStrDig(pass)
            && validarStrPun(pass)
            && validarStrLonPass(pass)
            && validarStrCar(pass);
  }

  public static final boolean validarMin(char c) {
    return SET_LWR_USER.contains(c + "");
  }

  public static final boolean validarMay(char c) {
    return SET_UPR_USER.contains(c + "");
  }

  public static final boolean validarDig(char c) {
    return SET_DIG_USER.contains(c + "");
  }

  public static final boolean validarPun(char c) {
    return SET_EXT_USER.contains(c + "");
  }

  public static final boolean validarStrMin(String str) {
    boolean testOK = false;

    for (int i = 0; i < str.length(); i++) {

      testOK = validarMin(str.charAt(i));

      if (testOK) {
        i = str.length();
      }
    }
    return testOK;
  }

  public static final boolean validarStrMay(String str) {
    boolean testOK = false;

    for (int i = 0; i < str.length(); i++) {

      testOK = validarMay(str.charAt(i));

      if (testOK) {
        i = str.length();
      }
    }
    return testOK;
  }

  public static final boolean validarStrDig(String str) {
    boolean testOK = false;

    for (int i = 0; i < str.length(); i++) {

      testOK = validarDig(str.charAt(i));

      if (testOK) {
        i = str.length();
      }
    }
    return testOK;
  }

  public static final boolean validarStrPun(String str) {
    boolean testOK = false;

    for (int i = 0; i < str.length(); i++) {
      testOK = validarPun(str.charAt(i));

      if (testOK) {
        i = str.length();
      }
    }
    return testOK;
  }

  public static final boolean validarStrLonUser(String str) {
    return str.length() >= LEN_MIN_USER && str.length() <= LEN_MAX_USER;
  }

  public static final boolean validarStrLonPass(String str) {
    return str.length() >= LEN_MIN_PASS && str.length() <= LEN_MAX_PASS;
  }

  public static final boolean validarStrCar(String pass) {
    boolean testOk = true;

    for (int i = 0; i < pass.length(); i++) {
      if (Character.isLetterOrDigit(pass.charAt(i))) {
        testOk = testOk && true;
      } else if (SET_EXT_USER.indexOf(pass.charAt(i)) >= 0) {
        testOk = testOk && true;
      } else {
        testOk = false;
      }
    }
    return testOk;
  }

  public static final boolean validarContenido(String dato, String listaMin,
          String listaMay, String listaDig, String listaExt) {
    boolean testOk = true;
    for (int i = 0; i < dato.length(); i++) {
      if (!listaMin.contains(dato.charAt(i) + "")
              && !listaMay.contains(dato.charAt(i) + "")
              && !listaDig.contains(dato.charAt(i) + "")
              && !listaExt.contains(dato.charAt(i) + "")) {
        testOk = false;
        i = dato.length();
      }
    }
    return testOk;
  }

  public static final boolean validarLongitud(int longitud, int min, int max) {
    return longitud >= min && longitud <= max;
  }
}
