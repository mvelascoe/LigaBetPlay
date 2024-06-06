package com.fcf.ligabetplay.model;

public class PlantelDeportivo {
    int id;
    String nombre;  
    String apellidos;
    int edad;
    String nacionalidad;


//Crea uno vacio
public PlantelDeportivo() {
}

// Constructor de la clase base

public PlantelDeportivo(int id, String nombre, String apellidos, int edad, String nacionalidad) {
    this.id = id;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.nacionalidad = nacionalidad;
}

//Creacion de getter y setter

public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
