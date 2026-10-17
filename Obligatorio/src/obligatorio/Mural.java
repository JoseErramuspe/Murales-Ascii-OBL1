package obligatorio;

import java.util.*;

public class Mural {

    private String nombre;
    private Diseñador diseñador;
    private Ficha[][] diseñoOriginal;
    private Ficha[][] diseñoActual;
    private ArrayList<Ficha> listaFichas;

    public Mural(String nombre, Diseñador diseñador, Ficha[][] diseño) {
        this.nombre = nombre;
        this.diseñador = diseñador;
        this.diseñoOriginal = diseño.clone();
        this.diseñoActual = diseño.clone();
        this.listaFichas = new ArrayList<>();
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
        this.diseñoActual = diseñoActual;
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

    public HashMap<Mural,int[]> compararSimilitud(Sistema sistema, int filaInicial, int columnaInicial, int filaLargo, int columnaLargo) {
        HashMap<Mural,int[]> muralesSimilares = new HashMap<>();
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
}
