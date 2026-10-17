package obligatorio;

import java.util.*;

public class Ficha {
    private String nombre;
    private String diseñoChico;
    private String diseñoGrande;
    private String color;

    public Ficha(String nombre, String diseñoChico, String diseñoGrande, String color) {
        this.nombre = nombre;
        this.diseñoChico = puntosAEspacios(diseñoChico);
        this.diseñoGrande = puntosAEspacios(diseñoGrande);
        this.color = color;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDiseñoChico() {
        return diseñoChico;
    }

    public String getDiseñoGrande() {
        return diseñoGrande;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public static String puntosAEspacios(String diseño) {
        String ret = "";
        for (int i = 0; i < diseño.length(); i++) {
            if (diseño.charAt(i) == '.') {
                ret += " ";
            } else {
                ret += diseño.charAt(i);
            }
        }
        return ret;
    }
}
