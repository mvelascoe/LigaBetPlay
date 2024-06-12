package com.fcf.ligabetplay.menus;
import java.util.Scanner;
import com.fcf.ligabetplay.logic.CuerpoMedicoService;
import com.fcf.ligabetplay.logic.CuerpoTecnicoService;
import com.fcf.ligabetplay.logic.EquipoService;
import com.fcf.ligabetplay.logic.JugadorService;
import com.fcf.ligabetplay.logic.PartidoService;
import com.fcf.ligabetplay.logic.ReporteService;
import com.fcf.ligabetplay.logic.SummaryTables;
import com.fcf.ligabetplay.models.Equipo;


public class Menus {
    Scanner sc = new Scanner(System.in);
   

//Menu principal
    public static void menuprincipal(Scanner sc){
        int opc;
         do{
            System.out.println("");
            System.out.println(" >>>>>>>>>>>>>> Menu <<<<<<<<<<<<<<<<<<");
            System.out.println("Seleccione la opcion que desea realizar");
            System.out.println("1. Registrar Equipos");
            System.out.println("2. Registro del Plantel");
            System.out.println("3. Registrar Fechas");
            System.out.println("4. Generar Reportes");
            System.out.println("5. Ver Plantel");
            System.out.println("6. Salir del programa");
            System.out.println(" ");
            opc = sc.nextInt();
            sc.nextLine();
          
            switch(opc){
                case 1 -> EquipoService.registrarEquipo();
                case 2 -> registroPlantel(sc);
                case 3 -> PartidoService.registrarFechas(sc);
                case 4 -> generarReportes(sc);
                case 5 -> infoPlantel(sc);
                case 6 -> System.out.println("Finalizando Programa");
                default -> System.out.println("Seleccione una opcion valida");
            }
        }
        while(opc != 6);
    }


    //Submenu, registro del plantel

    public static void registroPlantel(Scanner sc) {
        int opc;
        do {
            System.out.println(">>>>>>>>>>>>>>>>> Registro <<<<<<<<<<<<<<");
            System.out.println("1. Registrar Jugadores");
            System.out.println("2. Registrar Cuerpo Tecnico");
            System.out.println("3. Registrar Cuerpo Medico");
            System.out.println("4. Volver al menu anterior");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> JugadorService.registrarJugadores(sc);
                case 2 -> CuerpoTecnicoService.registrarCuerpoTecnico(sc);
                case 3 -> CuerpoMedicoService.registrarCuerpoMedico(sc);
                case 4 -> System.out.println("Volviendo al menú anterior");
                default -> System.out.println("Seleccione una opción válida");
            }
        } while (opc != 4);
    }

    //Submenu reportes 

    public static void generarReportes(Scanner sc) {
        int opc;
        do {
            System.out.println(" >>>>>>>>>>>>>> Reportes de Equipo <<<<<<<<<<<<<<<<<<");
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
                case 1 -> ReporteService.reporteEquipoMasGoles();
                case 2 -> ReporteService.reporteEquipoMasPuntos();
                case 3 -> ReporteService.reporteEquipoMasGanados();
                case 4 -> ReporteService.mostrarTablaPosiciones();
                case 5 -> ReporteService.reportePromedioGoles();
                case 6 -> System.out.println("Volviendo al menu principal");
                default -> System.out.println("Seleccione una opción valida");
            }
        } while (opc != 6);
    }


    // Menu del plantel
    public static void infoPlantel(Scanner sc){
        int opc;
        do {
            System.out.println("Escoja la opcion que desea escoger");
            System.out.println("1. Listar informacion de los Jugadores");
            System.out.println("2. Listar cuerpo tecnico");
            System.out.println("3. Listar cuerpo medico");
            System.out.println("4. Ver tabla de jugadores");
            System.out.println("");
            opc = sc.nextInt();
            sc.nextLine();

            if (opc >= 1 && opc <= 4) {
                Equipo equipo = SummaryTables.mostrarMenuResumen(sc);
                if (equipo == null) {
                    continue; // vuelve al menu si no selecciona una opcion 
                }

                switch (opc) {
                    case 1 -> SummaryTables.tablaInfoJugadores(equipo);
                    case 2 -> SummaryTables.tablaCuerpoTecnico(equipo);
                    case 3 -> SummaryTables.tablaCuerpoMedico(equipo);
                    case 4 -> SummaryTables.tablaJugadores(equipo);
                    case 5 -> System.out.println("Volver al menu principal");
                    default -> System.out.println("Seleccione una opcion valida");
                }
            } else if (opc != 5) {
                System.out.println("Seleccione una opción válida");
            }
        } while (opc != 5);
    }
}



