public  class CalculadorPorcentaje extends Calculador{

    private  double porcentaje;

    public CalculadorPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double calcular(Obra o) {
        return o.getValorTasacion() * porcentaje / 100;
    }
    
}