package com.fcf.ligabetplay.model;

public class CuerpoMedico extends PlantelDeportivo {
    String especialidad;

    // Se crea vacio

    public CuerpoMedico(){    
    };

    // Constructor de la clase derivada

    public CuerpoMedico(int id, String nombre, String apellidos, int edad, String nacionalidad, String especialidad) {
        super(id, nombre, apellidos, edad, nacionalidad);
        this.especialidad = especialidad;
    }

    //Creacion de getters y setters

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
