public class CondicionAnioAntes extends Condicion {

    private int anio;

    public CondicionAnioAntes(int anio) {
        this.anio = anio;
    }

    public boolean cumple(Elemento e) {
        return e.getAnioCreacion() < anio;
    }
}