/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;

/**
 *
 * @author Jonsui
 */
public class MasterChef implements Serializable {
    
    private static final long serialVersionUID = 2L;

    private final int MIN_MIEM = 2;
    private final int MAX_MIEM = 4;
    private final double MAX_PRES = 30.0;
    private int miem;
    private double pres;

    public MasterChef() {
        miem = 3;
        pres = 21.0;
    }

    public int getMiem() {
        return miem;
    }

    public void setMiem(int miem) {
        if (miem >= MIN_MIEM || miem <= MAX_MIEM) {
            this.miem = miem;
        }
    }

    public double getPres() {
        return pres;
    }

    public void setPres(double pres) {
        if (pres > 30.0) {
            this.pres = MAX_PRES;
        } else {
            this.pres = pres;
        }
    }
}
