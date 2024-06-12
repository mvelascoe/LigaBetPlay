package com.fcf.ligabetplay.logic;

import java.util.ArrayList;
import java.util.Scanner;
import com.fcf.ligabetplay.models.Equipo;

public class EquipoService {
    
    static ArrayList<Equipo> equipos = new ArrayList<>();

    //Registro de Equipos

    public static void registrarEquipo() {
        String control = "y";
        Scanner sc = new Scanner(System.in);

        while (control.equalsIgnoreCase("y")) {
            Equipo equipo = new Equipo();
            System.out.print("Ingrese el nombre del equipo que desea registrar: ");
            equipo.setNombre(sc.next());
            equipos.add(equipo);
            System.out.println("Equipo Registrado Correctamente.");

            System.out.print("Desea registrar otro Equipo? (y/n): ");
            control = sc.next();
        }
    }


    // Muestra los equipos registrados

    public static void listarEquipos() {
        System.out.println("Equipos Registrados:");
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
        } else {
            for (int i = 0; i < equipos.size(); i++) {
                Equipo equipo = equipos.get(i);
                System.out.println((i + 1) + ". " + equipo.getNombre());
            }
        }
    }
}