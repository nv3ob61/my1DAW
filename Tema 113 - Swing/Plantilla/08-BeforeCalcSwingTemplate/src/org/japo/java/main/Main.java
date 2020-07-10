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
package org.japo.java.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.japo.java.forms.GUI;
import org.japo.java.libraries.UtilesApp;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class Main {

    // Clave de Acceso
    private static final String ACCESS_UID = "mon_mode29081985";

    // Colección de Ventanas
    public static final List<JFrame> VIEW_LIST = new ArrayList<>();

    // Entidades Intercambio Datos
    public static final List<Object> DATA_LIST = new ArrayList<>();

    // Constructor Oculto
    private Main() {

    }

    // Entrada a la aplicación
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals(ACCESS_UID)) {
            // Lanzar GUI
            SwingUtilities.invokeLater(() -> {
                // Propiedades App
                Properties prp = UtilesApp.importarPropiedadesRecurso();

                // Instanciar Vistas
                GUI gui = new GUI(prp);

                // Incorporar Vistas
                VIEW_LIST.add(gui);

                // Mostrar Vista
                gui.setVisible(true);
            });
        } else {
            System.out.println("Acceso Denegado");
            System.out.println("---");
            System.out.println("Contacte con el servicio Técnico");
        }
    }
}
