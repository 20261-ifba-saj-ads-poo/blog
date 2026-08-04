# Design: Reorganização Didática da Aula de Generics

## Visão Geral da Arquitetura Pedagógica

A aula será reestruturada em 4 seções principais com fluxo contínuo de problema-solução:

```
[1. Tipificação Forte & Problemas]
   ├── Tipificação Forte (tiposIncompativeis.java)
   ├── Risco de Cast com Object (ExemploObject.java)
   └── Herança Tradicional sem Generics (Veiculo & Motor sem Generics -> obriga Cast)
            │
            ▼
[2. Solução com Generics Simples]
   ├── Parametrização em Coleções (List<T>, ExemploGenerics.java)
   ├── Tabela Comparativa (Object vs Generics)
   ├── Classes Genéricas Básicas (Caixa<T>, GenericsTest<T, U>)
   └── Aplicação no Domínio: Veiculo<T> -> getMotor() retorna T sem cast
            │
            ▼
[3. Tipos Delimitados (Bounded Types)]
   ├── O Risco do Generics Sem Limite (Veiculo<Geladeira> / Pop<Integer>)
   ├── Restrição com Bounded Type: Veiculo<T extends Motor>
   └── Exemplo com Interface Corrigido: CalculadoraArea<T extends FormaGeometrica>
            │
            ▼
[4. Tópicos Avançados]
   ├── Métodos Genéricos (<T> void processar(T item))
   ├── Wildcards / Coringas (?, ? extends T, ? super T) & PECS
   └── Type Erasure (Apagamento de Tipos) e Limitações do Java
```

## Correções de Código Especificadas

### 1. `CalculadoraArea.java` e `TestaCalculadoraArea.java`
- **Problema**: `TestaCalculadoraArea` invoca `new CalculadoraArea<>(circulo)`, mas `CalculadoraArea` possui apenas construtor sem parâmetros.
- **Solução**: Adicionar o construtor sobrecarregado ou ajustar a inicialização no teste:
  ```java
  public class CalculadoraArea<T extends FormaGeometrica> {
      private List<T> formas;

      public CalculadoraArea() {
          this.formas = new ArrayList<>();
      }

      public CalculadoraArea(T formaInicial) {
          this();
          this.formas.add(formaInicial);
      }
      // ...
  }
  ```

### 2. Nomes de Classe Duplicados em `GenericsTest2.java`
- **Problema**: O arquivo `GenericsTest2.java` continha `public class GenericsTest` duplicando a classe de `GenericsTest.java`.
- **Solução**: Renomear para `public class GenericsTest2`.

### 3. Exemplo de Erro de Domínio (`Geladeira.java`)
- **Novo Arquivo**: Criar `Geladeira.java` como exemplo didático de um tipo que NÃO herda de `Motor`, demonstrando a falha de compilação quando aplicado em `Veiculo<T extends Motor>`.

### 4. Reorganização das Pastas de Código
Estrutura física final em `src/posts/code/generics/`:

```
src/posts/code/generics/
├── 01_problema/
│   ├── tiposIncompativeis.java
│   ├── ExemploObject.java
│   ├── Veiculo.java
│   ├── Motor.java
│   ├── MotorCombustao.java
│   └── MotorEletrico.java
├── 02_generics_basico/
│   ├── ExemploGenerics.java
│   ├── Caixa.java
│   ├── GenericsTest.java
│   ├── GenericsTest2.java
│   └── Veiculo.java (Veiculo<T>)
├── 03_bounded_types/
│   ├── Veiculo.java (Veiculo<T extends Motor>)
│   ├── Carro.java
│   ├── Moto.java
│   ├── Caminhao.java
│   ├── Geladeira.java
│   ├── Pop.java
│   ├── FormaGeometrica.java
│   ├── Circulo.java
│   ├── Retangulo.java
│   ├── CalculadoraArea.java
│   └── TestaCalculadoraArea.java
└── 04_avancado/
    ├── MetodosGenericosExemplo.java
    └── WildcardPECSExemplo.java
```

## Ajuste de Links no Markdown (`20_generics.md`)
Atualizar todas as diretivas `@[code](...)` para apontar para as novas subpastas organizadas, corrigindo o erro onde a seção de generics importava os arquivos não-genéricos antigos.
