package com.fcf.ligabetplay.models;

public class CuerpoTecnico extends PlantelDeportivo{
    String rol;
    
    //Crea uno vacio

    public CuerpoTecnico() {
    };

    // Constructor de la clase derivada

    public CuerpoTecnico(int id, String nombre, String apellidos, int edad, String nacionalidad, String rol) {
        super(id, nombre, apellidos, edad, nacionalidad);
        this.rol = rol;
    }

    //Creacion de getter y setter

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
