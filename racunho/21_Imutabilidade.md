---
icon: 'immutable'
date: '2026-03-23 17:40:11.00 -3'
tag:
  - java
  - immutability
category:
  - aula
order: 21
---

# Imutabilidade em Java com Recursos Recentes

A imutabilidade é um conceito fundamental em programação que traz diversos benefícios, especialmente em sistemas complexos e concorrentes. Em Java, podemos alcançar a imutabilidade de diversas formas, e as versões mais recentes da linguagem oferecem recursos que a tornam mais fácil e expressiva.

## O que é Imutabilidade?

Um objeto é considerado **imutável** se seu estado não pode ser alterado após sua criação. Uma vez que um objeto imutável é instanciado, seus valores permanecem constantes durante todo o seu ciclo de vida.

## Por que Imutabilidade?

1.  **Segurança em Concorrência (Thread-Safety):** Objetos imutáveis são inerentemente thread-safe. Como seu estado não pode ser alterado após a criação, múltiplas threads podem acessar o mesmo objeto simultaneamente sem o risco de race conditions ou corrupção de dados. Isso simplifica dramaticamente o desenvolvimento de aplicações concorrentes, eliminando a necessidade de complexos mecanismos de bloqueio ou sincronização.
2.  **Previsibilidade e Raciocínio:** Código com objetos imutáveis é mais fácil de entender e depurar. Você pode ter certeza de que um objeto imutável não será modificado inesperadamente em outra parte do sistema.
3.  **Simplicidade de Teste:** Testar classes imutáveis é mais simples, pois você não precisa se preocupar com efeitos colaterais de mutações.
4.  **Imutabilidade como Base:** Objetos imutáveis podem ser usados como chaves em `HashMap` ou elementos em `HashSet` sem preocupações, pois seu `hashCode` e `equals` (baseados no estado) permanecerão consistentes.
5.  **Caching:** O estado de um objeto imutável pode ser facilmente cacheado, pois ele nunca mudará.

## Como Criar Objetos Imutáveis Tradicionalmente

Para tornar uma classe imutável em Java, siga estas diretrizes:

1.  **Declare a Classe como `final`:** Impede que a classe seja estendida, o que poderia introduzir mutabilidade em subclasses.
2.  **Torne todos os campos `final`:** Garante que os campos sejam inicializados apenas uma vez (no construtor).
3.  **Não forneça métodos "setters":** Métodos que modificam o estado do objeto.
4.  **Não retorne referências mutáveis:** Se um campo for de um tipo mutável (como `Date` ou um array), retorne cópias defensivas (clones) ou novos objetos em métodos getter.
5.  **Crie cópias defensivas para campos mutáveis:** Ao construir um objeto imutável que contém um objeto mutável, crie uma cópia profunda do objeto mutável passado para o construtor.

### Exemplo Tradicional

```java
import java.util.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 1. Classe final
public final class Pessoa {
    // 2. Campos final
    private final String nome;
    private final Date dataNascimento; // Tipo mutável!
    private final Map<String, String> propriedades; // Tipo mutável!

    public Pessoa(String nome, Date dataNascimento, Map<String, String> propriedades) {
        this.nome = nome;
        // 4 & 5. Cópia defensiva para tipos mutáveis
        this.dataNascimento = new Date(dataNascimento.getTime()); // Cópia da data
        this.propriedades = new HashMap<>(propriedades); // Cópia do mapa
    }

    public String getNome() {
        return nome; // String é imutável, retorno direto é seguro
    }

    public Date getDataNascimento() {
        // 4 & 5. Retorna cópia defensiva
        return new Date(dataNascimento.getTime());
    }

    public Map<String, String> getPropriedades() {
        // 4 & 5. Retorna cópia defensiva do mapa
        return Collections.unmodifiableMap(new HashMap<>(propriedades));
    }

    // 3. Sem setters
    // Métodos que criam *novos* objetos imutáveis em vez de modificar o existente
    public Pessoa comNovoNome(String novoNome) {
        return new Pessoa(novoNome, this.dataNascimento, this.propriedades);
    }

    // Exemplo de como usar (simulando um novo objeto em vez de mutar)
    public static void main(String[] args) {
        Map<String, String> propsIniciais = new HashMap<>();
        propsIniciais.put("corFav", "azul");

        Pessoa pessoaOriginal = new Pessoa("Alice", new Date(), propsIniciais);

        // Criando um novo objeto pessoa com nome diferente
        Pessoa pessoaComNovoNome = pessoaOriginal.comNovoNome("Bob");

        System.out.println("Original: " + pessoaOriginal.getNome()); // Alice
        System.out.println("Novo: " + pessoaComNovoNome.getNome());   // Bob

        // Tentativa de modificar a data após a criação (não afeta o original)
        pessoaOriginal.getDataNascimento().setTime(System.currentTimeMillis() + 86400000); // Um dia depois
        System.out.println("Data original alterada? " + pessoaOriginal.getDataNascimento()); // Mostra a data original

        // Tentativa de modificar propriedades via getter (não funciona se usar unmodifiableMap)
        try {
             pessoaOriginal.getPropriedades().put("hobby", "leitura");
        } catch (UnsupportedOperationException e) {
            System.out.println("Não foi possível modificar as propriedades via getter.");
        }
    }
}
```

## Imutabilidade com Recursos Modernos do Java (a partir do Java 9 e 14+)

As versões mais recentes do Java introduziram recursos que simplificam drasticamente a criação de objetos imutáveis.

### 1. Registros (`records`) - Java 14+

Os `records` são uma forma concisa de declarar classes que representam dados imutáveis. Por padrão, um `record` é imutável:

*   Os campos são automaticamente `public`, `final` e privados.
*   Um construtor que inicializa todos os campos é gerado.
*   Métodos `equals()`, `hashCode()` e `toString()` são gerados com base nos campos.
*   **Importante:** Campos em um `record` não podem ser modificados após a inicialização.

#### Exemplo com `record`

```java
import java.util.Date;
import java.util.Map;

// Um record é imutável por design
public record PessoaRecord(String nome, Date dataNascimento, Map<String, String> propriedades) {

    // Construtor compacto para validação e cópia defensiva (se necessário)
    // Note que Date e Map ainda são mutáveis internamente, então precisamos de cuidado.
    public PessoaRecord {
        // Validação (semelhante ao construtor tradicional)
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        }
        // Cópia defensiva para campos mutáveis
        // Criamos novas instâncias para garantir a imutabilidade externa.
        dataNascimento = new Date(dataNascimento.getTime());
        propriedades = Map.copyOf(propriedades); // Cria um Map imutável a partir do fornecido
    }

    // Para tornar o Date *realmente* imutável dentro do record,
    // você precisaria usar uma representação imutável ou uma cópia defensiva no getter.
    // No entanto, a forma acima já é a mais idiomática para records.
    // Se `dataNascimento` fosse `Instant` ou `LocalDate`, seria imutável por si só.

    // Métodos "mutadores" que na verdade retornam um *novo* record
    public PessoaRecord comNovoNome(String novoNome) {
        // Retorna uma nova instância com o nome alterado, mas mantém os outros campos
        return new PessoaRecord(novoNome, this.dataNascimento, this.propriedades);
    }

    public static void main(String[] args) {
        Map<String, String> propsIniciais = Map.of("corFav", "verde"); // Map.of cria um Map imutável

        // Note que Date ainda é mutável, então mesmo passando um Date imutável,
        // o construtor do record o copia defensivamente.
        PessoaRecord pessoaRecordOriginal = new PessoaRecord("Charlie", new Date(), propsIniciais);

        System.out.println("Original: " + pessoaRecordOriginal.nome()); // Charlie

        // Criando um novo record com nome diferente
        PessoaRecord pessoaRecordComNovoNome = pessoaRecordOriginal.comNovoNome("David");

        System.out.println("Original nome: " + pessoaRecordOriginal.nome()); // Charlie
        System.out.println("Novo nome: " + pessoaRecordComNovoNome.nome());   // David

        // O record em si é imutável, mas o objeto Date interno pode ser mutado *se não for copiado*.
        // No nosso construtor, nós copiamos, então a mutação externa do Date original não afetará o record.
        // Mas se passássemos um Date mutável para o construtor, e ele não fizesse a cópia, seria um problema.
        // A melhor prática é usar tipos imutáveis como LocalDate, Instant, String, etc., sempre que possível.
    }
}
```

### 2. Coleções Imutáveis (Java 9+)

As coleções de fábrica introduzidas no Java 9 (`List.of()`, `Set.of()`, `Map.of()`) criam coleções imutáveis. Tentar modificar essas coleções após a criação lançará uma `UnsupportedOperationException`.

#### Exemplo com Coleções Imutáveis

```java
import java.util.List;
import java.util.Set;
import java.util.Map;

public class ExemploColecoesImutaveis {

    public static void main(String[] args) {
        // Criando coleções imutáveis
        List<String> nomesImutavel = List.of("Ana", "Bruno", "Carlos");
        Set<Integer> idsImutavel = Set.of(101, 102, 103);
        Map<String, Integer> pontuacoesImutavel = Map.of("Alice", 95, "Bob", 88, "Charlie", 92);

        System.out.println("Lista Imutável: " + nomesImutavel);
        System.out.println("Set Imutável: " + idsImutavel);
        System.out.println("Map Imutável: " + pontuacoesImutavel);

        // Tentando modificar uma coleção imutável lançará exceção
        try {
            nomesImutavel.add("Diana");
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao tentar adicionar à lista imutável: " + e.getMessage());
        }

        try {
            pontuacoesImutavel.put("David", 75);
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao tentar adicionar ao mapa imutável: " + e.getMessage());
        }
    }
}
```

### 3. `final` para Campos e Variáveis

O modificador `final` continua sendo a base para garantir a imutabilidade em Java. Ele pode ser usado em:

*   **Variáveis de instância:** Uma vez atribuído, não pode ser reatribuído.
*   **Variáveis locais:** Semelhante às variáveis de instância.
*   **Parâmetros de método:** Não podem ser reatribuídos dentro do método.
*   **Métodos:** Impede que subclasses sobrescrevam o método.
*   **Classes:** Impede que classes sejam estendidas (como visto anteriormente).

Usar `final` em todos os campos e parâmetros onde a mutação não é intencional é uma prática excelente para promover a imutabilidade.

## Imutabilidade e Tipos Mutáveis (Date, Arrays, Collections)

É crucial lembrar que, mesmo que sua classe seja `final` e todos os seus campos sejam `final`, se esses campos forem referências a objetos mutáveis (como `java.util.Date`, arrays, ou coleções não imutáveis), o estado *interno* desses objetos ainda poderá ser alterado.

Para garantir a imutabilidade completa em tais casos, você deve:

*   **No construtor:** Sempre crie cópias (defensivas) dos objetos mutáveis passados como argumentos.
*   **Nos métodos getter:** Sempre retorne cópias (defensivas) dos objetos mutáveis.

Alternativamente, prefira usar tipos imutáveis sempre que possível, como `java.time.Instant`, `java.time.LocalDate`, `java.time.LocalDateTime`, ou coleções imutáveis (`List.of`, `Map.of`, etc.).

## Conclusão

A imutabilidade é um pilar para escrever código robusto, seguro e fácil de manter em Java. Com o auxílio de `records`, coleções imutáveis e o uso prudente do `final`, criar objetos imutáveis tornou-se mais direto e expressivo nas versões modernas da linguagem. Adotar a imutabilidade sempre que apropriado é uma prática que recompensa em termos de qualidade e confiabilidade do software.

<!-- @include: ../includes/bib.md -->