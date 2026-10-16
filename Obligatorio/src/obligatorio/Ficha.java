package obligatorio;

import java.util.*;

public class Ficha {
    private String nombre;
    private String diseñoChico;
    private String diseñoGrande;
    private String color;

    public Ficha(String nombre, String diseñoChico, String diseñoGrande, String color) {
        this.nombre = nombre;
        this.diseñoChico = diseñoChico;
        this.diseñoGrande = diseñoGrande;
        this.color = color;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDiseñoChico() {
        return puntosAEspacios(diseñoChico);
    }

    public String getDiseñoGrande() {
        return puntosAEspacios(diseñoGrande);
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
    
    public void mostrar(HashMap<String,String> colores){
        System.out.println("Ficha: "+this.nombre);
        System.out.println("Color: "+this.color);
        System.out.println("Tamaño chico: ");
        verDiseño(true, colores);
        System.out.println("Tamaño grande: ");
        verDiseño(false, colores);
    }
    
    public void verDiseño(boolean chico, HashMap<String,String> colores){
        String color = this.getColor();
        String diseño = this.diseñoGrande;
        int largo = 5;
        if(chico){
            diseño = this.diseñoChico;
            largo = 3;
        }
        System.out.print(colores.get(color));
        for (int i = 0; i < largo*largo; i+=largo) {
            System.out.print(diseño.substring(i,i+largo));
            System.out.println("");
        }
        System.out.print(colores.get("P"));
    }
}
