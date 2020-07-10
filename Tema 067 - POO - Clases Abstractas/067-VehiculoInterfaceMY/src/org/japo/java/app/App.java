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
import org.japo.java.entities.parts.MotorCombustion;

/**
 *
 * @author jonsui10
 */
public final class App {

    public final void launchApp() {
      
        int km = 40000;
        Camion c3 = new Camion();
        Moto m1 = new Moto();
        MotorCombustion motor1 = new MotorCombustion(5000, 400);

        
        c3.mostrarInfo();
        System.out.println();
        System.out.println();
        m1.mostrarInfo();

        motor1.muestraInfoMotor();
        
        System.out.println(m1.obtenerNumeroRevisiones(km));
        System.out.println(c3.obtenerNumeroRevisiones(km));
        System.out.println();
    }

}
