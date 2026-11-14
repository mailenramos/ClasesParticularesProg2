import com.sun.jdi.connect.Connector;
import java.security.PublicKey;
import java.util.ArrayList;

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
    public Elemento getCopia(Condicion c){
        ArrayList<Elemento> resultado =new ArrayList<Elemento>();
        for(Elemento e:this.elementos){
            Elemento eCopia=e.getCopia(c);
            if(eCopia!=null){
                resultado.add(eCopia);
            }
        }
        if(resultado.size()>0){
            Espacio espacioCopia=this.getCopiaEspacio();
            for(Elemento elem:resultado){
                espacioCopia.addElemento(elem);
            }
            return espacioCopia;
        }else{
            return null;
        }
            
    }

    public ArrayList<Obra> getListadoObras(Comparator<Obra> c) {

        ArrayList<Obra> lista = new ArrayList<>();

        for (Elemento e : elementos) {
            lista.addAll(e.getListadoObras(c));
        }

        Collections.sort(lista, c);
        return lista;
    }



}