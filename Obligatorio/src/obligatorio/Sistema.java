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
    
    public void cambiarMural(int pos, Mural mural){
        this.listaMurales.set(pos, mural);
    }
    
    public ArrayList<Diseñador> getListaDiseñadores() {
        return listaDiseñadores;
    }
    
    public void agregarDiseñador(Diseñador diseñador) {
        this.listaDiseñadores.add(diseñador);
    }
    
    public boolean existeNombreDiseñador(String nombre) {
        boolean existe = false;
        for (Diseñador dis : this.listaDiseñadores) {
            if (dis.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                existe = true;
            }
        }
        return existe;
    }
    
    public boolean existeNombreFicha(String nombre) {
        boolean existe = false;
        for (Ficha fich : this.listaFichas) {
            if (fich.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                existe = true;
            }
        }
        return existe;
    }
    
    public boolean existeNombreMural(String nombre) {
        boolean existe = false;
        for (Mural mur : this.listaMurales) {
            if (mur.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                existe = true;
            }
        }
        return existe;
    }
    
}
