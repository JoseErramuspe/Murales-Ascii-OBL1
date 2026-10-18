package obligatorio;

import java.util.*;

public class Mural {

    private String nombre;
    private Diseñador diseñador;
    private Ficha[][] diseñoOriginal;
    private Ficha[][] diseñoActual;
    private ArrayList<Ficha> listaFichas;

    public Mural(String nombre, Diseñador diseñador, Ficha[][] diseño, Ficha ficha1, Ficha ficha2, String tipoDeMural, ArrayList<Ficha> fichasDelMural) {
        this.nombre = nombre;
        this.diseñador = diseñador;
        this.listaFichas = new ArrayList<>();
        for (Ficha ficha : fichasDelMural) {
            this.agregarFicha(ficha);
        }
        switch (tipoDeMural) {
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
                        if (i % 2 == 0) {
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
                break;
            default:
            case "D":
                boolean vaPrimera = true;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (vaPrimera) {
                            diseño[i][j] = ficha1;
                        } else {
                            diseño[i][j] = ficha2;

                        }
                        vaPrimera = !vaPrimera;
                    }
                    vaPrimera = !vaPrimera;
                }
                break;
        }
        this.diseñoOriginal = clonar(diseño);
        this.diseñoActual = clonar(diseño);
    }

    public Diseñador getDiseñador() {
        return diseñador;
    }

    public String getNombre() {
        return nombre;
    }

    public Ficha[][] getDiseñoOriginal() {
        return diseñoOriginal;
    }

    public Ficha[][] getDiseñoActual() {
        return diseñoActual;
    }

    public void setDiseñoActual(Ficha[][] diseñoActual) {
        this.diseñoActual = clonar(diseñoActual);
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public void agregarFicha(Ficha ficha) {
        this.listaFichas.add(ficha);
    }

    public void modificarListaFichas(Ficha original, Ficha actual) {
        this.listaFichas.remove(original);
        if (!this.listaFichas.contains(actual)) {
            this.listaFichas.add(actual);
        }
    }

    public HashMap<Mural, int[]> compararSimilitud(Sistema sistema, int filaInicial, int columnaInicial, int filaLargo, int columnaLargo) {
        HashMap<Mural, int[]> muralesSimilares = new HashMap<>();
        if (sistema.getListaMurales().size() >= 2) {
            for (Mural muralOtro : sistema.getListaMurales()) {
                if (!muralOtro.equals(this)) {
                    boolean agregado = false;
                    for (int i = 0; i < 10 - filaLargo + 1 && !agregado; i++) {
                        for (int j = 0; j < 12 - columnaLargo + 1 && !agregado; j++) {
                            int filaInicialOtro = -1;
                            int columnaInicialOtro = -1;
                            boolean areaIgual = true;
                            for (int ii = 0; ii < filaLargo && areaIgual; ii++) {
                                for (int jj = 0; jj < columnaLargo && areaIgual; jj++) {
                                    if (!muralOtro.getDiseñoActual()[i + ii][j + jj].equals(this.getDiseñoActual()[filaInicial + ii][columnaInicial + jj])) {
                                        areaIgual = false;
                                    } else if (filaInicialOtro == -1 && columnaInicialOtro == -1) {
                                        filaInicialOtro = i;
                                        columnaInicialOtro = j;
                                    }
                                }
                            }
                            if (areaIgual && !agregado) {
                                int[] pos = {filaInicialOtro, columnaInicialOtro};
                                muralesSimilares.put(muralOtro, pos);
                                agregado = true;
                            }
                        }
                    }
                }
            }
        }
        return muralesSimilares;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public Ficha[][] clonar(Ficha[][] diseño){
        Ficha[][] diseñoNuevo = new Ficha[10][12];
        for (int i = 0; i < 10; i++) {
            diseñoNuevo[i]=diseño[i].clone();
        }
        return diseñoNuevo;
    }
}
