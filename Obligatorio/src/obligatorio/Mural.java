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
 
    public void modificarListaFichas(Ficha original, Ficha actual){
        this.listaFichas.remove(original);
        if(!this.listaFichas.contains(actual)){
            this.listaFichas.add(actual);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public void mostrar(boolean mostrarChico, HashMap<String,String> colores){
        int largo = 5;
        if(mostrarChico){
            largo = 3;
        }
        for (int i = 0; i < diseñoActual.length; i++) {
            for (int k = 0; k < largo*largo; k+=largo) {
                for (int j = 0; j < diseñoActual[i].length; j++) {
                    String colorFicha = diseñoActual[i][j].getColor();
                    String diseñoFicha = diseñoActual[i][j].getDiseñoGrande();
                    if(mostrarChico){
                        diseñoFicha = diseñoActual[i][j].getDiseñoChico();
                    }
                    System.out.print(colores.get(colorFicha)+diseñoFicha.substring(k,k+largo)+colores.get("P"));
                }
                System.out.println("");
            }
        }
    }
}
