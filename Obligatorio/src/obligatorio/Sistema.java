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

    public ArrayList<Mural> getListaMurales() {
        return listaMurales;
    }

    public ArrayList<Diseñador> getListaDiseñadores() {
        return listaDiseñadores;
    }
    
    
}
