public class ComparadorAutorAnio implements Comparator<Obra> {

    public int compare(Obra o1, Obra o2) {

        int resultado = o1.getAutor().compareTo(o2.getAutor());

        if (resultado == 0) {
            resultado = Integer.compare(
                o1.getAnioCreacion(),
                o2.getAnioCreacion()
            );
        }

        return resultado;
    }
}