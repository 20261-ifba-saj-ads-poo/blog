void main() {
    IO.println(" oi mundo");
    IO.println("Informe um valor inteiro");
    int numero = Integer.parseInt(IO.readln());
    IO.println("Informe um valor String");
    String valor = IO.readln();
    IO.println("Informe um valor double");
    double outroNumero = Double.parseDouble(IO.readln());
    IO.print("""
            Valor String %s,
            valor int %d
            valor double %f
            """.formatted(valor, numero, outroNumero));
}