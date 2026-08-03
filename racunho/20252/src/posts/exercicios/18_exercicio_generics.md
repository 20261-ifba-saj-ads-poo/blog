---
icon: dumbbell
date: 2026-03-16 19:30:00.00 -3
tag:
  - heranca
  - generics
category:
  - trabalho
  - exercicio
  - entrega
order: 17
---

# Exercício Generics - Trabalho Parcial 2
 
Atualize a sua camada de modelo para utilizar uma definição abstrata.  Essa definição deverá ter características e comportamentos comuns a todos os models do sistema, tais como ter um identificador único, identificação do momento de inserção da informação, momento da ultima atualização, usuário que cadastrou e atualizou, dentre outros.

Inspiração para classe abstrata da camada de modelo:

```java
public abstract class AbstractModel<T> {
    private T id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Getters e Setters
    public T getId() { return id; }
    public void setId(T id) { this.id = id; }
    //...
    
}
```

Todos as classes da camada de modelo devem devem herdar esse modelo abstrato.

Exemplo de subclasse:

```java
public class Usuario extends AbstractModel<UUID> {
    private String nome;
    private String email;
    
    // Construtor, Getters e Setters
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    //...
}
```

Utilize o UUID para chave de identificação.

Defina um conjunto de comportamentos para fazer a inserção (create), consulta por `id` (read), alteração (update) e exclusão (delete) de qualquer classe da camada de modelo. Essas são as operações CRUD.

```java
public interface GenericDAO<T extends AbstractModel<ID>, ID> {
    ID salvar(T entidade);
    void atualizar(T entidade);
    T buscarPorId(ID id);
    void deletar(ID id);
    List<T> buscarTodos();
}
```

defina DAO genérico para atender ao conjunto do operações CRUD.

```java
public class GenericDAOImpl<T extends AbstractModel<ID>, ID> implements GenericDAO<T, ID> {
    private Map<ID, T> bancoDeDados = new HashMap<>();
    private final Class<ID> tipoIdClass; 

    public GenericDAOImpl(Class<ID> tipoIdClass) {
        this.tipoIdClass = tipoIdClass;
    }
    
    @Override
    public ID salvar(T entidade) {
      ID novoId = IdGenerator.gerarNovoId(tipoIdClass);
      entidade.setId(novoId); 
      entidade.setCreatedAt(LocalDateTime.now());
      bancoDeDados.put(entidade.getId(), entidade);
      return novoId;
    }
    
    @Override
    public T buscarPorId(ID id) {
        return bancoDeDados.get(id);
    }
    
    // Outros métodos (atualizar, deletar, ...) seguem lógica similar...
}
```

Criando uma classe filha de DAO genérico para acrescentar funcionalidades específicas para a classe `Usuario`:

```java
class UsuarioDAO extends GenericDAOImpl<Usuario, UUID> {
    public UsuarioDAO() {
        super(UUID.class);
        // Outras configurações específicas para a classe UsuarioDAO
    }
    // Métodos específicos para a classe Usuario
    public List<Usuario> buscarOrdenadosPorNome() {
        return buscarTodos()
                .stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());
    }
}
``` 
## Entregar

Entregar a camada de modelo atualizada bem como a camada de Dados (DAO).



[Entrega](https://classroom.github.com/a/mhsi1Oa4)

