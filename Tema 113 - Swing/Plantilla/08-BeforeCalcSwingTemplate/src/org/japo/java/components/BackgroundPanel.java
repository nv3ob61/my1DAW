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
package org.japo.java.components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public final class BackgroundPanel extends JPanel {

    // Referencia a la imagen de fondo
    private Image img;

    public BackgroundPanel(Image img) {
        if (img != null) {
            this.img = img;
        }
    }

    @Override
    public void paint(Graphics g) {
        // Dibuja la imagen en el área de la etiqueta
        g.drawImage(
                img,            // Objeto Image - Imagen de fondo para el panel
                0, 0,           // X e Y donde se va a insertar la imagen
                getWidth(),     // Ancho de la imagen - Ancho del panel
                getHeight(),    // Alto de la imagen - Alto del panel
                this);          // Dónde se dibujará la imagen - Panel

        // Panel opaco - Muestra imagen
        setOpaque(false);

        // Pinta la imagen
        super.paint(g);
    }
}
