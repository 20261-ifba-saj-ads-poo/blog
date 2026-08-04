# Proposal: Reorganização Didática da Aula de Generics e Correção de Exemplos

## Contexto
A aula `src/posts/20_generics.md` introduz os conceitos de Tipificação Forte e Generics em Java. No entanto, uma análise detalhada revelou inconsistências pedagógicas, erros de referência a arquivos de código (links apontando para classes não-genéricas em seções genéricas), exemplos com erros de compilação Java (como `CalculadoraArea`), nomes de classes duplicados e ausência de tópicos fundamentais do Java Generics (Métodos Genéricos, Wildcards/PECS e Type Erasure).

## Objetivos
1. **Narrativa Unificada**: Reorganizar o post `src/posts/20_generics.md` em torno de uma narrativa central contínua baseada no domínio `Veiculo` e `Motor`.
2. **Correção de Códigos**:
   - Corrigir referências incorretas de arquivos no post (seção de Herança com Generics).
   - Corrigir o erro de compilação entre `CalculadoraArea.java` e `TestaCalculadoraArea.java`.
   - Corrigir o nome da classe em `GenericsTest2.java` para evitar duplicidade no pacote padrão.
   - Reestruturar os arquivos em `src/posts/code/generics/` em subpastas didáticas numeradas.
3. **Expansão de Conteúdo**:
   - Incluir Métodos Genéricos (`<T> void metodo(...)`).
   - Incluir Coringas/Wildcards (`?`, `? extends T`, `? super T`) e o princípio PECS (Producer Extends, Consumer Super).
   - Incluir explicação sobre *Type Erasure* (Apagamento de Tipos) e as limitações do Java Generics em tempo de execução.

## Escopo das Mudanças

### Arquivos de Documentação
- `src/posts/20_generics.md`: Reestruturação completa do conteúdo, atualização dos links `@[code]`, correção de diagramas PlantUML e adição de novos tópicos.

### Arquivos de Código Java (`src/posts/code/generics/`)
- Reorganização em subpastas:
  - `01_problema/` (tiposIncompativeis, ExemploObject, Veiculo, Motor, MotorCombustao, MotorEletrico)
  - `02_generics_basico/` (ExemploGenerics, Caixa, GenericsTest, GenericsTest2)
  - `03_bounded_types/` (Veiculo<T extends Motor>, Carro, Moto, Caminhao, Geladeira, FormaGeometrica, Circulo, Retangulo, CalculadoraArea, TestaCalculadoraArea)
  - `04_avancado/` (MetodosGenericosExemplo, WildcardPECSExemplo)

## Fora de Escopo (Non-goals)
- Modificação do exercício `21_Parcial2_generics.md` ou dos códigos de `parcialTrab/` (mantidos intactos).
- Alteração da infraestrutura do site/blog (VuePress).
