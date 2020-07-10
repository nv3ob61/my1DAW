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

import org.japo.java.entities.Articulo;

/**
 *
 * @author jonsui10
 */
public final class App {

  public static final String PACO = "---";

  public final void launchApp() {

    Articulo art1 = new Articulo();
    Articulo art2 = new Articulo(2.11);
    Articulo art3 = new Articulo(2.121);
    Articulo art4 = new Articulo(2.134626);
    Articulo art5 = new Articulo(2.14);
    Articulo art6 = new Articulo();
    //mostrar precio  
    art1.mostrarPrecio();
    art2.mostrarPrecio();
    art3.mostrarPrecio();
    art4.mostrarPrecio();
    art5.mostrarPrecio();
    art6.mostrarPrecio();
    //separador
    System.out.println();
    System.out.println("Mostrados precios iniciales.");
    System.out.println(PACO);
    System.out.println();
    //Cambio precio artículos
    art1.setPrecio(40.976);
    art2.setPrecio(2.3);
    art3.setPrecio(40.978);
    art4.setPrecio(13.12345);
    art6.setPrecio(2.14);
    //mostrar precio  
    art1.mostrarPrecio();
    art2.mostrarPrecio();
    art3.mostrarPrecio();
    art4.mostrarPrecio();
    art5.mostrarPrecio();
    art6.mostrarPrecio();
        //separador
    System.out.println();
    System.out.println("Muestra arriba el cambio de precio.");
    System.out.println(PACO);
    System.out.println();
    //
    System.out.println("Comparamos precio art 1 y art 3 : "
            + art1.equals(art3));
        System.out.println("Comparamos precio art 2 y art 4 : "
            + art2.equals(art4));
        System.out.println("Comparamos precio art 5 y art 6 : "
            + art5.equals(art6));

  }

}
