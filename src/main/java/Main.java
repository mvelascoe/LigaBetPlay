/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.fcf.ligabetplay.model.Ligabetplay;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int opc;
          
          //Creacion del menu
          do{
              System.out.println(" >>>>>>>>>>>>>> Menu <<<<<<<<<<<<<<<<<<");
              System.out.println("Seleccione la opcion que desea realizar");
              System.out.println("1. Registrar Equipos");
              System.out.println("2. Registrar Fechas");
              System.out.println("3. Generar Reportes");
              System.out.println("4. Salir del programa");
              System.out.println(" ");
              opc = sc.nextInt();
              sc.nextLine();
          
              switch(opc){
                  case 1 -> Ligabetplay.registrarEquipo();
                  case 2 -> Ligabetplay.registrarFechas(sc);
                  case 3 -> Ligabetplay.generarReportes();
                  case 4 -> System.out.println("Finalizando Programa");
                  default -> System.out.println("Seleccione una opcion valida");
              }
          }
          while(opc != 4);
          
      }
}
