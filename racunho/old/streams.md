https://www.oracle.com/br/technical-resources/articles/java/processing-streams-java-se-8.html

# Streams no java

Streams são sequências de elementos que podem ser processadas de forma eficiente. No java, as streams são usadas para realizar operações em coleções de dados, como filtragem, mapeamento, redução e agrupamento, permitindo uma abordagem mais funcional e declarativa para a manipulação de dados.

Os Streams foram introduzidos no Java 8 e são uma parte fundamental da programação funcional no Java. Eles permitem que você trabalhe com coleções de dados de forma mais simples e legível, evitando a necessidade de loops explícitos e a manipulação manual de itens individuais.

É possível criar streams a partir de coleções, como listas, conjuntos ou matrizes e interagir com elas usando uma série de métodos de operação intermediária, transformações e operações terminal.

## Threads e Streams

Em um ambiente multithreaded, as streams podem ser usadas para processar dados de forma paralela, permitindo que várias threads trabalhem em partes diferentes da stream simultaneamente. Isso pode melhorar significativamente o desempenho em cenários de processamento intensivo de dados.

Sem a adoção do Streams, seria necessário criar um loop para cada operação que desejamos realizar (como filtrar, mapear, reduzir, etc.) alem de criar a logica para lidar com a concorrência. Com o Streams, podemos criar uma pipeline de operações que será executada de forma paralela, e a JVM irá gerenciar a concorrência automaticamente.

## Exemplos de código (Java)

### 1) Criação, filter, map e collect
```java
import java.util.*;
import java.util.stream.*;

List<String> nomes = List.of("Ana", "Bruno", "Carlos", "Bea");
List<String> resultado = nomes.stream()
    .filter(s -> s.startsWith("B"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());
// resultado -> ["BRUNO", "BEA"]
```

### 2) IntStream e redução (sum)
```java
import java.util.stream.IntStream;

int soma = IntStream.rangeClosed(1, 10) // 1..10
    .sum(); // 55
```

### 3) Stream paralelo (paralelismo)
```java
import java.util.*;
import java.util.stream.*;

List<Integer> nums = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
nums.parallelStream()
    .map(n -> n * n)
    .forEachOrdered(System.out::println); // execução em paralelo, saída ordenada por forEachOrdered
```

### 4) flatMap — transformar listas de listas em uma única sequência
```java
import java.util.*;
import java.util.stream.*;

List<List<String>> listaDeListas = List.of(
    List.of("a","b"),
    List.of("c","d","e")
);

List<String> plano = listaDeListas.stream()
    .flatMap(Collection::stream)
    .collect(Collectors.toList());
// plano -> ["a","b","c","d","e"]
```

### 5) Collectors: agrupamento e contagem
```java
import java.util.*;
import java.util.stream.*;

List<String> palavras = List.of("java","js","python","c","kotlin","go");
Map<Integer, List<String>> porTamanho = palavras.stream()
    .collect(Collectors.groupingBy(String::length));
// porTamanho.get(4) -> ["java","kotlin" contains etc depending on lengths]

Map<String, Long> contagem = palavras.stream()
    .collect(Collectors.groupingBy(s -> s.substring(0,1), Collectors.counting()));
```

### 6) findFirst / findAny e Optional
```java
import java.util.*;
import java.util.stream.*;

Optional<String> primeiroB = Stream.of("x","beto","bruna")
    .filter(s -> s.startsWith("b"))
    .findFirst();

primeiroB.ifPresent(System.out::println); // imprime "beto"
```

### 7) Streams infinitos (generate / iterate) com limit
```java
import java.util.stream.*;

Stream.iterate(1, n -> n + 2)
    .limit(5)
    .forEach(System.out::println); // 1,3,5,7,9

Stream.generate(Math::random)
    .limit(3)
    .forEach(System.out::println);
```

Observação rápida: prefira operações intermediárias sem efeitos colaterais, use collectors para resultados finais e teste paralelismo (parallelStream) apenas quando for realmente benéfico para o caso de uso.

### Exemplos com Threads (Java)

#### 1) Criar Thread com Runnable (lambda)
```java
public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Executando em: " + Thread.currentThread().getName());
        }, "minha-thread");
        t.start();
        t.join(); // espera terminar
    }
}
```

#### 2) Estender Thread
```java
class MinhaThread extends Thread {
    public MinhaThread(String nome) { super(nome); }
    @Override
    public void run() {
        System.out.println("Olá de " + getName());
    }
}

public class Ex2 {
    public static void main(String[] args) {
        new MinhaThread("t-1").start();
        new MinhaThread("t-2").start();
    }
}
```

#### 3) Callable + Future (retorno e exceção)
```java
import java.util.concurrent.*;

public class Ex3 {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> f = es.submit(() -> {
            Thread.sleep(300);
            return 7 * 6;
        });
        System.out.println("Resultado: " + f.get()); // bloqueia até completar
        es.shutdown();
    }
}
```

#### 4) Thread pool (ExecutorService) para várias tarefas
```java
import java.util.concurrent.*;

public class Ex4 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 8; i++) {
            final int id = i;
            pool.submit(() -> {
                System.out.println("Tarefa " + id + " em " + Thread.currentThread().getName());
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
            });
        }
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }
}
```

#### 5) Protegendo estado compartilhado: synchronized vs AtomicInteger
```java
// synchronized
class CounterSync {
    private int c = 0;
    public synchronized void inc() { c++; }
    public synchronized int get() { return c; }
}

// Atomic
import java.util.concurrent.atomic.AtomicInteger;
class CounterAtomic {
    private final AtomicInteger c = new AtomicInteger();
    public void inc() { c.incrementAndGet(); }
    public int get() { return c.get(); }
}

public class Ex5 {
    public static void main(String[] args) throws InterruptedException {
        final CounterAtomic counter = new CounterAtomic();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) counter.inc();
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Total: " + counter.get()); // espera 10000
    }
}
```

#### 6) CompletableFuture (programação assíncrona)
```java
import java.util.concurrent.*;

public class Ex6 {
    public static void main(String[] args) {
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> soma = a.thenCombine(b, Integer::sum);
        soma.thenAccept(r -> System.out.println("Soma: " + r)).join();
    }
}
```

Observações rápidas:
- Prefira ExecutorService em vez de criar Threads manualmente.
- Use estruturas atômicas (Atomic*) ou sincronização para estado compartilhado.
- CompletableFuture facilita composição assíncrona sem bloquear.
- Teste e meça antes de introduzir concorrência para otimização.


### Streams + Threads — exemplos e dicas

Abaixo há exemplos práticos de como usar Streams em cenários concorrentes/paralelos em Java, com observações sobre segurança de threads e alternativas.

### 1) parallelStream — simples e ordenação
```java
List<Integer> nums = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());

// Saída possivelmente não ordenada (execução em paralelo)
nums.parallelStream()
    .map(n -> n * n)
    .forEach(System.out::println);

// Saída ordenada mesmo em paralelo
nums.parallelStream()
    .map(n -> n * n)
    .forEachOrdered(System.out::println);
```

### 2) Usar um ForkJoinPool próprio (evitar o common pool)
```java
ForkJoinPool pool = new ForkJoinPool(4);
List<Integer> resultado = pool.submit(() ->
    nums.parallelStream()
        .map(n -> n * n)
        .collect(Collectors.toList())
).join();
pool.shutdown();
```

### 3) Coletores concorrentes (thread-safe e escaláveis)
```java
List<String> palavras = List.of("java","js","python","c","kotlin","go");

// agrupamento concorrente
ConcurrentMap<Integer, List<String>> porTamanho =
    palavras.parallelStream()
            .collect(Collectors.groupingByConcurrent(String::length, Collectors.toList()));

// mapa concorrente
ConcurrentMap<String, Long> contagem =
    palavras.parallelStream()
            .collect(Collectors.groupingByConcurrent(s -> s.substring(0,1), Collectors.counting()));
```

### 4) Submeter tarefas via Stream para um ExecutorService
```java
ExecutorService es = Executors.newFixedThreadPool(4);
List<Future<Integer>> futures = IntStream.rangeClosed(1, 8)
    .mapToObj(i -> es.submit(() -> { Thread.sleep(100); return i * i; }))
    .collect(Collectors.toList());

for (Future<Integer> f : futures) {
    System.out.println(f.get());
}
es.shutdown();
```

### 5) Integrar Stream com CompletableFuture (composição assíncrona)
```java
List<CompletableFuture<Integer>> futs = IntStream.rangeClosed(1, 5)
    .mapToObj(i -> CompletableFuture.supplyAsync(() -> i * 2))
    .collect(Collectors.toList());

// aguardar e coletar resultados
List<Integer> resultados = futs.stream()
    .map(CompletableFuture::join)
    .collect(Collectors.toList());
```

### 6) Cuidado com efeitos colaterais (exemplo errado vs correto)
Errado — adicionando numa ArrayList não thread-safe em paralelo:
```java
List<Integer> out = new ArrayList<>();
nums.parallelStream().forEach(out::add); // Risco de race condition
```
Correto — usar collectors ou coleção concorrente:
```java
List<Integer> safe = nums.parallelStream().collect(Collectors.toList());
// ou
ConcurrentLinkedQueue<Integer> q = nums.parallelStream()
    .collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
```

Observações rápidas:
- Prefira operações intermediárias stateless e sem efeitos colaterais.
- Use collectors concorrentes (groupingByConcurrent, toConcurrentMap) ou coleções thread-safe ao acumular em paralelismo.
- Quando precisar controlar o pool, use ForkJoinPool em vez do common pool.
- Meça e teste — paralelismo nem sempre traz ganho, principalmente para pequenas coleções ou quando há IO/contenda de recursos.
- Para composição assíncrona, combine Streams com CompletableFuture para evitar bloqueios.
