import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {
    public static void main(String[] args) {
        System.out.println("Iniciando...");
        Collection<Integer> teste = new ArrayList();
        Instant inicio = Instant.now();
        int total = 30000;
        for (int i = 0; i < total; i++) {
            teste.add(i);
        }
        for (int i = 0; i < total; i++) {
            teste.contains(i);
        }
        Instant fim = Instant.now();
        Duration tempo = Duration.between(inicio, fim);
        System.out.println("Tempo gasto: " + tempo.toMillis() + " ms");
    }
}