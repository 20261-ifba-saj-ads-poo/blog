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

        // Ligando os veículos
        carro.ligar();
        moto.ligar();
        caminhao.ligar();
    }
}