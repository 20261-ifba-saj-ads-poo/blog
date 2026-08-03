```java
class MeuPrograma {
    void main() { // main method sem argumentos e sem public static
        IO.println("Hello from Java 24!");
    }
}
```

<codapi-snippet sandbox="java" editor="basic"></codapi-snippet>

### Pattern Matching para switch e instanceof (Continuação do Preview)

Recursos de Pattern Matching continuam a ser refinados para switch e instanceof, simplificando o código condicional.

```java
Object obj = "Hello Java 24";

// Exemplo com switch
String resultadoSwitch = switch (obj) {
    case String s -> "É uma String: " + s;
    case Integer i -> "É um Integer: " + i;
    default -> "Outro tipo";
};
System.out.println(resultadoSwitch);

// Exemplo com instanceof
if (obj instanceof String s) {
    System.out.println("Usando instanceof: " + s);
}
```

### Structured Concurrency (Segundo Preview)

Continua o trabalho para simplificar a programação multithread, tratando grupos de tarefas relacionadas como uma única unidade de trabalho.

```java
import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;

// Exemplo conceitual (pode requerer configurações adicionais ou APIs específicas)
// Este código é simplificado para ilustração.
/*
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Future<String> task1 = scope.fork(() -> {
        // Simula uma tarefa
        Thread.sleep(100);
        return "Resultado da Tarefa 1";
    });

    Future<String> task2 = scope.fork(() -> {
        // Simula outra tarefa
        Thread.sleep(200);
        return "Resultado da Tarefa 2";
    });

    scope.join();      // Espera por todas as tarefas
    scope.throwIfFailure(); // Lança exceção se alguma falhou

    // Processa resultados
    System.out.println(task1.resultNow());
    System.out.println(task2.resultNow());

} catch (Exception e) {
    System.err.println("Uma tarefa falhou: " + e.getMessage());
}
*/
```