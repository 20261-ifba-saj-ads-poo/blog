---
icon: edit
date: 2025-03-26 18:30:00.00 -3
tag:
  - threads
category:
  - aula
order: 22
---


# Processamento assíncrono

## Future e FutureTask

[^DEVMEDIA_ASSYNC]

Além da classe `Thread` e a interface `Runnable` para a programação de eventos assíncronos, o java adicionou as classes `FutureTaks`, `Future` e `Callable`, que tem mais ou menos a mesma função das anteriores, mas facilitam bastante o desenvolvimento de aplicações paralelas.

- **Future**: Classe que encapsula uma chamada feita em paralelo, sendo possível cancelar a execução de uma tarefa, descobrir se a execução já terminou com sucesso ou erro, entre outras operações;
- **FutureTask**: É uma implementação da interface Future a ser executada numa chamada em paralelo. Além disso, com ela é possível fazer as mesmas verificações que fazemos com a interface;
- **Callable**: Interface para a implementação de uma execução em paralelo. É muito parecida com a interface Runnable, mas esta não retorna nenhum valor, enquanto a Callable deve retornar um valor ao final da execução;
- **ExecutorService**: Classe para o gerenciamento de execuções em paralelo, já que cria um pool de threads, iniciando e cancelando as execuções. Também é possível cancelar este, evitando assim a criação de novas tarefas.

Imagine como implementar uma tarefa em paralelo que apenas gera números aleatórios. Isso foi feito na classe `GerarNumeroAleatorio` com a interface `Callable`. O método que deve ser implementado é o `call()` da interface, que ao final da execução retorna o valor gerado.

No `main` é criado um pool de threads e uma tarefa utilizando a classe `GerarNumeroAleatorio` na variável task. Assim, esse processo é enviado para o pool com o método `submit()` e nessa submissão é retornado um objeto do tipo `Future`. Com ele espera-se a execução terminar no `while`, que fica verificando se a thread terminou de executar com o método `isDone()`(isso acontecerá quando for retornado `true`). Então o valor aleatório gerado é retornado. Por fim, o valor retornado é impresso no console e o pool de threads é finalizado com o método `shutdown()`.

@[code](./code/assincrono/Exemplo1Print.java)

<codapi-snippet sandbox="java" editor="basic"></codapi-snippet>

Um exemplo um pouco maior, onde é calculado o fatorial de um número em uma tarefa que será executada em paralelo.

A tarefa é criada na variável `task` e é enviada para a execução paralela com o método `submit()`. Ao terminar é retornado o valor calculado que é impresso na tela.

A classe `Fatorial` é uma implementação da interface `Callable` e, por isso, implementa o método `call()`, que tem por objetivo calcular o fatorial do número passado como parâmetro. Para isso, é feito um comando while que vai multiplicando o valor já calculado por um número e subtraindo 1 deste até que ele chegue em 1.

@[code](./code/assincrono/Exemplo1.java)
<codapi-snippet sandbox="java" editor="basic"></codapi-snippet>



exemplo `GerarNumeroAleatorio` com 3 tarefas


@[code](./code/assincrono/Exemplo1Soma.java)
<codapi-snippet sandbox="java" editor="basic"></codapi-snippet>


Agora vamos implementar um exemplo um pouco maior. No código abaixo é mostrado um servidor simples que recebe conexões na porta 8000. Ele é iniciado com uma thread onde é criada uma nova tarefa com o método execute. Esta é implementada com a classe `VerificaRequisicao`, que de 10 em 10 segundos verifica o status de todas as conexões feitas com o servidor, isto é, se ela foi cancela ou se foi terminada com sucesso.

Além disso, é necessário tratar a requisição de cada usuário e para isso foi implementado um processo bem simples, onde o servidor recebe uma mensagem do cliente e a responde com outra mensagem. Para isto utilizamos a classe `TrataRequisicao`, que recebe como parâmetro um `Socket` aberto com o cliente que fez a requisição. Foi colocado um `Thread.sleep` de cinco segundos na `Thread` que fica analisando as requisições que ainda não terminaram.

@[code](./code/assincrono/Servidor.java)


Apenas para verificar o funcionamento do servidor foi implementado um cliente bem simples. A conexão é feita no endereço localhost da porta 8000. Depois de conectado, o cliente envia uma mensagem para o servidor e fica esperando a resposta.


@[code](./code/assincrono/Cliente.java)


# Links w3schools

<ul>
    <li><a href="https://www.w3schools.blog/thread-life-cycle-in-java">Thread life cycle</a></li>
    <li><a href="https://www.w3schools.blog/way-of-creating-thread-in-java">Way of creating thread</a></li>
    <li><a href="https://www.w3schools.blog/better-way-to-create-a-thread-in-java">Which is a better way to create a
            thread?</a></li>
    <li><a href="https://www.w3schools.blog/methods-of-thread-class">Methods of Thread class</a></li>
    <li><a href="https://www.w3schools.blog/thread-start-vs-run-method">Difference between thread start and run
            method</a></li>
    <li><a href="https://www.w3schools.blog/why-we-call-start-method-in-thread">Why we call start method in thread?</a>
    </li>
    <li><a href="https://www.w3schools.blog/override-start-method-in-thread">Can we override start method?</a></li>
    <li><a href="https://www.w3schools.blog/override-run-method-in-thread">Can we override run method?</a></li>
    <li><a href="https://www.w3schools.blog/start-a-thread-twice">Is it possible to start a thread twice?</a></li>
    <li><a href="https://www.w3schools.blog/thread-scheduling-in-java">Thread scheduling</a></li>
    <li><a href="https://www.w3schools.blog/thread-priority-in-java">Thread priority</a></li>
    <li><a href="https://www.w3schools.blog/naming-a-thread-in-java">Naming a thread</a></li>
    <li><a href="https://www.w3schools.blog/joining-a-thread-in-java">What is join method?</a></li>
    <li><a href="https://www.w3schools.blog/daemon-thread-in-java">Daemon thread</a></li>
    <li><a href="https://www.w3schools.blog/call-run-method-directly">Can we call run method directly?</a></li>
    <li><a href="https://www.w3schools.blog/yield-sleep-thread-methods">What is the difference between sleep and yield
            method?</a></li>
    <li><a href="https://www.w3schools.blog/deadlock-in-java">Deadlock</a></li>
    <li><a href="https://www.w3schools.blog/starvation-in-java">Starvation</a></li>
    <li><a href="https://www.w3schools.blog/inter-thread-communication-in-java">Inter-thread communication</a></li>
    <li><a href="https://www.w3schools.blog/synchronization-in-java">Synchronization</a></li>
    <li><a href="https://www.w3schools.blog/synchronized-method-in-java">Synchronized method</a></li>
    <li><a href="https://www.w3schools.blog/static-synchronization-in-java">Static synchronization</a></li>
    <li><a href="https://www.w3schools.blog/synchronized-block-in-java">Synchronized block</a></li>
</ul>

<!-- @include: ../../includes/bib.md -->
