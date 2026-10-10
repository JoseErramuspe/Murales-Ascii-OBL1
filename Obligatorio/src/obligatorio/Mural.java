package obligatorio;

public class Mural {
    private String nombre;
    private Diseñador diseñador;
    private Ficha[][] diseñoOriginal;
    private Ficha[][] diseñoActual;

    public Mural(String nombre, Diseñador diseñador, Ficha[][] diseño) {
        this.nombre = nombre;
        this.diseñador = diseñador;
        this.diseñoOriginal = diseño.clone();
        this.diseñoActual = diseño.clone();
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
}
