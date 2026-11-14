public class CalculadorPorTecnica extends Calculador {

    private double valorPorTecnica;

    public CalculadorPorTecnica(double valorPorTecnica) {
        this.valorPorTecnica = valorPorTecnica;
    }

    public double calcular(Obra o) {
        return o.getTecnicas().size() * valorPorTecnica;
    }
}