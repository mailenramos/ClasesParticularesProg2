public class CalculadorSuma extends Calculador {

    private Calculador c1;
    private Calculador c2;

    public CalculadorSuma(Calculador c1, Calculador c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public double calcular(Obra o) {
        return c1.calcular(o) + c2.calcular(o);
    }
}