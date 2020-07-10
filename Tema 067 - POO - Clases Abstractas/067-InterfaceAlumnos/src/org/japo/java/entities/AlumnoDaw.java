/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;
import org.japo.java.entities.abs.AlumnoCic;

/**
 *
 * @author Jonsui
 */
public class AlumnoDaw extends AlumnoCic implements Serializable {
  
  private static final long serialVersionUID = -7452330169060748259L;
  
  private char tipo;
  
  public AlumnoDaw(){
  }

  public AlumnoDaw(char tipo) {
    this.tipo = tipo;
  }

  public AlumnoDaw(char tipo, char familia) {
    super(familia);
    this.tipo = tipo;
  }

  public AlumnoDaw(char tipo, char familia, int exp) {
    super(familia, exp);
    this.tipo = tipo;
  }

  public char getTipo() {
    return tipo;
  }

  public void setTipo(char tipo) {
    this.tipo = tipo;
  }
  
}
