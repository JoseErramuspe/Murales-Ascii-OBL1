package obligatorio;

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
}
