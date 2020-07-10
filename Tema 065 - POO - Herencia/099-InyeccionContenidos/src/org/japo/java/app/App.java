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

import org.japo.java.entities.Tecnico;
import org.japo.java.entities.TecnicoASIR;
import org.japo.java.entities.TecnicoDAW;
import org.japo.java.interfaces.ITitulacion;

/**
 *
 * @author jonsui10
 */
public final class App {

    public final void launchApp() {
        //Crear técnico     
        Tecnico t = new Tecnico();
        //Crear Alter-Ego
        ITitulacion t01 = new TecnicoDAW();
        ITitulacion t02 = new TecnicoASIR();
        
        //Actividad
        t.ejercerProfesion();
        
        //Separador
        System.out.println("Cambiando...");        
        
        t.setTitulacion(t01);
        
        t.ejercerProfesion();
        
        t.setTitulacion(t02);
        
        t.ejercerProfesion();
        
    }

}
