/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fcf.ligabetplay.model;

public class Equipo {

    String nombre;
    int PJ;
    int PG;
    int PP;
    int PE;
    int GF;
    int GC;
    int TP;

//Crea uno vacio
    public Equipo() {
    }

    
    public Equipo(String nombre, int PJ, int PG, int PP, int PE, int GF, int GC, int TP) {
        this.nombre = nombre;
        this.PJ = PJ;
        this.PG = PG;
        this.PP = PP;
        this.PE = PE;
        this.GF = GF;
        this.GC = GC;
        this.TP = TP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPJ() {
        return PJ;
    }

    public void setPJ(int PJ) {
        this.PJ = PJ;
    }

    public int getPG() {
        return PG;
    }

    public void setPG(int PG) {
        this.PG = PG;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public int getPE() {
        return PE;
    }

    public void setPE(int PE) {
        this.PE = PE;
    }

    public int getGF() {
        return GF;
    }

    public void setGF(int GF) {
        this.GF = GF;
    }

    public int getGC() {
        return GC;
    }

    public void setGC(int GC) {
        this.GC = GC;
    }

    public int getTP() {
        return TP;
    }

    public void setTP(int TP) {
        this.TP = TP;
    }
    
    public void updateStats(int golesFavor, int golesContra) {
        this.PJ++;
        this.GF += golesFavor;
        this.GC += golesContra;

        if (golesFavor > golesContra) {
            this.PG++;
            this.TP += 3;
        } else if (golesFavor < golesContra) {
            this.PP++;
        } else {
            this.PE++;
            this.TP += 1;
        }
    }
}

