package com.fcf.ligabetplay.logic;

import java.util.Scanner;

import com.fcf.ligabetplay.models.CuerpoTecnico;
import com.fcf.ligabetplay.models.Equipo;

public class CuerpoTecnicoService {
    public static void registrarCuerpoTecnico(Scanner sc) {
        EquipoService.listarEquipos();
        System.out.print("Seleccione el equipo al que desea agregar el cuerpo técnico: ");
        int equipoIndex = sc.nextInt();
        Equipo equipo = EquipoService.equipos.get(equipoIndex - 1);

        String control = "y";
        while (control.equalsIgnoreCase("y")) {
            CuerpoTecnico tecnico = new CuerpoTecnico();
            System.out.print("Ingrese el nombre del miembro del cuerpo técnico: ");
            tecnico.setNombre(sc.next());

            System.out.print("Ingrese el apellido del miembro del cuerpo técnico: ");
            tecnico.setApellidos(sc.next());

            System.out.print("Ingrese la edad del miembro del cuerpo técnico: ");
            tecnico.setEdad(sc.nextInt());

            System.out.print("Ingrese la nacionalidad del miembro del cuerpo técnico: ");
            tecnico.setNacionalidad(sc.next());

            System.out.print("Ingrese el rol del miembro del cuerpo técnico: ");
            tecnico.setRol(sc.next());

            equipo.addCuerpoTecnico(tecnico);
            System.out.println("Miembro del cuerpo técnico registrado en el equipo " + equipo.getNombre() + ".");

            System.out.print("Desea registrar otro miembro del cuerpo técnico en este equipo? (y/n): ");
            control = sc.next();
        }
    }

    public static void tablaCuerpoTecnico(Equipo equipo) {
        System.out.printf("%-25s %-25s %-5s %-15s %s%n", "NOMBRE", "APELLIDOS", "EDAD", "NACIONALIDAD", "ROL");
        for (CuerpoTecnico tecnico : equipo.getCuerpoTecnico()) {
            System.out.printf("%-25s %-25s %-5d %-15s %s%n",
                    tecnico.getNombre(),
                    tecnico.getApellidos(),
                    tecnico.getEdad(),
                    tecnico.getNacionalidad(),
                    tecnico.getRol());
        }
    }

}
