import java.util.ArrayList;
import java.util.Comparator;
public abstract class Elemento {

    String nombre;

    public Elemento(String nombre) {
        this.nombre=nombre;
    }
    public String getNombre() {
        return this.nombre;
    }
    public  abstract double calcularCostoMensualConservacion();
    public  abstract  int getAnioCreacion();
    public  abstract double getValorTasacion();
    public abstract ArrayList<String> getTecnicas();
    public abstract Elemento getCopia(Condicion c);
    public abstract ArrayList<Obra> getListadoObras(Comparator<Obra> c);
}


