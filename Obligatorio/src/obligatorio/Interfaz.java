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
            opcion = pedirNumero("Elija una opción",0,9);
            switch(opcion){
                case 1:
                    mostrarAutores();
                    break;
                case 2:
                    crearDiseñador(sistema);
                    break;
                case 3:
                    // algo
                    break;
                case 4:
                    // algo
                    break;
                case 5:
                    modificarMural(sistema);
                    break;
                case 6:
                    // algo
                    break;
                case 7:
                    mostrarDiseñadores(sistema);
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
    
    public static int pedirNumero(String mensaje, int desde, int hasta){
        Scanner in = new Scanner(System.in);
        int ret = -1;
        while(ret<0 || ret>hasta){
            System.out.println(mensaje+" ("+desde+"-"+hasta+")");
            System.out.print("> ");
            try{
                ret = in.nextInt();
                if(ret<0 || ret>hasta){
                System.out.println("\nERROR. Debe ingresar un número desde "+desde+" hasta "+hasta);
                }
            }
            catch(InputMismatchException e){
                System.out.println("\nERROR. Debe ingresar un número desde "+desde+" hasta "+hasta);
                in.nextLine();
            }
        }
        return ret;
    }
    
    public static String pedirString(String mensaje){
        Scanner in = new Scanner(System.in);
        String ret = "null";
        System.out.println(mensaje);
        try{
            ret = in.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("\nERROR. El string ingresado es incorrecto");
            in.nextLine();
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
    
    public static void modificarMural(Sistema sistema){
        Scanner in = new Scanner(System.in);
        for(int i=0; i<sistema.getListaMurales().size(); i++){
            Mural m = sistema.getListaMurales().get(i);
            System.out.println((i+1)+") "+m.getNombre()+" - "+m.getDiseñador());
        }
        int pos = pedirNumero("Elija un mural",1,sistema.getListaMurales().size())-1;
        Mural mural = sistema.getListaMurales().get(pos);
        int opcion=-1;
        Ficha[][] diseñoNuevo = mural.getDiseñoActual();
        while (opcion != 0){
            System.out.println("\n=================");
            System.out.println("MODIFICAR MURAL");
            System.out.println("=================\n");
            System.out.println("1) Modificar posición");
            System.out.println("2) Modificar ficha");
            System.out.println("3) Restaurar");
            System.out.println("0) Volver\n");
            opcion = pedirNumero("Elija una opción",0,3);
            switch(opcion){
                case 1:
                    int fila = pedirNumero("Elija número de fila",1,10)-1;
                    int col = pedirNumero("Elija número de columna",1,12)-1;
                    diseñoNuevo = modificarPosicion(sistema,diseñoNuevo,fila,col);
                    break;
                case 2:
                    Ficha original = elegirFicha("Elija la ficha a quitar",mural.getListaFichas());
                    Ficha actual = elegirFicha("Elija la nueva ficha",sistema.getListaFichas());
                    diseñoNuevo = modificarFicha(original, actual,diseñoNuevo);
                    mural.modificarFicha(original, actual);
                    break;
                case 3:
                    mural.setDiseñoActual(mural.getDiseñoOriginal());
                    break;
            }
            //mostrar diseñoNuevo en los dos tamaños
        }
        mural.setDiseñoActual(diseñoNuevo);
        sistema.removerMural(pos);
        sistema.agregarMural(mural);
    }
    
    public static Ficha[][] modificarPosicion(Sistema sistema, Ficha[][] diseño, int fila, int col){
        diseño[fila][col] = elegirFicha("Elija la ficha a colocar",sistema.getListaFichas());;
        return diseño;
    }
    
    public static Ficha[][] modificarFicha(Ficha original, Ficha actual, Ficha[][] diseño){
        for (int i = 0; i < diseño.length; i++) {
            for (int j = 0; j < diseño.length; j++) {
                if (diseño[i][j].equals(original)){
                    diseño[i][j]=actual;
                }
            }
        }
        return diseño;
    }
    
    public static Ficha elegirFicha(String mensaje, ArrayList<Ficha> listaFichas){
        for (int i = 0; i < listaFichas.size(); i++) {
            System.out.println((i+1)+") "+listaFichas.get(i));
        }
        System.out.println("");
        int pos = pedirNumero(mensaje,1,listaFichas.size())-1;
        return listaFichas.get(pos);
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
    
    public static void crearDiseñador(Sistema sistema) {
        Scanner in = new Scanner(System.in);
        String nombre = pedirString("Ingrese nombre");
        if (!sistema.existeNombreDiseñador(nombre)) {
            sistema.agregarDiseñador(new Diseñador(nombre, pedirString("Ingrese dirección"), pedirString("Ingrese mail")));
            System.out.println("Diseñador creado correctamente");
        } else {
            System.out.println("ERROR. Nombre de diseñador ya existe");
        }
        System.out.println("Presione ENTER para continuar...\n");
        in.nextLine();
    }
    
    public static void mostrarDiseñadores(Sistema sistema) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n=================");
        System.out.println("DISEÑADORES");
        System.out.println("=================");
        if (sistema.getListaDiseñadores().size() == 0) {
            System.out.println("No existen diseñadores");
        } else {
            for (Diseñador dis : sistema.getListaDiseñadores()) {
            System.out.println(dis.toString() + ", Murales Creados: " + dis.cantidadMuralesCreados(sistema) + ", Fichas Usadas: " + dis.cantidadFichasUsadas(sistema) + ", Colores Usados: " + dis.cantidadColoresUsados(sistema));
        }
        }
        System.out.println("Presione ENTER para continuar...");
        in.nextLine();
    }
}
    
