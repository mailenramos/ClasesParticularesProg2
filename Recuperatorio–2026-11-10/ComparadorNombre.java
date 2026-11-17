import java.util.Comparator;

public class ComparadorNombre implements Comparator<Obra> {

    public int compare(Obra o1, Obra o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}