/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fcf.ligabetplay.model;
import java.util.ArrayList;
import java.util.Scanner;

public class Ligabetplay {
    
    static ArrayList<Equipo> equipos = new ArrayList<>();
    static ArrayList<Fecha> fechas = new ArrayList<>();
    //Scanner sc = new Scanner(System.in);
    
    

    public static void registrarEquipo() {
        String control = "y";
        Scanner sc = new Scanner(System.in);
        
        while (control.equalsIgnoreCase("y")) {
            Equipo equipo = new Equipo();
            System.out.print("Ingrese el nombre del equipo que desea registrar: ");
            equipo.setNombre(sc.next());
            equipos.add(equipo);
            System.out.println("Equipo Registrado.");
            
            System.out.print("Desea registrar otro Equipo? (y/n): ");
            control = sc.next();
            
        }
    }
    
    public static void registrarFechas(Scanner sc) {
    System.out.print("Ingrese la fecha o Jornada de los partidos: ");
    String fecha = sc.nextLine();

    String continuar;
    do {
        registrarFecha(sc, fecha);
        System.out.print("Desea registrar otro partido en esta fecha? (y/n): ");
        continuar = sc.nextLine();
    } while (continuar.equalsIgnoreCase("y"));

    System.out.println("Registro de partidos para la fecha " + fecha + " finalizado.");
}

public static void registrarFecha(Scanner sc, String fecha) {
    listarEquipos();

    System.out.print("Seleccione el numero del equipo local: ");
    int localIndex = sc.nextInt();
    Equipo local = equipos.get(localIndex - 1);

    System.out.print("Seleccione el numero del equipo visitante: ");
    int visitanteIndex = sc.nextInt();
    Equipo visitante = equipos.get(visitanteIndex - 1);

    System.out.print("Ingrese los goles del equipo local: ");
    int golesLocal = sc.nextInt();

    System.out.print("Ingrese los goles del equipo visitante: ");
    int golesVisitante = sc.nextInt();
    sc.nextLine(); 

    local.updateStats(golesLocal, golesVisitante);
    visitante.updateStats(golesVisitante, golesLocal);

    Fecha nuevaFecha = new Fecha(fecha, local, visitante, golesLocal, golesVisitante);
    fechas.add(nuevaFecha);

    System.out.println("Partido registrado correctamente.");
}
    
   
         

  /*   public static void listarEquipos() {
        System.out.println("Equipos Registrados:");
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
        } else {
            for (Equipo equipo : equipos) {
                System.out.println(equipo.getNombre());
            }
        }
    }*/
      
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

    public static void generarReportes() {
        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            System.out.println(" >>>>>>>>>>>>>> Reportes <<<<<<<<<<<<<<<<<<");
            System.out.println("Seleccione el reporte que desea generar:");
            System.out.println("1. Nombre del equipo que mas goles anoto");
            System.out.println("2. Nombre del equipo que mas puntos tiene");
            System.out.println("3. Nombre del equipo que mas partidos gano");
            System.out.println("4. Total de goles anotados por todos los equipos");
            System.out.println("5. Promedio de goles anotados en el torneo");
            System.out.println("6. Volver al menu principal");
            System.out.println(" ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> reporteEquipoMasGoles();
                case 2 -> reporteEquipoMasPuntos();
                case 3 -> reporteEquipoMasGanados();
                case 4 -> mostrarTablaPosiciones();
                case 5 -> reportePromedioGoles();
                case 6 -> System.out.println("Volviendo al menu principal");
                default -> System.out.println("Seleccione una opción valida");
            }
        } while (opc != 6);
    }

    public static void reporteEquipoMasGoles() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        Equipo masGoles = null;

        for (Equipo equipo : equipos) {
            if (masGoles == null || equipo.getGF() > masGoles.getGF()) {
                masGoles = equipo;
            }
        }

        System.out.println("Equipo que mas goles anoto: " + (masGoles != null ? masGoles.getNombre() + " con " + masGoles.getGF() + " goles" : "N/A"));
    }

    public static void reporteEquipoMasPuntos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        Equipo masPuntos = null;

        for (Equipo equipo : equipos) {
            if (masPuntos == null || equipo.getTP() > masPuntos.getTP()) {
                masPuntos = equipo;
            }
        }

        System.out.println("Equipo que mas puntos tiene: " + (masPuntos != null ? masPuntos.getNombre() + " con " + masPuntos.getTP() + " puntos" : "N/A"));
    }

    public static void reporteEquipoMasGanados() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        Equipo masGanados = null;

        for (Equipo equipo : equipos) {
            if (masGanados == null || equipo.getPG() > masGanados.getPG()) {
                masGanados = equipo;
            }
        }

        System.out.println("Equipo que mas partidos gano: " + (masGanados != null ? masGanados.getNombre() + " con " + masGanados.getPG() + " partidos ganados" : "N/A"));
    }

    public static void reporteTotalGoles() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        int totalGoles = 0;

        for (Equipo equipo : equipos) {
            totalGoles += equipo.getGF();
        }

        System.out.println("Total de goles anotados por todos los equipos: " + totalGoles);
    }

    public static void reportePromedioGoles() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados para generar el reporte.");
            return;
        }

        int totalGoles = 0;
        int totalPartidos = 0;

        for (Equipo equipo : equipos) {
            totalGoles += equipo.getGF();
            totalPartidos += equipo.getPJ();
        }

        double promedioGoles = (totalPartidos > 0) ? (double) totalGoles / totalPartidos : 0;
        System.out.println("Promedio de goles anotados en el torneo: " + promedioGoles);
    }
    
    public static void mostrarTablaPosiciones() {
        System.out.printf("%-20s %5s %5s %5s %5s %5s %5s %5s%n", "NOMBRE DEL EQUIPO", "PJ", "PG", "PP", "PE", "GF", "GC", "TP");
        for (Equipo equipo : equipos) {
            System.out.printf("%-20s %5d %5d %5d %5d %5d %5d %5d%n", equipo.getNombre(), equipo.getPJ(), equipo.getPG(), equipo.getPP(), equipo.getPE(), equipo.getGF(), equipo.getGC(), equipo.getTP());
        }
    }
}
     
 
 

