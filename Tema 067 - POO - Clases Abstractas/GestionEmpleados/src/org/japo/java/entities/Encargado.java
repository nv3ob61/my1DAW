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
package org.japo.java.entities;

import java.util.Random;
import org.japo.java.interfaces.IEmpleado;
import org.japo.java.utils.UtilesEmpleado;

/**
 *
 * @author CicloM
 */
public class Encargado extends Empleado implements IEmpleado {

    private static final long serialVersionUID = 6676644723124827634L;

    public static final int DEF_OBJETIVO = 100;
    public static final int STOCK_PRV_MAX = 10;

//    public static final int DEF_PRODUCCION;

//    static {
//        final int CONTADOR_MIN = 0;
//        final int CONTADOR_MAX = 10;
//
//        final Random RND = new Random();
//
//        DEF_PRODUCCION = RND.nextInt(CONTADOR_MAX - CONTADOR_MIN + 1)
//                + CONTADOR_MIN;
//    }
//    private int objetivo;
    private int produccion;

    public Encargado() {
        super(Empleado.CARGO_ENC);
//        objetivo = DEF_OBJETIVO;
//        produccion = DEF_PRODUCCION;
        this.produccion = new Random().nextInt(STOCK_PRV_MAX);
    }

    public Encargado(int produccion) {
        super(Empleado.CARGO_ENC);
        //Validar Prodiccion
        
        if (UtilesEmpleado.validarProduccion(produccion)) {
            this.produccion = produccion;
        } else {
            this.produccion = new Random().nextInt(STOCK_PRV_MAX);
        }
        this.produccion = produccion;
    }


    public int getProduccion() {
        return produccion;
    }


    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    
    //Ponemos este setCargo vacio para evitar que se pueda cambiar el cargo
    @Override
    public void setCargo(String cargo) {
    }
    

    @Override
    public boolean equals(Object o) {
        boolean testOK;
        if (o == null) {
            testOK = false;
        } else if (!(o instanceof Encargado)) {
            testOK = false;
        } else {
            testOK = cargo.equals(((Encargado) o).getCargo())
                    && produccion == ((Encargado) o).getProduccion();
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.produccion;
        return hash;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); //To change body of generated methods, choose Tools | Templates.
        
        System.out.printf("Producci'on ..: %d%d - %s%n", this.getProduccion(), DEF_OBJETIVO,
                getProduccion() < DEF_OBJETIVO);
        
        
        
        
    }
    
    
}
