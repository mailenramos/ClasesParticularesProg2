public abstract class Elemento {

    private String nombre;

    public Elemento(String nombre) {
        this.nombre=nombre;
    }

    public  abstract double calcularCostoMensualConservacion();
    public  abstract  int getAnioCreacion();
    public  abstract double getValorTasacion();
    public abstract Arraylist<String> getTecnicas();
    public abstract Elemento getCopia(Condicion c);
    public abstract ArrayList<Obra> getListadoObras(Comparator<Obra> c);
}


