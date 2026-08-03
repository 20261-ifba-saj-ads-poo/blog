
import java.util.Optional;

public class Filo {
    private String nome;
    private Optional<Reino> reino;

    public Filo(String nome, Reino reino) {
        this.nome = nome;
        this.reino = Optional.ofNullable(reino);
    }

    public Optional<Reino> getReino() {
        return reino;
    }

    public String getNome() {
        return reino.map(Reino::getNome).orElse(" Reino Não informado") + "\nFilo" + nome ;
    }


}
