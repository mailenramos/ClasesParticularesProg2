public class ComparadorAnio implements Comparator<Obra> {

    public int compare(Obra o1, Obra o2) {
        return Integer.compare(
            o1.getAnioCreacion(),
            o2.getAnioCreacion()
        );
    }
}