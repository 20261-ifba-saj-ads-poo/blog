# Tarefas: Reorganização da Aula de Generics

## 1. Reorganização dos Arquivos de Código Java
- [x] 1.1 Criar a estrutura de pastas em `src/posts/code/generics/`: `01_problema/`, `02_generics_basico/`, `03_bounded_types/`, `04_avancado/`.
- [x] 1.2 Mover e ajustar os códigos da Fase 1 (sem generics: `Veiculo`, `Motor`, `MotorCombustao`, `MotorEletrico`, `ExemploObject`, `tiposIncompativeis`).
- [x] 1.3 Mover e ajustar os códigos da Fase 2 (generics básico: `ExemploGenerics`, `Caixa`, `GenericsTest`, `GenericsTest2` corrigido).
- [x] 1.4 Mover e ajustar os códigos da Fase 3 (bounded types: `Veiculo<T extends Motor>`, `Carro`, `Moto`, `Caminhao`, `Pop`, `Geladeira`).
- [x] 1.5 Corrigir `CalculadoraArea.java` e `TestaCalculadoraArea.java`.
- [x] 1.6 Criar novos exemplos para a Fase 4 (`MetodosGenericosExemplo.java` e `WildcardPECSExemplo.java`).

## 2. Reestruturação do Post Markdown (`src/posts/20_generics.md`)
- [x] 2.1 Atualizar o frontmatter e introdução com o problema da Tipificação Forte e uso de `Object`.
- [x] 2.2 Reescrever a seção 1 apresentando o modelo `Veiculo` & `Motor` sem generics e a necessidade de cast em `carro.getMotor()`.
- [x] 2.3 Reescrever a seção 2 apresentando Generics simples (`Veiculo<T>`) e a eliminação do cast no retorno de `getMotor()`.
- [x] 2.4 Reescrever a seção 3 apresentando Bounded Types (`T extends Motor`), o contra-exemplo da `Geladeira` e o exemplo corrigido da `CalculadoraArea`.
- [x] 2.5 Criar a seção 4 contendo Métodos Genéricos, Wildcards/PECS e Type Erasure.
- [x] 2.6 Atualizar todos os links `@[code](...)` para apontar para a nova estrutura de pastas.
- [x] 2.7 Revisar e testar a renderização dos diagramas PlantUML.
