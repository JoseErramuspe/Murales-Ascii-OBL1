package obligatorio;

import java.util.*;

public class Diseñador {
    private String nombre;
    private String direccion;
    private String mail;

    public Diseñador(String nombre, String direccion, String mail) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMail() {
        return mail;
    }
    
    public int cantidadMuralesCreados(Sistema sistema) {
        int ret = 0;
        for (Mural mur : sistema.getListaMurales()) {
            if (mur.getDiseñador().equals(this)) {
                ret++;
            }
        }
        return ret;
    }
    
    public int cantidadFichasUsadas(Sistema sistema) {
        ArrayList<Ficha> listaFichas = new ArrayList<Ficha>();
        for (Mural mur : sistema.getListaMurales()) {
            if (mur.getDiseñador().equals(this)) {
                for (Ficha fich : mur.getListaFichas()) {
                    if (!listaFichas.contains(fich)) {
                        listaFichas.add(fich);
                    }
                }
            }
        }
        return listaFichas.size();
    }
    
    public int cantidadColoresUsados(Sistema sistema) {
        ArrayList<String> listaColores = new ArrayList<String>();
        for (Mural mur : sistema.getListaMurales()) {
            if (mur.getDiseñador().equals(this)) {
                for (Ficha fich : mur.getListaFichas()) {
                    if (!listaColores.contains(fich.getColor())) {
                        listaColores.add(fich.getColor());
                    }
                }
            }
        }
        return listaColores.size();
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Mail: " + mail + ", Dirección: " + direccion;
    }
}
