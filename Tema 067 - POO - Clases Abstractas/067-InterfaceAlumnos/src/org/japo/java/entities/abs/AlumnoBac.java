/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities.abs;

import java.io.Serializable;

/**
 *
 * @author Jonsui
 */
public abstract class AlumnoBac extends Alumno implements Serializable {

  private static final long serialVersionUID = 7108345177366254078L;

  private char modalidades;

  public AlumnoBac() {
  }

  public AlumnoBac(char modalidades) {
    this.modalidades = modalidades;
  }

  public AlumnoBac(char modalidades, int exp) {
    super(exp);
    this.modalidades = modalidades;
  }

  public char getModalidades() {
    return modalidades;
  }

  public void setModalidades(char modalidades) {
    this.modalidades = modalidades;
  }

}
