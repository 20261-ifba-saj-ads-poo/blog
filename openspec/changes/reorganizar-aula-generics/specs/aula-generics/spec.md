# Specification: Aula de Generics em Java

## Capabilities

### Reestruturação da Aula de Generics
A aula deve guiar o estudante desde o conceito de tipificação forte em Java até tópicos avançados de Generics, utilizando uma narrativa central baseada no domínio `Veiculo` e `Motor`.

#### Requirement: Estrutura Didática por Problema-Solução
A aula MUST apresentar o conteúdo na seguinte sequência didática:
1. Problema da Tipificação Forte e limitações da herança tradicional sem generics.
2. Solução com Generics básicos (`<T>`) resolvendo a necessidade de casts explícitos.
3. Necessidade de Bounded Types (`T extends Motor`) para preservar regras do domínio.
4. Tópicos avançados (Métodos Genéricos, Wildcards/PECS e Type Erasure).

#### Requirement: Correção dos Exemplos de Código
Todos os exemplos de código incorporados no markdown MUST compilar e executar sem erros:
- `CalculadoraArea` MUST possuir construtor compatível com o código de teste `TestaCalculadoraArea`.
- `GenericsTest2` MUST utilizar um nome de classe único para evitar conflito com `GenericsTest`.
- Todos os caminhos de importação `@[code](...)` em `20_generics.md` MUST apontar para os arquivos corretos.

#### Requirement: Demonstração de Restrição de Domínio
A aula MUST demonstrar visualmente e via código que um tipo não derivado de `Motor` (ex: `Geladeira` ou `Integer`) resulta em erro de compilação quando passado para `Veiculo<T extends Motor>`.
