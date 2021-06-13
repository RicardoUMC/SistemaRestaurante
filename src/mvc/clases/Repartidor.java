package mvc.clases;

public class Repartidor extends Persona {

    private Persona repaPersona;

    protected int repartidor_No;    
    protected boolean disponibilidad;

    Repartidor(){


    }

    public void set_nombre(String nombre){

        this.nombre=nombre;
    }

    public String get_nombre(){

        return repaPersona.nombre;      
    }

    



}
