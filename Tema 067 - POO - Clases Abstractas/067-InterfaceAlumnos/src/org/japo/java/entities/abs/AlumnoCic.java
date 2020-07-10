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
public abstract class AlumnoCic extends Alumno implements Serializable{
  
  private static final long serialVersionUID = -2218691631162034265L;
  
  private char familia;
  
  public AlumnoCic() {
  }

  public AlumnoCic(char familia) {
    this.familia = familia;
  }

  public AlumnoCic(char familia, int exp) {
    super(exp);
    this.familia = familia;
  }

  public char getFamilia() {
    return familia;
  }

  public void setFamilia(char familia) {
    this.familia = familia;
  }
  
}
