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
public abstract class AlumnoPri extends Alumno implements Serializable {

  private static final long serialVersionUID = -4594696998113476669L;

  private String tutor;

  public AlumnoPri() {
  }

  public AlumnoPri(String tutor) {
    this.tutor = tutor;
  }

  public AlumnoPri(String tutor, int exp) {
    super(exp);
    this.tutor = tutor;
  }

  public String getTutor() {
    return tutor;
  }

  public void setTutor(String tutor) {
    this.tutor = tutor;
  }
}
