package obligatorio;

import java.util.*;

public class Interfaz {
    
    public static void menuPrincipal(){
        int opcion=-1;
        while (opcion != 0){
            imprimirMenuPrincipal();
            opcion = pedirNumero(9);
            switch(opcion){
                case 1:
                    // algo
                    break;
                case 2:
                    // algo
                    break;
                case 3:
                    // algo
                    break;
                case 4:
                    // algo
                    break;
                case 5:
                    // algo
                    break;
                case 6:
                    // algo
                    break;
                case 7:
                    // algo
                    break;
                case 8:
                    // algo
                    break;
                case 9:
                    // algo
                    break;
            }
        }
        System.out.println("\nHasta luego!");
    }
    
    public static void imprimirMenuPrincipal(){
        System.out.println("=================\n");
        System.out.println("MENU\n");
        System.out.println("=================\n");
        System.out.println("1) Información de autores del obligatorio\n");
        System.out.println("2) Registrar diseñador\n");
        System.out.println("3) Registrar ficha\n");
        System.out.println("4) Creación de mural\n");
        System.out.println("5) Modificar mural\n");
        System.out.println("6) Visualizar mural\n");
        System.out.println("7) Listado de diseñadores\n");
        System.out.println("8) Comparar similitud de murales\n");
        System.out.println("9) Visualizar todas las fichas\n");
        System.out.println("0) Terminar\n");
    }
    
    public static int pedirNumero(int hasta){
        Scanner in = new Scanner(System.in);
        int ret = -1;
        while(ret<0 || ret>hasta){
            System.out.println("Ingrese un número (0-"+hasta+")");
            System.out.print("> ");
            try{
                ret = in.nextInt();
                if(ret<0 || ret>hasta){
                System.out.println("\nERROR. Debe ingresar un número desde 0 hasta "+hasta);
                }
            }
            catch(InputMismatchException e){
                System.out.println("\nERROR. Debe ingresar un número desde 0 hasta "+hasta);
                in.nextLine();
            }
        }
        return ret;
    }
    
    public static void menuMural(){
        int opcion=-1;
        while (opcion != 0){
            imprimirMenuMural();
            opcion = pedirNumero(3);
            switch(opcion){
                case 1:
                    // algo
                    break;
                case 2:
                    // algo
                    break;
                case 3:
                    // algo
                    break;
            }
        }
    }
    
    public static void imprimirMenuMural(){
        System.out.println("=================\n");
        System.out.println("MODIFICAR MURAL\n");
        System.out.println("=================\n");
        System.out.println("1) Modificar posición\n");
        System.out.println("2) Modificar ficha\n");
        System.out.println("3) Restaurar\n");
        System.out.println("0) Volver\n");
    }
    
    public static String pedirColor(){
        Scanner in = new Scanner(System.in);
        String color = "";
        boolean ok = false;
        while(!ok){
            System.out.println("Ingrese color de la ficha: ");
            System.out.println("R=Rojo A=Azul B=Blanco N=Negro M=Amarillo V=Verde G=Magenta C=Celeste");
            System.out.print("> ");
            color = in.nextLine().toUpperCase();
            switch(color){
                case "R":
                case "A":
                case "B":
                case "N":
                case "M":
                case "V":
                case "G":
                case "C":
                    ok = true;
                    break;
                default:
                    System.out.println("ERROR. No ingresó un color permitido\n");
                    break;
            }
        }
        return color;
    }
}
    