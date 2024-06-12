package com.fcf.ligabetplay.logic;

import java.util.ArrayList;
import java.util.Scanner;

import com.fcf.ligabetplay.models.Equipo;
import com.fcf.ligabetplay.models.Fecha;
import com.fcf.ligabetplay.models.Jugador;

public class PartidoService {
    
    static ArrayList<Fecha> fechas = new ArrayList<>();

    // Registro de Fechas

    public static void registrarFechas(Scanner sc) {
        System.out.print("Ingrese la fecha o Jornada de los partidos: ");
        String fecha = sc.nextLine();
        String continuar;

        do {
            registrarPartido(sc, fecha);
            System.out.print("Desea registrar otro partido en esta fecha? (y/n): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("y"));

        System.out.println("Registro de partidos para la fecha " + fecha + " finalizado.");
    }

    // Registro de partido

    public static void registrarPartido(Scanner sc, String fecha) {

        EquipoService.listarEquipos(); // Lista los Equipos registrados

        System.out.print("Seleccione el numero del equipo local: ");
        int localIndex = sc.nextInt();
        sc.nextLine();
        Equipo local = EquipoService.equipos.get(localIndex - 1);

        System.out.print("Seleccione el numero del equipo visitante: ");
        int visitanteIndex = sc.nextInt();
        sc.nextLine();
        Equipo visitante = EquipoService.equipos.get(visitanteIndex - 1);

        int golesLocal = resultadosEquipo(sc, local, "local");
        int golesVisitante = resultadosEquipo(sc, visitante, "visitante");

        local.updateStats(golesLocal, golesVisitante);
        visitante.updateStats(golesVisitante, golesLocal);

        Fecha nuevaFecha = new Fecha(fecha, local, visitante, golesLocal, golesVisitante);
        fechas.add(nuevaFecha);

        System.out.println("Partido registrado correctamente.");
    }


    //Resultados del partido

    private static int resultadosEquipo(Scanner sc, Equipo equipo, String tipo) {
        System.out.print("Ingrese el número de goles marcados por el equipo " + tipo + ": ");
        int goles = sc.nextInt();
        sc.nextLine();
        registrarGoles(sc, equipo, goles); // Registra los goles marcados por el equipo
        System.out.println("El equipo " + tipo + " tuvo alguna tarjeta o penalización (y/n)?");
        String tarjetas = sc.nextLine();
        if (tarjetas.equalsIgnoreCase("y")) {
            asignarTarjetas(sc, equipo); // Asigna tarjetas al equipo
        }
        return goles;
    }


    // Registro de Goles por jugador

    private static void registrarGoles(Scanner sc, Equipo equipo, int goles) {
        for (int i = 0; i < goles; i++) {

            JugadorService.listarJugadores(equipo); // Lista los jugadores registrados

            System.out.print("Seleccione el número del jugador que anotó el gol " + (i + 1) + ": ");
            int jugadorIndex = sc.nextInt();
            sc.nextLine();
            Jugador jugador = equipo.getJugadores().get(jugadorIndex - 1);
            jugador.anotarGol();
        }
    }


    // Asignacion de tarjetas

    public static void asignarTarjetas(Scanner sc, Equipo equipo) {

        JugadorService.listarJugadores(equipo); // Lista los jugadores registrados

        String control = "y";
        while (control.equalsIgnoreCase("y")) {
            System.out.print("Seleccione el número del jugador al que desea asignar una tarjeta: ");
            int jugadorIndex = sc.nextInt() - 1;
            sc.nextLine();

            if (jugadorIndex >= 0 && jugadorIndex < equipo.getJugadores().size()) {
                Jugador jugador = equipo.getJugadores().get(jugadorIndex);

                System.out.print("Ingrese el color de la tarjeta (A para amarilla, R para roja): ");
                char tarjeta = sc.nextLine().toUpperCase().charAt(0);

                if (tarjeta == 'A') {
                    jugador.incrementarTarjetasAmarillas();
                } else if (tarjeta == 'R') {
                    jugador.incrementarTarjetasRojas();
                } else {
                    System.out.println("Color de tarjeta no válido. Inténtelo de nuevo.");
                    continue;
                }

                System.out.println(
                        "Tarjeta asignada al jugador " + jugador.getNombre() + " " + jugador.getApellidos() + ".");
            } else {
                System.out.println("Número de jugador no válido. Inténtelo de nuevo.");
            }

            System.out.print("¿Desea asignar otra tarjeta a un jugador? (y/n): ");
            control = sc.nextLine();
        }

        System.out.println("Registro de tarjetas completado");
    }

}
