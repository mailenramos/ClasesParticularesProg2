import com.sun.jdi.connect.Connector;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Espacio extends Elemento{

    private ArrayList<Elemento> elementos;

    public Espacio(String nombre){
        super(nombre);
        this.elementos=new ArrayList<Elemento>();
    }
    public int getAnioCreacion() {
        int anioMenor = Integer.MAX_VALUE;

        for (Elemento e : elementos) {
            if (e.getAnioCreacion() < anioMenor) {
                anioMenor = e.getAnioCreacion();
            }
        }

        return anioMenor;
    }
    public double getValorTasacion(){
        double valor=0;

        for(Elemento e:elementos){
            valor+=e.getValorTasacion();
        }

        return valor;
    }
    public double calcularCostoMensualConservacion() {
    double costoConservacion = 0;

    for (Elemento e : elementos) {
        costoConservacion += e.calcularCostoMensualConservacion();
    }

    return costoConservacion;
}
    public ArrayList<String> getTecnicas(){
        ArrayList<String>salida=new ArrayList<>();
        for(Elemento e :elementos){
            ArrayList<String> tecnicas=e.getTecnicas();
            for(String palabra: tecnicas){
                if(!salida.contains(palabra)){
                    salida.add(palabra);
                }
            }
        }
        return salida;

    }
    // Devuelve una COPIA de este espacio que contiene solo las obras que cumplen la condición.
    // Si ninguna obra de adentro cumple, devuelve null (el espacio no aparece en la copia).
    public Elemento getCopia(Condicion c){
        // Acá se van guardando las copias de los hijos que SÍ cumplen.
        ArrayList<Elemento> resultado =new ArrayList<Elemento>();
         // Recorro cada elemento que tiene este espacio (pueden ser Obras u otros Espacios).
        for(Elemento e:this.elementos){
            // Le pido la copia a cada hijo:
            // - si es una Obra, se ejecuta Obra.getCopia(): devuelve la copia si cumple, o null si no.
            // - si es un Espacio, se vuelve a ejecutar ESTE mismo método (recursión).
            Elemento eCopia = e.getCopia(c);
           // null significa "este hijo no tiene nada que cumpla", así que lo salteo.
            if(eCopia!=null){
                resultado.add(eCopia);
            }
        }
        // Si al menos un hijo devolvió algo, armo la copia del espacio.
        if(resultado.size()>0){
            // Creo un espacio NUEVO y VACÍO con el mismo nombre que este.
            Espacio espacioCopia=this.getCopiaEspacio();
            // Le meto adentro las copias que fui juntando.
            for(Elemento elem:resultado){
                espacioCopia.addElemento(elem);
            }
            // Devuelvo la copia (que solo tiene lo que cumple).
            return espacioCopia;
        }else{
             // Ningún hijo cumplió: este espacio no se copia.
            return null;
        }
            
    }
    // Agrega un elemento al espacio, solo si no estaba ya (evita duplicados).
    public void addElemento(Elemento e){
        if(!this.elementos.contains(e)){
            this.elementos.add(e);
        }
    }

    // Crea un espacio nuevo, VACÍO, con el mismo nombre que este.
    // Se usa como "cáscara" para después llenarlo con las copias de los hijos.
    // Está separado en un método para que una subclase de Espacio pueda sobrescribirlo
    public Espacio getCopiaEspacio(){
        return new Espacio(this.getNombre());
    }

    public ArrayList<Obra> getListadoObras(Comparator<Obra> c) {
        // Lista donde voy a juntar todas las obras.
        ArrayList<Obra> lista = new ArrayList<>();

        for (Elemento e : elementos) {
            // Le pido a cada hijo su lista de obras:
        // - si es una Obra -> devuelve una lista con ella sola.
        // - si es un Espacio -> se vuelve a ejecutar ESTE método (recursión)
        //   y devuelve todas las obras que tiene adentro.
        //
        // addAll agrega TODOS los elementos de esa lista a la mía
        // (no agrega la lista como un solo elemento, sino obra por obra).
            lista.addAll(e.getListadoObras(c));
        }
        // Ya tengo todas las obras juntas. Ahora las ordeno con el comparador
        // que me pasaron (por nombre, por valor, por año, etc.).
        Collections.sort(lista, c);
         // Devuelvo la lista completa y ordenada.
        return lista;
    }



}