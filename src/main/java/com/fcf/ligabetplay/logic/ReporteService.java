package com.fcf.ligabetplay.logic;

import java.util.Scanner;

import com.fcf.ligabetplay.models.Equipo;
import com.fcf.ligabetplay.models.Jugador;

public class ReporteService {

     public static void reporteEquipoMasGoles() {
        if (EquipoService.equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        Equipo masGoles = null;

        for (Equipo equipo : EquipoService.equipos) {
            if (masGoles == null || equipo.getGF() > masGoles.getGF()) {
                masGoles = equipo;
            }
        }

        System.out.println("Equipo que mas goles anoto: "
                + (masGoles != null ? masGoles.getNombre() + " con " + masGoles.getGF() + " goles" : "N/A"));
    }

    public static void reporteEquipoMasPuntos() {
        if (EquipoService.equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        Equipo masPuntos = null;

        for (Equipo equipo : EquipoService.equipos) {
            if (masPuntos == null || equipo.getTP() > masPuntos.getTP()) {
                masPuntos = equipo;
            }
        }

        System.out.println("Equipo que mas puntos tiene: "
                + (masPuntos != null ? masPuntos.getNombre() + " con " + masPuntos.getTP() + " puntos" : "N/A"));
    }

    public static void reporteEquipoMasGanados() {
        if (EquipoService.equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        Equipo masGanados = null;

        for (Equipo equipo : EquipoService.equipos) {
            if (masGanados == null || equipo.getPG() > masGanados.getPG()) {
                masGanados = equipo;
            }
        }

        System.out.println("Equipo que mas partidos gano: "
                + (masGanados != null ? masGanados.getNombre() + " con " + masGanados.getPG() + " partidos ganados"
                        : "N/A"));
    }

    public static void reporteTotalGoles() {
        if (EquipoService.equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        int totalGoles = 0;

        for (Equipo equipo : EquipoService.equipos) {
            totalGoles += equipo.getGF();
        }

        System.out.println("Total de goles anotados por todos los equipos: " + totalGoles);
    }

    public static void reportePromedioGoles() {
        if (EquipoService.equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        int totalGoles = 0;
        int totalPartidos = 0;

        for (Equipo equipo : EquipoService.equipos) {
            totalGoles += equipo.getGF();
            totalPartidos += equipo.getPJ();
        }

        double promedioGoles = (totalPartidos > 0) ? (double) totalGoles / totalPartidos : 0;
        System.out.println("Promedio de goles anotados en el torneo: " + promedioGoles);
    }


    public static void mostrarTablaPosiciones() {
        System.out.printf("%-25s %5s %5s %5s %5s %5s %5s %5s%n", "NOMBRE DEL EQUIPO", "PJ", "PG", "PP", "PE", "GF",
                "GC", "TP");
        for (Equipo equipo : EquipoService.equipos) {
            System.out.printf("%-25s %5d %5d %5d %5d %5d %5d %5d%n", equipo.getNombre(), equipo.getPJ(), equipo.getPG(),
                    equipo.getPP(), equipo.getPE(), equipo.getGF(), equipo.getGC(), equipo.getTP());
        }
    }


    public static void mostrarTablaJugadores(Scanner sc) {
     //   listarEquipos();
        System.out.print("Seleccione el número del equipo para ver la tabla de jugadores: ");
        int equipoIndex = sc.nextInt();
        sc.nextLine(); 

        if (equipoIndex < 1 || equipoIndex > EquipoService.equipos.size()) {
            System.out.println("Selección inválida. Intente nuevamente.");
            return;
        }

        Equipo equipo = EquipoService.equipos.get(equipoIndex - 1);
        tablaJugadores(equipo);
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
}
