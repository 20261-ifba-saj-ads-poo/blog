import java.util.Optional;

public class Cliente {
    private String nome;
    private Optional<CNH> cnh;
    private Optional<String> passaport;

    public Cliente(String nome, String passaport, CNH cnh) {
        this.nome = nome;
        setPassaport(passaport);
        setCnh(cnh);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassaport() {
        return passaport.orElse("Sem passaport");
    }

    public void setPassaport(String passaport) {
        this.passaport = Optional.ofNullable(passaport);
    }

    public Optional<CNH> getCnh() {
        return cnh;
    }

    public void setCnh(CNH cnh) {
        this.cnh = Optional.ofNullable(cnh);
    }

}
