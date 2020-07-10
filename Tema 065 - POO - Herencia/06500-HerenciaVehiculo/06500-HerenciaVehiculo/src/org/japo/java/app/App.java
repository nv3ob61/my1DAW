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

import org.japo.java.entities.Andamio;
import org.japo.java.entities.Bici;
import org.japo.java.entities.Coche;
import org.japo.java.entities.parts.MotorCombustion;

/**
 *
 * @author jonsui10
 */
public final class App {

  public final void launchApp() {
    //Instancia de objetos varios
    Andamio a1 = new Andamio();
    Coche c1 = new Coche();
    Coche c2 = new Coche();
    MotorCombustion m2 = new MotorCombustion(7000, 200);
    Bici b1 = new Bici();
    Bici b2 = new Bici();


    System.out.printf("ESTADO LUCES COCHE 1: %b%n", c1.isLuces());
    System.out.println("ENCENDER LUCES COCHE 1.");
    c1.enciendeLucesPosicion();
    System.out.printf("ESTADO LUCES COCHE 1: %b%n", c1.isLuces());
    c2.setTipoCoche("Autom'atico");
    c2.setMarchas(6);
    c2.setMotor(m2);
    System.out.println();
    c1.avisar();
    b2.setTipoBici("Electrica");
    System.out.println("Hemos pasado c2 a modo: " +
            c2.getTipoCoche());

    System.out.println();

    System.out.println("Mostrando n'ums de serie de los "
            + "objetos creados>");
    System.out.println(String.format("%-6s: %s", a1.getClass().getSimpleName(),
            a1.getNumBastidor()));
    System.out.println(String.format("%-7s: %s", b1.getClass().getSimpleName(),
            b1.getNumBastidor()));
    System.out.println(String.format("%-7s: %s", b2.getClass().getSimpleName(),
            b2.getNumBastidor()));
    System.out.println(String.format("%-7s: %s", c1.getClass().getSimpleName(),
            c1.getNumBastidor()));
    System.out.println(String.format("%-7s: %s", c2.getClass().getSimpleName(),
            c2.getNumBastidor()));

    System.out.println();

    b1.setMarca("Mandocleta");
    System.out.println(b1.getMarca() + " " + b1.getModelo());
    System.out.println(b2.getMarca() + " " + b2.getModelo());
    b1.desmontar();
    System.out.println(b1.getRuedas() + " " + b2.getRuedas());
    System.out.println();
    System.out.println(c1.getRuedas() + " " + c2.getRuedas());
    
    System.out.println();
    
    MotorCombustion m1 = new MotorCombustion(3500, 330);
    m1.muestraInfoMotor();
    c1.setMotor(m1);
    
    c1.mostrarInfoCoche();
    m2.muestraInfoMotor();
    
    c1.arrancar();
    
    //Creamos otra bici para comprobar ruedas y plazas
    Bici bici = new Bici();
    
    System.out.println(bici.getRuedas());
    System.out.println(bici.getNumPlazas());

  }

}
