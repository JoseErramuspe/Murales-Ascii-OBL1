package obligatorio;

import java.util.*;

public class Sistema {
    private ArrayList<Ficha> listaFichas;
    private ArrayList<Mural> listaMurales;
    private ArrayList<Diseñador> listaDiseñadores;
    
    public Sistema() {
        this.listaFichas = new ArrayList<>();
        this.listaMurales = new ArrayList<>();
        this.listaDiseñadores = new ArrayList<>();
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }
    
    public void agregarFicha(Ficha ficha) {
        this.listaFichas.add(ficha);
    }

    public ArrayList<Mural> getListaMurales() {
        return listaMurales;
    }

    public void agregarMural(Mural mural) {
        this.listaMurales.add(mural);
    }
    
    public void removerMural(int pos){
        this.listaMurales.remove(pos);
    }
    
    public ArrayList<Diseñador> getListaDiseñadores() {
        return listaDiseñadores;
    }
    
    public void agregarDiseñador(Diseñador diseñador) {
        this.listaDiseñadores.add(diseñador);
    }
    
}
