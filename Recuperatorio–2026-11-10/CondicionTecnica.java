public class CondicionTecnica extends Condicion {

    private String tecnica;

    public CondicionTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public boolean cumple(Elemento e) {
        return e.getTecnicas().contains(tecnica);
    }
}