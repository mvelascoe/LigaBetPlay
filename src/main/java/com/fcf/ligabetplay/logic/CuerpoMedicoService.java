package com.fcf.ligabetplay.logic;

import java.util.Scanner;

import com.fcf.ligabetplay.models.CuerpoMedico;
import com.fcf.ligabetplay.models.Equipo;

public class CuerpoMedicoService {
    public static void registrarCuerpoMedico(Scanner sc) {

        EquipoService.listarEquipos();
        
        System.out.print("Seleccione el equipo al que desea agregar el cuerpo médico: ");
        int equipoIndex = sc.nextInt();

        Equipo equipo = EquipoService.equipos.get(equipoIndex - 1);

        String control = "y";
        while (control.equalsIgnoreCase("y")) {
            CuerpoMedico medico = new CuerpoMedico();
            System.out.print("Ingrese el nombre del miembro del cuerpo médico: ");
            medico.setNombre(sc.next());

            System.out.print("Ingrese el apellido del miembro del cuerpo médico: ");
            medico.setApellidos(sc.next());

            System.out.print("Ingrese la edad del miembro del cuerpo médico: ");
            medico.setEdad(sc.nextInt());

            System.out.print("Ingrese la nacionalidad del miembro del cuerpo médico: ");
            medico.setNacionalidad(sc.next());

            System.out.print("Ingrese la especialidad del miembro del cuerpo médico: ");
            medico.setEspecialidad(sc.next());

            equipo.addCuerpoMedico(medico);
            System.out.println("Miembro del cuerpo médico registrado en el equipo " + equipo.getNombre() + ".");

            System.out.print("Desea registrar otro miembro del cuerpo médico en este equipo? (y/n): ");
            control = sc.next();
        }
    }
}
