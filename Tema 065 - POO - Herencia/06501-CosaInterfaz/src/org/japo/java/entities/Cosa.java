package org.japo.java.entities;

import java.io.Serializable;
import org.japo.java.interfaces.ICosa;

/**
 *
 * @author CicloM
 */
public class Cosa implements ICosa, Serializable {

  private static final long serialVersionUID = -3174178915518356215L;

  public static final boolean DEF_FRAGILIDAD_OK = false;
  
  //Para que el campo se pueda heredar ponemos PROTECTED en vez de PRIVATE
  protected boolean fragilidadOk;

  //Constructores
  public Cosa() {
    fragilidadOk = DEF_FRAGILIDAD_OK;
  }

  public Cosa(boolean fragilidadOk) {
    this.fragilidadOk = fragilidadOk;
  }

  public boolean isFragilidadOk() {
    return fragilidadOk;
  }

  public void setFragilidadOk(boolean fragilidadOk) {
    this.fragilidadOk = fragilidadOk;
  }

  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Cosa)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.isFragilidadOk() == ((Cosa) o).isFragilidadOk();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + (int) (Double.doubleToLongBits(1321) ^ (Double.doubleToLongBits(1351) >>> 32));
    return hash;
  }

  @Override
  public String toString() {
    return String.format("%s: %s es fragil.",
            getClass().getSimpleName(),
            isFragilidadOk() ? "sí" : "no");
  }

  @Override
  public void mostrarInfo() {
    System.out.println(toString());
  }

  @Override
  public void cambiaEstado() {
    if (this.isFragilidadOk() == false) {
      setFragilidadOk(true);
    } else {
      if (this.isFragilidadOk() == true) {
        setFragilidadOk(DEF_FRAGILIDAD_OK);
      }
    }
  }
}
