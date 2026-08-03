import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

class Soldado {
    private int id;
    private String nome;
    private int tempoServico;
    private Cabo imediato;
    private static int quantidaSoldado = 0;

    public Soldado(String nome, int tempoServico) {
        this.nome = nome;
        this.tempoServico = tempoServico;
        this.id = ++Soldado.quantidaSoldado;
    }

    public void setImediato(Cabo imediato) {
        if (!Objects.equals(this.imediato, imediato)) {
            if (this.imediato != null) {
                this.imediato.removeSubordinado(this);
            }
        }
        this.imediato = imediato;
        this.imediato.addSubordinado(this);
    }

    public Cabo getImediato() {
        return imediato;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Soldado [nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Soldado other = (Soldado) obj;
        if (id != other.id)
            return false;
        return true;
    }

}

class Cabo {

    private int id;
    private String nome;
    private int tempoServico;
    private static int quantidaCabo = 0;
    private Collection<Soldado> subordinados;

    public Cabo(String nome, int tempoServico) {
        this.nome = nome;
        this.tempoServico = tempoServico;
        this.id = ++Cabo.quantidaCabo;
        this.subordinados = new ArrayList<>();
    }

    public void addSubordinado(Soldado soldado) {
        if (!subordinados.contains(soldado)) {
            subordinados.add(soldado);
        }
        if (!Objects.equals(soldado.getImediato(), this)) {
            soldado.setImediato(this);
        }
    }

    public List<Soldado> getSubordinados() {
        return List.copyOf(subordinados);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cabo [nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cabo other = (Cabo) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public void removeSubordinado(Soldado soldado) {
        subordinados.remove(soldado);
    }

}
class App {
    public static void main(String[] args) {
        Soldado s1 = new Soldado("Silva", 1);
        Soldado s2 = new Soldado("Queiroz", 1);
        Soldado s3 = new Soldado("Barreto", 1);

        Cabo c1 = new Cabo("Rocha", 2);
        Cabo c2 = new Cabo("Souza", 2);

        s1.setImediato(c1);
        c1.addSubordinado(s2);
        s3.setImediato(c1);

        System.out.println("Subordinados do Cabo " + c1.getNome());
        System.out.println(c1.getSubordinados());

        System.out.println("\nSubordinados do Cabo " + c2.getNome());
        System.out.println(c2.getSubordinados());

        s1.setImediato(c2);

        System.out.println("\nDepois da troca de imediatos");

        System.out.println("\nSubordinados do Cabo " + c1.getNome());
        System.out.println(c1.getSubordinados());

        System.out.println("\nSubordinados do Cabo " + c2.getNome());
        System.out.println(c2.getSubordinados());

        System.out.println("\nImediato do Soldado " + s1.getNome());
        System.out.println(s1.getImediato());
        System.out.println("\nImediato do Soldado " + s2.getNome());
        System.out.println(s2.getImediato());
        System.out.println("\nImediato do Soldado " + s3.getNome());
        System.out.println(s3.getImediato());
    }
}

