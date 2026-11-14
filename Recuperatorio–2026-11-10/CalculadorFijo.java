public  class CalculadorFijo extends Calculador{

    private  double valor;

    public CalculadorFijo(double valor) {
        this.valor = valor;
    }

    public double calcular(Obra o) {
        return valor;
    }
    
}