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
package org.japo.java.app;

import org.japo.java.entities.Mandocleta;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final String PACO = "---";

  public final void launchApp() {
    //Instanciamos dos mandonguilletas
    Mandocleta m1 = new Mandocleta();
    Mandocleta m2 = new Mandocleta();
    
    //Y les ponemos la velocidad (en Km/h)
    //Está limitado a 5Km/h, si es mayor no sube de ahí.
    m1.setVelocidad(6);
    m2.setVelocidad(2);
    
    System.out.println("Imprime estado inicial de velocidades: ");
    System.out.println(m1.toString());
    System.out.println(m2.toString());
    System.out.println(PACO);
    System.out.println(PACO);
    System.out.println(m1.toMetroSeg(m1.getVelocidad()));
    System.out.println(m2.toMetroSeg(m2.getVelocidad()));
    System.out.println(PACO);
    System.out.println(m1.equals(m2));

  }
}
