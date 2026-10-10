package obligatorio;

import java.util.*;

public class Interfaz {
    
    public static void menuPrincipal(Sistema sistema){
        int opcion=-1;
        while (opcion != 0){
            System.out.println("\n=================");
            System.out.println("MENU");
            System.out.println("=================\n");
            System.out.println("1) Información de autores del obligatorio");
            System.out.println("2) Registrar diseñador");
            System.out.println("3) Registrar ficha");
            System.out.println("4) Creación de mural");
            System.out.println("5) Modificar mural");
            System.out.println("6) Visualizar mural");
            System.out.println("7) Listado de diseñadores");
            System.out.println("8) Comparar similitud de murales");
            System.out.println("9) Visualizar todas las fichas");
            System.out.println("0) Terminar\n");
            opcion = pedirNumero(9);
            switch(opcion){
                case 1:
                    mostrarAutores();
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
                    menuMural(elegirMural(sistema.getListaMurales()));
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
    
    public static void mostrarAutores(){
        Scanner in = new Scanner(System.in);
        System.out.println("\n=================");
        System.out.println("AUTORES");
        System.out.println("=================\n");
        System.out.println("José Gabriel Erramuspe Rodríguez - 353422");
        System.out.println("Damián Agustín Torres Aramburu - 371643\n");
        System.out.println("Presione ENTER para continuar...");
        in.nextLine();
    }
    
    public static Mural elegirMural(ArrayList<Mural> listaMurales){
        Scanner in = new Scanner(System.in);
        for(int i=0; i<listaMurales.size(); i++){
            Mural mural = listaMurales.get(i);
            System.out.println((i+1)+") "+mural.getNombre()+" - "+mural.getDiseñador());
        }
        int opcion = pedirNumero(listaMurales.size())-1;
        return listaMurales.get(opcion);
    }
    
    public static void menuMural(Mural mural){
        int opcion=-1;
        while (opcion != 0){
            System.out.println("\n=================");
            System.out.println("MODIFICAR MURAL");
            System.out.println("=================\n");
            System.out.println("1) Modificar posición");
            System.out.println("2) Modificar ficha");
            System.out.println("3) Restaurar");
            System.out.println("0) Volver\n");
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
