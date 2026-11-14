import java.time.LocalDate;
import java.util.ArrayList;

public class Obra extends Elemento{

    String autor;
    private int anioCreacion;
    private double valorTasasion;
    private ArrayList<String> tecnicas;
    private Calculador c;

    public Obra(String nombre,String autor,int anioCreacion,double valorTasasion,Calculador c){
        super(nombre);
        this.autor=autor;
        this.anioCreacion=anioCreacion;
        this.valorTasasion=valorTasasion;
        this.tecnicas=new ArrayList<>();
        this.c=c;
    }
    public void addTecnica(String tecnica){
        if(!this.tecnicas.contains(tecnica)){
            tecnicas.addTecnica(tecnica);
        }
    }
    public String getAutor() {
        return this.autor;
    }
    public int getAnioCreacion(){
        return this.anioCreacion;
    }
    public double calcularCostoMensualConservacion(){
        return c.calcular(this);
    }
    public double getValorTasacion(){
        return this.valorTasasion;
    }
    public Arraylist<String> getTecnicas(){
        return new ArrayList<>(this.tecnicas);
        
    }
    public Elemento getCopia(Condicion c){
        if(c.cumple(this)){
            Obra copia=new Obra(this.nombre,
                                this.autor,
                                this.anioCreacion,
                                this.valorTasasion,
                                this.c
                            );
            for(String tecnica:this.tecnicas){
                copia.addTecnica(tecnica);
            }

            return copia;
        }

        return null;
    }

    public ArrayList<Obra> getListadoObras(Comparator<Obra> c) {
    ArrayList<Obra> lista = new ArrayList<>();
    lista.add(this);
    return lista;
}
}