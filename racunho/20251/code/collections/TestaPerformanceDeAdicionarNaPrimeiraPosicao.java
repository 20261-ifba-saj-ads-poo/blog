import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class TestaPerformanceDeAdicionarNaPrimeiraPosicao {
    public static void main(String[] args) {
        System.out.println("Iniciando...");
        Instant inicio = Instant.now();
        // trocar depois por ArrayList
        List<Integer> teste = new LinkedList<>();
        for (int i = 0; i < 30000; i++) {
            teste.add(0, i);
        }
        Duration tempo = Duration.between(inicio, Instant.now());
        System.out.println("Tempo gasto: " + tempo.toMillis() + " ms");

    }
}
