
import java.util.Optional;

public class Ordem {
    private String nome;
    private Optional<Classe> classe;
    public Ordem(String nome, Classe classe) {
        this.nome = nome;
        this.classe = Optional.ofNullable(classe);
    }
    public Optional<Classe> getClasse() {
        return classe;
    }

    public String getNome() {       
        return classe.map(Classe::getNome).orElse(" Classe Não informado") + "\n Ordem" + nome ;
    }




}
