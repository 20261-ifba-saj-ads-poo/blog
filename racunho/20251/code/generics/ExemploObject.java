import java.io.IO;
import java.util.ArrayList;
import java.util.List;

public class ExemploObject {
    public static void main(String[] args) {
        // Lista sem generics (usa Object)
        List lista = new ArrayList();
        
        // Adicionando elementos de tipos diferentes
        lista.add("Texto"); // String
        lista.add(10);      // Integer
        lista.add(3.14);    // Double

        // Recuperando elementos (precisa de cast)
        String texto = (String) lista.get(0); // Cast para String
        Integer numero = (Integer) lista.get(1); // Cast para Integer
        Double decimal = (Double) lista.get(2); // Cast para Double

        IO.println("Texto: " + texto);
        IO.println("Número: " + numero);
        IO.println("Decimal: " + decimal);

        // Problema: Erro em tempo de execução se o cast estiver errado
        try {
            Integer erro = (Integer) lista.get(0); // Cast incorreto (String para Integer)
        } catch (ClassCastException e) {
            IO.println("Erro de cast: " + e.getMessage());
        }
    }
}