
public class Pop extends Veiculo<Integer> {
    public Pop(String modelo, Integer motor) {
        super(modelo, motor);
    }

    @Override
    public void ligar() {
        IO.println("Pop " + getModelo() + " com " + getMotor() + " está ligado.");
    }
}

