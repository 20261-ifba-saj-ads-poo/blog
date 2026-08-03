
import java.util.Optional;

public class Familia {
    private String nome;
    private Optional<Ordem> ordem;
    public Familia(String nome, Ordem ordem) {
        this.nome = nome;
        this.ordem = Optional.ofNullable(ordem);
    }
    public Optional<Ordem> getOrdem() {
        return ordem;
    }

    public String getNome() {
        return ordem.map(Ordem::getNome).orElse(" Ordem Não informado") + "\nFamilia" + nome ;
    }

}
