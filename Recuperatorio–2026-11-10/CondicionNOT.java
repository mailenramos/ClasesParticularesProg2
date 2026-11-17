public class CondicionNOT extends Condicion {

    private Condicion c;

    public CondicionNOT(Condicion c) {
        this.c = c;
    }

    public boolean cumple(Elemento e) {
        return !c.cumple(e);
    }
}