import java.io.IO;

public class CaminhaoEletrico extends Veiculo<MotorEletrico> {
    public CaminhaoEletrico(String modelo, MotorEletrico motor) {
        super(modelo, motor);
    }

    @Override
    public void ligar() {
        IO.println("Caminhão Elétrico" + getModelo() + " com " + getMotor() + " está ligado.");
    }
    
}
