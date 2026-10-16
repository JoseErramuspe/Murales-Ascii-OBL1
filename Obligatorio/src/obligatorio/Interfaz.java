package obligatorio;

import java.util.*;

public class Interfaz {
    
    public static void menuPrincipal(Sistema sistema){
        int opcion=-1;
        HashMap <String, String> colores = new HashMap<>();
        colores.put("R", "\033[31m");
        colores.put("A", "\033[34m");
        colores.put("B", "\033[37m");
        colores.put("N", "\033[30m");
        colores.put("M", "\033[33m");
        colores.put("V", "\033[32m");
        colores.put("G", "\033[35m");
        colores.put("C", "\033[36m");
        colores.put("P", "\u001B[0m"); //parar de pintar
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
                    crearFicha(sistema, colores);
                    break;
                case 4:
                    crearMural(sistema);
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
        String ret = "";
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
    
    public static void mostrarDiseñadores(Sistema sistema) {
        ArrayList<Diseñador> listaDiseñadores = new ArrayList<>(sistema.getListaDiseñadores());
        Collections.sort(listaDiseñadores);
        Scanner in = new Scanner(System.in);
        System.out.println("\n=================");
        System.out.println("DISEÑADORES");
        System.out.println("=================");
        if (listaDiseñadores.isEmpty()) {
            System.out.println("No existen diseñadores");
        } else {
            for (Diseñador dis : listaDiseñadores) {
                System.out.println(dis.toString() + ", Murales Creados: " + dis.cantidadMuralesCreados(sistema) + ", Fichas Usadas: " + dis.cantidadFichasUsadas(sistema) + ", Colores Usados: " + dis.cantidadColoresUsados(sistema));
            }
        }
        System.out.println("Presione ENTER para continuar...");
        in.nextLine();
    }
    
    public static void mostrarFicha(Ficha ficha) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n=================");
        System.out.println(ficha.getNombre());
        System.out.println("=================");
        System.out.println("Diseño grande:");
        for (int i = 0; i < ficha.getDiseñoGrande().length(); i++) {
            if (ficha.getDiseñoGrande().charAt(i) == '.') {
                System.out.print(" ");
            } else {
                System.out.print(ficha.getDiseñoGrande().charAt(i));
            }
            if ((i+1)%5 == 0) {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("Diseño chico:");
        for (int i = 0; i < ficha.getDiseñoChico().length(); i++) {
            if (ficha.getDiseñoChico().charAt(i) == '.') {
                System.out.print(" ");
            } else {
                System.out.print(ficha.getDiseñoChico().charAt(i));
            }
            if ((i+1)%3 == 0) {
                System.out.println("");
            }
        }
    }
    
    public static void mostrarMural(Mural mural, boolean mostrarGrande) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n=================");
        System.out.println(mural.getNombre());
        System.out.println("=================");
        // FALTA TERMINAR
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
    
    public static void crearDiseñador(Sistema sistema) {
        Scanner in = new Scanner(System.in);
        String nombre = pedirString("Ingrese nombre");
        if (!sistema.existeNombreDiseñador(nombre) && !nombre.isBlank()) {
            sistema.agregarDiseñador(new Diseñador(nombre, pedirString("Ingrese dirección"), pedirString("Ingrese mail")));
            System.out.println("Diseñador creado correctamente");
        } else {
            System.out.println("ERROR. Nombre de diseñador ya existe o es vacío");
        }
        System.out.println("Presione ENTER para continuar...\n");
        in.nextLine();
    }
    
    public static void crearFicha(Sistema sistema, HashMap<String, String> colores) {
        Scanner in = new Scanner(System.in);
        boolean error = false;
        String diseñoChico = ".........";
        String diseñoGrande = ".........................";
        String color = "R";
        String nombre = pedirString("Ingrese nombre").toUpperCase();
        if (sistema.existeNombreFicha(nombre)) {
            System.out.println("ERROR. Nombre de ficha ya existe");
            error = true;
        }
        if (nombre.isBlank()) {
            System.out.println("ERROR. Nombre de ficha es vacío");
            error = true;
        }
        if (!error) {
            diseñoChico = pedirString("Ingrese el diseño chico (9 caracteres, '.' = espacio)");
            if (diseñoChico.length() != 9) {
                System.out.println("ERROR. El diseño chico debe ser de 3x3 (9 caracteres)");
                error = true;
            }
        }
        if (!error) {
            diseñoGrande = pedirString("Ingrese el diseño grande (25 caracteres, '.' = espacio)");
            if (diseñoGrande.length() != 25) {
                System.out.println("ERROR. El diseño grande debe ser de 5x5 (25 caracteres)");
                error = true;
            }
        }
        if (!error) {
            color = pedirString("Ingrese el color (R=rojo, A=azul, B=blanco, N=negro, M=amarillo, V=verde, G=magenta, C=celeste)").toUpperCase();
            if (!colores.containsKey(color)) {
                System.out.println("ERROR. No se ingresó un color permitido");
                error = true;
            }
        }
        if (!error) {
            Ficha nuevaFicha = new Ficha(nombre, diseñoChico, diseñoGrande, color);
            sistema.agregarFicha(nuevaFicha);
            System.out.println("Ficha creada correctamente");
            mostrarFicha(nuevaFicha);
        }
        System.out.println("Presione ENTER para continuar...\n");
        in.nextLine();
    }
    
    public static void crearMural(Sistema sistema) {
        Scanner in = new Scanner(System.in);
        boolean error = false;
        Diseñador autor = null;
        Ficha ficha1 = null;
        Ficha ficha2 = null;
        String nombre = "null";
        Ficha[][] diseño = new Ficha[10][12];
        if (sistema.getListaDiseñadores().isEmpty()) {
            System.out.println("ERROR. No se han agregado diseñadores aún");
            error = true;
        }
        if (sistema.getListaFichas().size() < 2 && !error) {
            System.out.println("ERROR. Se requieren al menos dos fichas para crear un mural");
            error = true;
        }
        if (!error) {
            nombre = pedirString("Ingrese nombre");
            if (sistema.existeNombreMural(nombre)) {
                System.out.println("ERROR. Nombre de mural ya existe");
                error = true;
            }
            if (nombre.isBlank()) {
                System.out.println("ERROR. Nombre de mural es vacío");
                error = true;
            }
        }
        if (!error) {
            ArrayList<Diseñador> listaDiseñadores = new ArrayList<>(sistema.getListaDiseñadores());
            Collections.sort(listaDiseñadores);
            for (int i = 0; i < listaDiseñadores.size(); i++) {
                System.out.println((i+1)+". "+listaDiseñadores.get(i).getNombre());
            }
            autor = listaDiseñadores.get((pedirNumero("Seleccione diseñador del mural", 1, listaDiseñadores.size())));
        }
        if (!error) {
            ArrayList<Ficha> listaFichas = new ArrayList<>(sistema.getListaFichas());
            for (int i = 0; i < listaFichas.size(); i++) {
                System.out.println((i+1)+". "+listaFichas.get(i).getNombre());
            }
            ficha1 = listaFichas.get((pedirNumero("Seleccione primera ficha del mural", 1, listaFichas.size())));
            ficha2 = listaFichas.get((pedirNumero("Seleccione segunda ficha del mural distinta a la primera", 1, listaFichas.size())));
            if (ficha1 == ficha2) {
                System.out.println("ERROR. Fichas seleccionadas son iguales");
                error = true;
            }
        }
        if (!error) {
            String tipoDeMural = pedirString("Ingrese el método de creación del mural (D=damero, R=random, F=alternado por filas, B=borde exterior, M=manual)").toUpperCase();
            switch (tipoDeMural) {
                case "D":
                    boolean vaPrimera = true;
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (vaPrimera) {
                                diseño[i][j] = ficha1;
                                vaPrimera = !vaPrimera;
                            }
                        }
                        vaPrimera = !vaPrimera;
                    }
                    break;
                case "R":
                    Random random = new Random();
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (random.nextInt(2) == 0) {
                                diseño[i][j] = ficha1;
                            } else {
                                diseño[i][j] = ficha2;
                            }
                        }
                    }
                    break;
                case "F":
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (i%2 == 0) {
                                diseño[i][j] = ficha1;
                            } else {
                                diseño[i][j] = ficha2;
                            }
                        }
                    }
                    break;
                case "B":
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (i == 0 || i == 9 || j == 0 || j == 11) {
                                diseño[i][j] = ficha1;
                            } else {
                                diseño[i][j] = ficha2;
                            }
                        }
                    }
                    break;
                case "M":
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (pedirNumero("Seleccione ficha 1 o 2 para la posición "+(i+1)+","+(j+1), 1, 2) == 1) {
                                diseño[i][j] = ficha1;
                            } else {
                                diseño[i][j] = ficha2;
                            }
                        }
                    }
                    break;
            }
        }
        if (!error) {
            sistema.agregarMural(new Mural(nombre, autor, diseño));
            System.out.println("Mural creado correctamente");
        }
        System.out.println("Presione ENTER para continuar...\n");
        in.nextLine();
    }
}
