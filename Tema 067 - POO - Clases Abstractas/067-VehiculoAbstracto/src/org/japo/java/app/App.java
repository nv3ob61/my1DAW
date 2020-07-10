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

import org.japo.java.entities.Camion;
import org.japo.java.entities.Moto;

/**
 *
 * @author jonsui10
 */
public final class App {

    public final void launchApp() {
        //Camiones
        System.out.println("Camion 1");
        System.out.println("--------");
        Camion c2 = new Camion();

        c2.mostrarInfo(600);
        System.out.println("Actualizar datos");
        c2.setContador(14733);
        c2.mostrarInfo(12000);

        System.out.println("---");

        System.out.println("Camion 2");
        System.out.println("--------");
        Camion c3 = new Camion(4950, 6000);
        c3.mostrarInfo(8000);
        System.out.println("Actualizar datos");
        c3.setContador(8455);
        c3.mostrarInfo(14236);

        Moto m1 = new Moto();
        m1.mostrarInfo(84341);

        Moto m2 = new Moto(4950);
        m2.mostrarInfo(24312);
//        System.out.println(c3.obtenerNumeroRevisiones(40000));

//Comparar camiones
        if (c2.equals(c3)) {
            System.out.println("Camiones SI iguales");
        } else {
            System.out.println("Camiones NO iguales");
        }
        c2 = c3;

        if (c2.equals(c3)) {
            System.out.println("Camiones SI iguales");
        } else {
            System.out.println("Camiones NO iguales");
        }
    }

}
