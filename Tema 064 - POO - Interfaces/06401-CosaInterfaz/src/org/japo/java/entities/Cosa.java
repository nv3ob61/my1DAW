package org.japo.java.entities;

import java.io.Serializable;
import org.japo.java.interfaces.ICosa;

/**
 *
 * @author CicloM
 */
public class Cosa implements ICosa, Serializable {

    private static final long serialVersionUID = -3174178915518356215L;

    public static final boolean DEF_COMESTIBLE_OK = false;

    private boolean comestibleOk;

    //Constructores
    public Cosa() {
        comestibleOk = DEF_COMESTIBLE_OK;
    }

    public Cosa(boolean comestibleOk) {
        this.comestibleOk = comestibleOk;
    }

    public boolean isComestibleOk() {
        return comestibleOk;
    }

    public void setComestibleOk(boolean comestibleOk) {
        this.comestibleOk = comestibleOk;
    }

    @Override
    public final boolean equals(Object o) {
        boolean testOk;
        if (o == null) {
            testOk = false;
        } else if (!(o instanceof Cosa)) {
            testOk = false;
        } else {
            //Si tuviera más atributos se añadirían líneas de más concatenando
            // con && en cada línea...
            testOk = this.comestibleOk == ((Cosa) o).isComestibleOk();
        }
        return testOk;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(1321) ^ 
                (Double.doubleToLongBits(1351) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s: %s comestible",
                getClass().getSimpleName(),
                comestibleOk ? "si" : "no");
    }

    @Override
    public void mostrarInfo() {
        System.out.println(toString());
    }

    @Override
    public void cambiaEstado() {
        if (this.comestibleOk == false) {
            setComestibleOk(true);
        } else {
            if (this.comestibleOk == true) {
                setComestibleOk(DEF_COMESTIBLE_OK);
            }
        }
    }
}
