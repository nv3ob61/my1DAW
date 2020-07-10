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
package org.japo.java.entities;

import org.japo.java.entities.abs.Vehiculo;
import org.japo.java.entities.parts.Neumatico;
import org.japo.java.interfaces.Avisador;
import org.japo.java.interfaces.Girable;
import org.japo.java.interfaces.Ilumina;
import org.japo.java.interfaces.MotrizNatural;
import org.japo.java.interfaces.Tripulable;
import org.japo.java.utils.UtilesPrints;

/**
 *
 * @author Jonsui
 */
public class Bici extends Vehiculo implements Avisador, Girable,
        MotrizNatural, Tripulable, Ilumina {

  private static final long serialVersionUID = -242085466428103200L;

  private String tipoBici;
  private final Neumatico[] neumaticos;

  public Bici() {
    super();
    neumaticos = new Neumatico[UtilesPrints.DEF_RUEDASBICI];
    tipoBici = UtilesPrints.DEF_TIPOBICI;
    ruedas = UtilesPrints.DEF_RUEDASBICI;
    marca = UtilesPrints.DEF_MARCABICI;
    modelo = UtilesPrints.DEF_MODELOBICI;
    numPlazas = UtilesPrints.DEF_PLAZASBICI;
  }

  public Neumatico[] getNeumaticos() {
    return neumaticos;
  }

  public String getTipoBici() {
    return tipoBici;
  }

  public void setTipoBici(String tipoBici) {
    if (tipoBici.equals(UtilesPrints.DEF_TIPOBICI)
            || tipoBici.equals(UtilesPrints.DEF_TIPOBICI2)) {
      this.tipoBici = tipoBici;
    }
  }

  @Override
  public int getRuedas() {
    return ruedas;
  }

  @Override
  public void desmontar() {
    System.out.println(UtilesPrints.DEF_DESMONTAR);
  }

  @Override
  public void montar() {
    System.out.println(UtilesPrints.DEF_MONTAR);
  }

  @Override
  public void conducir() {
    System.out.println(UtilesPrints.DEF_CONDUCIR);
  }

  @Override
  public void avisar() {
    System.out.println(UtilesPrints.DEF_AVISAR);
  }

  @Override
  public void girarIzquierda() {
    System.out.println(UtilesPrints.DEF_IZQUIERDA);
  }

  @Override
  public void girarDerecha() {
    System.out.println(UtilesPrints.DEF_DERECHA);
  }

  //m'etodo descansar que viene de MotrizNatural
  @Override
  public void descansar() {
    System.out.println(UtilesPrints.DEF_DESCANSAR);
  }
//m'etodo descansar que viene de MotrizElectico

  @Override
  public void acelerar() {
    System.out.println(UtilesPrints.DEF_ACELERAR);
  }

  @Override
  public void frenar() {
    System.out.println(UtilesPrints.DEF_FRENAR);
  }

  @Override
  public boolean enciendeLucesPosicion() {
    if (luces == false) {
      luces = true;
      System.out.println(UtilesPrints.DEF_ENCIENDELUCESPOS);
    }
    return luces;
  }

}
