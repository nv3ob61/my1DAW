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

import java.util.Locale;
import org.japo.java.interfaces.IElectro;

/**
 *
 * @author CicloM
 */
public abstract class Electro extends Mobiliario implements IElectro {

  private static final long serialVersionUID = -5346160911958759358L;

  @Override
  public void conectar(String aparato) {
    System.out.printf("Conectar %s....", aparato);
  }

  @Override
  public void desconectar(String aparato) {
    System.out.printf("Desconectar %s....", aparato);
  }

  @Override
  public void instalar() {
    System.out.println("Colocar, nivelar y enchufar");
  }
  //Sobrecargas

  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "APARATO: %s",
            getClass().getSimpleName());
  }
  
}
