public class ObraDigital extends Obra {

    private static double valorPosterior2020 = 50000;
    private static double valorHasta2020 = 10000;

    public ObraDigital(String nombre, String autor,
                       int anioCreacion, Calculador c) {

        super(nombre, autor, anioCreacion, 0, c);
    }

    @Override
    public double getValorTasacion() {

        if (this.getAnioCreacion() > 2020) {
            return valorPosterior2020;
        }

        return valorHasta2020;
    }

    public static void setValorPosterior2020(double valor) {
        valorPosterior2020 = valor;
    }

    public static void setValorHasta2020(double valor) {
        valorHasta2020 = valor;
    }
}