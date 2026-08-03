import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {
    public static void main(String[] args) {
        NavigableSet<Integer> numeros = new TreeSet<>();
        
        // Adicionando elementos
        numeros.add(1000);
        numeros.add(2000);
        numeros.add(3000);
        numeros.add(4000);
        numeros.add(5000);

        // Obtendo o primeiro e último elemento
        System.out.println("Primeiro: " + numeros.first());
        System.out.println("Último: " + numeros.last());

        // Obtendo elementos menores e maiores
        System.out.println("Menor que 3000: " + numeros.lower(3000));
        System.out.println("Maior que 3000: " + numeros.higher(3000));

        // Obtendo subconjuntos
        System.out.println("Entre 2000 e 4000: " + numeros.subSet(2000, true, 4000, true));

        // Conjunto reverso
        System.out.println("Ordem decrescente: " + numeros.descendingSet());

        // Removendo primeiro e último
        System.out.println("Removido primeiro: " + numeros.pollFirst());
        System.out.println("Removido último: " + numeros.pollLast());
    }
}