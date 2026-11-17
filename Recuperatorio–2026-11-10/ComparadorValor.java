import java.util.Comparator;
// Comparador que ordena obras por VALOR DE TASACIÓN, de MAYOR a MENOR.
// O sea: la obra más cara va primero.
public class ComparadorValor implements Comparator<Obra> {
    // compare le dice a Collections.sort quién va primero:
    //   negativo -> o1 va ANTES que o2
    //   cero     -> valen lo mismo
    //   positivo -> o1 va DESPUÉS que o2
    public int compare(Obra o1, Obra o2) {

        // Double.compare(a, b) compara dos double y devuelve:
        //   negativo si a < b, 0 si son iguales, positivo si a > b
        //
        // OJO: acá se pasa o2 PRIMERO y o1 DESPUÉS.
        // Eso INVIERTE el orden normal -> queda de mayor a menor.
        //
        // Ej: o1 = La Noche (10000), o2 = Robot (3000)
        //     Double.compare(3000, 10000) -> negativo
        //     -> negativo significa "o1 va antes" -> La Noche (la más cara) va primero
        return Double.compare(o2.getValorTasacion(),o1.getValorTasacion());
    }
}