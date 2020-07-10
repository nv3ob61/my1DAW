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
package org.japo.java.events;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.japo.java.forms.GUI;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class CEM implements ChangeListener {

    // Referencia al GUI
    private final GUI gui;

    // Constructor
    public CEM(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
