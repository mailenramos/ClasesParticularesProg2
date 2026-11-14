public class CondicionTecnica extends Condicion {

    private String tecnica;

    public CondicionTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public boolean cumple(Obra o) {
        return o.getTecnicas().contains(tecnica);
    }
}