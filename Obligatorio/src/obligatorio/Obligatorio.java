package obligatorio;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Obligatorio {

    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException ex) {
            System.getLogger(Obligatorio.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        Sistema sistema = new Sistema();
        
        sistema.agregarFicha(new Ficha("SOL", "\\|/-*-/|\\", "..|...\\|/.--*--./|\\...|..", "M"));
        sistema.agregarFicha(new Ficha("CUADRADO", "+-+|.|+-+", "+---+|...||...||...|+---+", "N"));
        sistema.agregarFicha(new Ficha("CORAZON", "*.****.*.", "**.************.***...*..", "R"));
        sistema.agregarFicha(new Ficha("COPA", "\\./.|./_\\", "\\.../.\\./...|....|.../_\\. ", "C"));
        sistema.agregarFicha(new Ficha("ARBOL", ".^.^^^.|.", "..^...^^^.^^^^^..|.../.\\.", "V"));
        sistema.agregarFicha(new Ficha("GATO", "^.^o.o=^=", "/\\_/\\(o.o).>^<../|\\../.\\.", "A"));
        sistema.agregarFicha(new Ficha("DIAMANTE", ".*.*.*.*.", "..*...*.*.*...*.*.*...*..", "G"));
        sistema.agregarFicha(new Ficha("VACIA", ".........", ".........................", "B"));
        
        Interfaz.menuPrincipal(sistema);
    }
    
}
