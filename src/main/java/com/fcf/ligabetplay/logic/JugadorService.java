package com.fcf.ligabetplay.logic;
import java.util.List;
import java.util.Scanner;
import com.fcf.ligabetplay.models.Equipo;
import com.fcf.ligabetplay.models.Jugador;

public class JugadorService {

      public static void registrarJugadores(Scanner sc) {

        EquipoService.listarEquipos(); //lista los equipos registrados 

        System.out.print("Seleccione el equipo al que desea agregar un jugador: ");
        int equipoIndex = sc.nextInt();
        
        Equipo equipo = EquipoService.equipos.get(equipoIndex - 1);

        String control = "y";

        while (control.equalsIgnoreCase("y")) {
            Jugador jugador = new Jugador();
            System.out.print("Ingrese el nombre del jugador: ");
            jugador.setNombre(sc.next());

            System.out.print("Ingrese el apellido del jugador: ");
            jugador.setApellidos(sc.next());

            System.out.print("Ingrese la edad del jugador: ");
            jugador.setEdad(sc.nextInt());

            System.out.print("Ingrese la nacionalidad del jugador: ");
            jugador.setNacionalidad(sc.next());

            System.out.print("Ingrese el dorsal del jugador: ");
            jugador.setDorsal(sc.nextInt());

            System.out.print("Ingrese la posición de juego del jugador: ");
            jugador.setPosicionJuego(sc.next());

            equipo.addJugador(jugador);
            System.out.println("Jugador registrado en el equipo " + equipo.getNombre() + ".");

            System.out.print("Desea registrar otro jugador en este equipo? (y/n): ");
            control = sc.next();
        }

       // listarJugadores(equipo);
    }



    // muestra los jugadores
    public static void listarJugadores(Equipo equipo) {
        System.out.println("Jugadores del equipo " + equipo.getNombre() + ":");

        List<Jugador> jugadores = equipo.getJugadores();

        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            System.out.println((i + 1) + ". " + jugador.getNombre() + " " + jugador.getApellidos());
        }
    }


    
    public static void mostrarTablaJugadores(Scanner sc) {
        EquipoService.listarEquipos();
        System.out.print("Seleccione el número del equipo para ver la tabla de jugadores: ");
        int equipoIndex = sc.nextInt();
        sc.nextLine(); 

        if (equipoIndex < 1 || equipoIndex > EquipoService.equipos.size()) {
            System.out.println("Selección inválida. Intente nuevamente.");
            return;
        }

        Equipo equipo = EquipoService.equipos.get(equipoIndex - 1);
        mostrarTablaJugadores(equipo);
    }

    //Muestra la tabla completa de los jugadores
    
    public static void mostrarTablaJugadores(Equipo equipo) {
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
