---
icon: dumbbell
date: 2025-08-25 19:00:00.00 -3
tag:
  - exception
category:
  - exercicio
  - entrega
---

# Exercícios sobre Exception (IllegalArgumentException, SaldoInsufucienteException)

Considerando o exercicio [Modelagem Sistema Banco](./15_exercicio_Polimorfismo1.md)

1. Na classe `Operacao`, modifique o construtor para ele lançar uma exception chamada `IllegalArgumentException` caso o valor da operação seja negativo. A `IllegalArgumentException` é uma exception  que já faz parte da biblioteca do Java.
    1. Adicione o try/catch para tratar o erro
    2. Ao lançar a `IllegalArgumentException`, passe via construtor uma mensagem a ser exibida. Lembre que a String recebida como parâmetro é acessível depois via o método getMessage() herdado por todas as Exceptions
2. Modificar o sistema de controle de contas correntes para lançar uma exceção de `SaldoInsufucienteException` caso o valor de saque seja maior que o saldo disponível
