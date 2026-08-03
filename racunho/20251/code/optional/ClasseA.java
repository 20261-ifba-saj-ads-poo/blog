import java.util.Optional;

public class ClasseA {
    private String nome;  
    private ClasseB classeB;

    public ClasseB getClasseB() {
        return classeB;
    }

    public Optional<ClasseB> getOptionalClasseB() {
        return Optional.ofNullable(classeB);
    }

    public String getNome() {
        return nome;
    }

    public void setClasseB(ClasseB classeB) {
        this.classeB = classeB;
    }


}
