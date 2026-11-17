import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Calculador calc = new CalculadorFijo(10000.0);
        Obra o1 = new Obra("La Noche", "Pérez", 1850, 10000, calc);
        Obra o2 = new Obra("Ciudad", "Gómez", 1950, 5000, calc);
        Obra o3 = new Obra("Robot", "Díaz", 2000, 3000, calc);

        
        Espacio salaA = new Espacio("Sala A");
        salaA.addElemento(o1);
        salaA.addElemento(o2);

        Espacio salaB = new Espacio("Sala B");
        salaB.addElemento(o3);

        Espacio museo = new Espacio("Museo");
        museo.addElemento(salaA);
        museo.addElemento(salaB);

        Espacio deposito = new Espacio("Depósito"); // vacío

        Condicion antesDe1900 = new CondicionAnioAntes(1900);

        Comparator<Obra> porNombre = new ComparadorNombre();
        Comparator<Obra> porValor = new ComparadorValor();

        //////////// Prueba 1: getCopia -> debería quedar solo La Noche////////////////////////////////////////
    
        Elemento copia = museo.getCopia(antesDe1900);

        ArrayList<Obra> obrasCopia = copia.getListadoObras(porNombre);

        System.out.println("--- Copia antes de 1900 ---");
            for (Obra obra : obrasCopia) {
                System.out.println(obra.getNombre());
            }

        // Prueba 2: museo por nombre -> Ciudad, La Noche, Robot
        ArrayList<Obra> museoPorNombre = museo.getListadoObras(porNombre);
        System.out.println("\n--- Museo por nombre ---");
        for (Obra obra : museoPorNombre) {
            System.out.println(obra.getNombre());
        }

        // Prueba 3: museo por valor (mayor a menor) -> La Noche, Ciudad, Robot
        ArrayList<Obra> museoPorValor = museo.getListadoObras(porValor);
        System.out.println("\n--- Museo por valor ---");
        for (Obra obra : museoPorValor) {
            System.out.println(obra.getNombre() + " $" + obra.getValorTasacion());
        }
    }
}