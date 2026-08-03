---
icon: edit
date: 2025-06-02 19:30:00.00 -3
tag:
  - heranca
category:
  - aula
order: 14
draft
---
# Tipificação Forte


## Wrapper Class

A classe Wrapper converterá tipos de dados primitivos em objetos. Os objetos são necessários se desejarmos modificar os argumentos passados para o método (passagem por referência, já que  os tipos primitivos são passados por valor).

- As classes no pacote `java.util` lidam apenas com objetos e, portanto, as classes wrapper também ajudam neste caso.
- As estruturas de dados na _Collection framework_, como `ArrayList` e `Vector`, armazenam apenas os objetos (tipos de referência) e não os tipos primitivos.
- O objeto é necessário para suportar a sincronização no multithreading.

### Implementação da classe Wrapper em Java

```java
public class AutoBoxingTest {
   public static void main(String args[]) {
      int num = 10; // int primitive
      Integer obj = Integer.valueOf(num); // creating a wrapper class object
      System.out.println(num + " " + obj);
   }
}
```


## Generics

Generics é uma funcionalidade incorporada ao Java a partir da versão 5.0 que permite aos programadores escreverem métodos genéricos (mais independentes dos tipos) fazendo com que os parâmetros dos métodos, as variáveis locais e o tipo de retorno possam ser definidos na chamada do método. Com generics é possível o método ser invocado usando tipos distintos (sem precisar sobrescrevê-lo).

**Generics** em Java oferece os mesmos recursos dos **Templates** em C++

Métodos e classes genéricos só podem ser definidos apenas para tipos referenciáveis, ou seja, não podem ser definidos para tipos primitivos (byte, short, int, long, float, double, boolean, char). Essa limitação é contornada usando-se as classes empacotadoras (Wrapper class) de tipo, que são uma alternativa oferecida por Java para tratar tipos primitivos como referenciáveis de forma transparente (Byte, Short, Integer, Long, Float, Double, Boolean, Character)


## Exemplo Generics

<<< src/06_Generics/code/GenericsTest.java

Saída:

```shell
Value of the item: Test String.
Type of the item: java.lang.String
Value of the item: 100
Type of the item: java.lang.Integer
```

Exemplo de classe com Generics com dois parâmetros:

```java
class Test<T, U> {
  private T itemT;
  private U itemU;

  public Test(T itemT, U itemU){
      this.itemT = itemT;
      this.itemU = itemU;
  }

  public T getItemT() {
    return itemT;
  }

  public void setItemT(T itemT) {
      this.itemT = itemT;
  }

  public U getItemU() {
      return itemU;
  }

  public void setItemU(U itemU) {
      this.itemU = itemU;
  }

  public void showItemDetails(){
      System.out.println("Value of the itemT: " + itemT);
      System.out.println("Type of the itemT: " + itemT.getClass().getName());
      System.out.println("Value of the itemU: " + itemU);
      System.out.println("Type of the itemU: " + itemU.getClass().getName());
  }
}

public class GenericsTest {
    public static void main(String args[]){
        //String type test
        Test<String, Integer> test =
          new Test<String, Integer>("Test String.", 100);
        test.showItemDetails();
    }
}
```

Saída

```shell
Value of the itemT: Test String.
Type of the itemT: java.lang.String
Value of the itemU: 100
Type of the itemU: java.lang.Integer
```

## Type Erasure

A maneira de tornar genéricos viáveis no java é realizar o "apagamento de tipo" (type erasure) durante o processo de compilação:

- Substitui todos os parâmetros de tipo genérico por `Object` se os parâmetros do tipo não forem limitados. O bytecode produzido, portanto, contém apenas classes, interfaces e métodos comuns.
- Insere a conversão de tipo (Type Cast), se necessário, para preservar a tipificação forte.
- Gera métodos de ponte (bridge methods) para preservar o polimorfismo em tipos genéricos estendidos.


Como o tipo de apagamento funciona na compilação do programa?

```java
class GFG<T> {
    T obj;
    GFG(T o){
        obj = o;
    }
    T getob(){
        return obj;
    }
}
```

Após a compilação, o código `T` é substituído por `Object` como o abaixo:

```java
class GFG {
    Object obj;
    GFG(Object o){
        obj = o;
    }
    Object getob(){
        return obj;
    }
}
```

Quando o hierarquia do tipo genérico é especificada:

```java
class Geeks<T extends String> {
    T str;
    Geeks(T o){
        str = o;
    }
    T getob(){
        return str;
    }
}
```

Compila para:

```java
class Geeks{
   String str;
    Geeks(String o){
        str=o;
    }
    String getob(){
        return str;
    }
}
```



### Links

- https://blog.cod3r.com.br/generics-em-java-o-que-e-e-exemplos/
- https://dev.java/learn/type-erasure/
- https://docs.oracle.com/javase/tutorial/java/generics/erasure.html
- https://homepages.dcc.ufmg.br/~fsantos/ECO030/generics.pdf
- https://www.devmedia.com.br/java-generics-trabalhando-com-metodos/30911
- https://www.devmedia.com.br/usando-generics-em-java/28981
- https://www.geeksforgeeks.org/type-erasure-java/
- https://www.tutorialspoint.com/why-do-we-need-a-wrapper-class-in-java
- https://www.w3schools.blog/generics-class-java
