public class MotorCombustao extends Motor {
    private int cilindradas;

    public MotorCombustao(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    @Override
    public String toString() {
        return "Motor Combustão (" + cilindradas + "cc)";
    }
}