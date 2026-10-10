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
}
