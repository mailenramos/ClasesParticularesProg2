import java.util.Comparator;

public class ComparadorValor implements Comparator<Obra> {

    public int compare(Obra o1, Obra o2) {
        return Double.compare(
            o2.getValorTasacion(),
            o1.getValorTasacion()
        );
    }
}