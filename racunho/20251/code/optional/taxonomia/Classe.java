
import java.util.Optional;

public class Classe {
    private String nome;
    private Optional<Filo> filo;
    public Classe(String nome, Filo filo) {
        this.nome = nome;
        this.filo = Optional.ofNullable(filo);
    }
    public Optional<Filo> getFilo() {
        return filo;
    }

    
    public String getNome() {
        return filo.map(Filo::getNome).orElse(" Filo Não informado") + "\nClasse" + nome ;
    }

}
