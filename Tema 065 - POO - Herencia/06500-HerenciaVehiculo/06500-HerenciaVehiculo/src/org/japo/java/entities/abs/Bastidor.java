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
package org.japo.java.entities.abs;

import java.io.Serializable;
import org.japo.java.interfaces.Habitable;
import org.japo.java.interfaces.Tripulable;
import org.japo.java.utils.UtilesPrints;

/**
 *
 * @author Jonsui
 */
public abstract class Bastidor implements Habitable, Tripulable, Serializable {

  private static final long serialVersionUID = -5324769338194907721L;

  private final String numBastidor;

  public Bastidor() {
    numBastidor = generaBastidor();
  }

  public String getNumBastidor() {
    return numBastidor;
  }

  final String generaBastidor() {
    StringBuilder sb = new StringBuilder(UtilesPrints.BASTIDOR_LEN);
    //Le restamos menos tres por la long del prefijo 
    for (int i = 0; i < UtilesPrints.BASTIDOR_LEN - UtilesPrints.BAS_PREF; i++) {
      int index = (int) (UtilesPrints.LISTA_STRING.length() * Math.random());
      sb.append(UtilesPrints.LISTA_STRING.charAt(index));
    }
    return "BASTIDOR|" + sb.toString();
  }
}
