import java.util.ArrayList;
import java.util.List;

public class CalculadoraArea<T extends FormaGeometrica> {
    private List<T> formas;

    public CalculadoraArea() {
        this.formas = new ArrayList<>();
    }

    public CalculadoraArea(T formaInicial) {
        this();
        this.formas.add(formaInicial);
    }

    public void adicionarForma(T forma) {
        formas.add(forma);
    }

    public double calcular() {
        return formas.stream().mapToDouble(FormaGeometrica::calcularArea).sum();
    }
}
