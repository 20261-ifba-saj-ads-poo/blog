---
icon: edit
date: 2025-03-20 18:30:00.00 -3
tag:
  - optional
  - generics
category:
  - aula
order: 20
---

<!-- falar sobre serealização -->
# Optional 

 
O `Optional` é uma classe que encapsula um valor que pode ser nulo. Ela é uma classe que encapsula um valor que pode ser nulo. Utilizada para se aproximar o java das linguagens de programação _null safe_ (sem valores nulos).

Com o uso do `Optional` o desenvolvedor é obrigado a tratar a possibilidade do valor nulo, evitando que o código quebrar. Utilizando o  `Optional` , sempre um objeto será retornado, mesmo que o valor seja nulo ja que o `Optional` é um wrapper para o valor.

A principal proposta deste recurso é encapsular o retorno de métodos e informar se um valor do tipo `<T>` está presente ou ausente.

Com isso é possível

- Evitar erros `NullPointerException`.
- Parar de fazer verificações de valor nulo do tipo `if (cliente != null)`.
- Escrever código mais limpo e elegante.


## classe Optional

Alguns dos recursos mais utilizados da classe `Optional`



**empty** - Retorna uma instância de Optional vazia.

```java
 Optional<Cliente> cliente = Optional.empty();
```
**of​** - Retorna um Optional com o valor fornecido, mas o valor não pode ser nulo. Se não tiver certeza de que o valor não é nulo use Optional.ofNullable.

```java
Optional<Cliente> cliente = Optional.of(buscaCliente(cpf));
```

**ofNullable​** - Se um valor estiver presente, retorna um Optional com o valor , caso contrário, retorna um Optional vazio. Este é um dos métodos mais indicados para criar um Optional.

```java
Optional<Cliente> retorno = Optional.ofNullable(buscaCliente(cpf));
```

**isPresent** - Retorna true se houver um valor presente, caso contrário, retorna false.


```java
if(retorno.isPresent()){
    System.out.println("Cliente encontrado");
}else{
    System.out.println("Cliente não encontrado");
}
```

**get** - Retorna o valor presente, caso contrário, lança `NoSuchElementException`.

```java
Cliente cliente = retorno.get();
```


**orElse** - Retorna o valor presente, caso contrário, retorna outro valor fornecido.
```java
// Sempre cria um novo Cliente, mesmo se retorno já tiver um valor
Cliente cliente = retorno.orElse(new Cliente());
```

**orElseGet** - Retorna o valor presente, caso contrário, chama o  `Supplier` (função lambda sem parâmetros que retorna um valor) e retorna o valor retornado pelo `Supplier`.
```java
// Só cria um novo Cliente se retorno estiver vazio
Cliente cliente = retorno.orElseGet(()-> new Cliente());
```
**orElseThrow** - Retorna o valor presente, caso contrário, lança uma exceção fornecida.
```java
Cliente cliente = retorno.orElseThrow(()-> new Exception("Cliente não encontrado"));
```
**ifPresent** - Se um valor estiver presente, execute a ação fornecida, caso contrário, não faça nada.
```java
retorno.ifPresent(cliente -> System.out.println("Cliente encontrado: " + cliente.getNome()));
```
**filter** - Se um valor estiver presente e o valor corresponder ao predicado, retorne um Optional desse valor. Caso contrário, retorna um Optional vazio.
```java
Optional<Cliente> retorno = Optional.ofNullable(buscaCliente(cpf));
retorno.filter(cliente -> cliente.getNome().equals("João")).ifPresent(cliente -> System.out.println("Cliente encontrado: " + cliente.getNome()));
```
**map** - Se um valor estiver presente, aplique a função fornecida ao valor, retorne o resultado em um Optional, caso contrário, retorne um Optional vazio.
```java
Optional<String> retorno = Optional.ofNullable(buscaCliente(cpf)).map(cliente -> cliente.getNome());
```
**flatMap** - Se um valor estiver presente, aplique a função fornecida ao valor, retorne o resultado em um Optional, caso contrário, retorne um Optional vazio.
```java
Optional<String> retorno = Optional.ofNullable(
    buscaCliente(cpf)).flatMap(cliente -> Optional.ofNullable(cliente.getNome()));
```




## Exemplo

@[code](./code/optional/ClasseA.java)
@[code](./code/optional/ClasseB.java)
@[code](./code/optional/OptionalTeste.java)

## Outro Exemplo

@[code](./code/optional/CNH.java)
@[code](./code/optional/Cliente.java)
@[code](./code/optional/OptionalTesteCliente.java)


## Exemplo encadeamento

@[code](./code/optional/taxonomia/Especie.java)
@[code](./code/optional/taxonomia/Classe.java)
@[code](./code/optional/taxonomia/Principal.java)



## Referências

- https://medium.com/@racc.costa/optional-no-java-8-e-no-java-9-7c52c4b797f1
- https://www.oracle.com/br/technical-resources/articles/java/optional-java-se-8.html
