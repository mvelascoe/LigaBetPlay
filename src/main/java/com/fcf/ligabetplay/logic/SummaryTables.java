package com.fcf.ligabetplay.logic;

import java.util.Scanner;

import com.fcf.ligabetplay.models.CuerpoMedico;
import com.fcf.ligabetplay.models.CuerpoTecnico;
import com.fcf.ligabetplay.models.Equipo;
import com.fcf.ligabetplay.models.Jugador;

public class SummaryTables {

    Scanner sc = new Scanner(System.in);

    public static Equipo mostrarMenuResumen(Scanner sc) {
        EquipoService.listarEquipos(); // Mostrar lista de equipos
        System.out.print("Seleccione el número del equipo del cual desea ver la información: ");
        int equipoIndex = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada
        if (equipoIndex < 1 || equipoIndex > EquipoService.equipos.size()) {
            System.out.println("Número de equipo no válido.");
            return null;
        }
        return EquipoService.equipos.get(equipoIndex - 1);
    }

    public static void tablaInfoJugadores(Equipo equipo) {
        System.out.printf("%-25s %-5s %-15s %5s %-15s%n", "NOMBRE DEL JUGADOR", "EDAD", "NACIONALIDAD", "DORSAL", "POSICION DEL JUEGO");
        for (Jugador jugador : equipo.getJugadores()) {
            System.out.printf("%-25s %-5d %-15s %5d %-15s%n",
                    jugador.getNombre() + " " + jugador.getApellidos(),
                    jugador.getEdad(),
                    jugador.getNacionalidad(),
                    jugador.getDorsal(),
                    jugador.getPosicionJuego());
        }
    }

    public static void tablaJugadores(Equipo equipo) {
        System.out.printf("%-25s %-20s %5s %5s %5s%n", "NOMBRE DEL JUGADOR", "POSICIÓN", "GOLES", "TA", "TR");
        for (Jugador jugador : equipo.getJugadores()) {
            System.out.printf("%-25s %-20s %5d %5d %5d%n",
                    jugador.getNombre() + " " + jugador.getApellidos(),
                    jugador.getPosicionJuego(),
                    jugador.getGolesAnotados(),
                    jugador.getTarjetasAmarillas(),
                    jugador.getTarjetasRojas());
        }
    }

    public static void tablaCuerpoTecnico(Equipo equipo) {
        System.out.printf("%-25s %-20s %5s %15s%n", "NOMBRE", "ROL", "EDAD", "NACIONALIDAD");
        for (CuerpoTecnico tecnico : equipo.getCuerpoTecnico()) {
            System.out.printf("%-25s %-20s %5d %15s%n",
                    tecnico.getNombre() + " " + tecnico.getApellidos(),
                    tecnico.getRol(),
                    tecnico.getEdad(),
                    tecnico.getNacionalidad());
        }
    }

        public static void tablaCuerpoMedico(Equipo equipo) {
        System.out.printf("%-25s %-20s %-20s %-15s%n", "NOMBRE", "APELLIDOS", "EDAD", "NACIONALIDAD", "ESPECIALIDAD");
        for (CuerpoMedico medico : equipo.getCuerpoMedico()) {
            System.out.printf("%-25s %-20s %-20d %-15s %-15s%n",
                    medico.getNombre() + " " + medico.getApellidos(),
                    medico.getEdad(),
                    medico.getNacionalidad(),
                    medico.getEspecialidad());
        }
    }

}        