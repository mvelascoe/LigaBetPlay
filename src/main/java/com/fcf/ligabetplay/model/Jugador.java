package com.fcf.ligabetplay.model;

public class Jugador extends PlantelDeportivo{
    int dorsal;
    String posicionJuego;
    String fechaIngreso;
    int golesAnotados;
    int tarjetasRojas;
    int tarjetasAmarillas;

    //Crea uno vacio

    public Jugador() {
    };

    // Constructor de la clase derivada

    public Jugador(int id, String nombre, String apellidos, int edad, String nacionalidad, int dorsal,
            String posicionJuego, String fechaIngreso, int golesAnotados, int tarjetasRojas, int tarjetasAmarillas) {
        super(id, nombre, apellidos, edad, nacionalidad);
        this.dorsal = dorsal;
        this.posicionJuego = posicionJuego;
        this.fechaIngreso = fechaIngreso;
        this.golesAnotados = 0;
        this.tarjetasRojas = 0;
        this.tarjetasAmarillas = 0;
    }

    //Creacion de getter y setter

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicionJuego() {
        return posicionJuego;
    }

    public void setPosicionJuego(String posicionJuego) {
        this.posicionJuego = posicionJuego;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public void incrementarTarjetasAmarillas() {
        ++this.tarjetasAmarillas;
     }
  
     public void incrementarTarjetasRojas() {
        ++this.tarjetasRojas;
     }

     public void anotarGol() {
        ++this.golesAnotados;
    }

}
