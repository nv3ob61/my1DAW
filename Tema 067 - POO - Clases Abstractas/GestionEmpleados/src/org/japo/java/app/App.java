/* 
 * Copyright (C) 2020 CicloM
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

import org.japo.java.entities.Empleado;
import org.japo.java.entities.Encargado;
import org.japo.java.entities.Operario;

/**
 *
 * @author mon_mo
 */
public final class App {

    public final void launchApp() {

        Operario currito = new Operario(Operario.DEF_SECCION);
        Encargado latiguero = new Encargado(-150);

        System.out.println("Operario");
        System.out.println("========");
        currito.mostrarInfo();
        System.out.println("Actualizando ...");
        currito.setSeccion(Operario.DEF_SECCION);

        //Encargado
        System.out.println("Encargado");
        System.out.println("---------");
        latiguero.mostrarInfo();
        System.out.println("Actualizando...");
        latiguero.setProduccion(150);
        latiguero.mostrarInfo();

        //Comparacion
        System.out.println("");
        System.out.println("");
        if (((Empleado) latiguero).equals((Empleado) currito)) {
            System.out.println("Los dos empleados son iguales");
        } else {
            System.out.println("NO son iguales");
        }

    }
}
