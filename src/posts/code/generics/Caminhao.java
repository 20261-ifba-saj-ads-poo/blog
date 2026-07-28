
public class Caminhao extends Veiculo<MotorEletrico> {
    public Caminhao(String modelo, MotorEletrico motor) {
        super(modelo, motor);
    }

    @Override
    public void ligar() {
        IO.println("Caminhão Elétrico" + getModelo() + " com " + getMotor() + " está ligado com "+getMotor().getPotenciaKW()+" de Potencia" );
    }
    
}
