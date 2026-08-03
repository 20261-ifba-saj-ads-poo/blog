import java.io.IO;

public class TestaVeiculos {
    public static void main(String[] args) {
        // Criando motores
        MotorCombustao motorCarro = new MotorCombustao(2000);
        MotorCombustao motorMoto = new MotorCombustao(600);
        MotorEletrico motorCaminhao = new MotorEletrico(300);

        // Criando veículos
        Carro carro = new Carro("Sedan", motorCarro);
        Moto moto = new Moto("Esportiva", motorMoto);
        CaminhaoEletrico caminhao = new CaminhaoEletrico("Carga Pesada", motorCaminhao);
        
        //sem necessidade de cast para MotorCombustao
        IO.println(carro.getMotor().getCilindradas());
        IO.println(moto.getMotor().getCilindradas());
        //sem necessidade de cast para MotorEletrico
        IO.println(caminhao.getMotor().getPotenciaKW());
        
        // Ligando os veículos
        carro.ligar();
        moto.ligar();
        caminhao.ligar();
    }
}