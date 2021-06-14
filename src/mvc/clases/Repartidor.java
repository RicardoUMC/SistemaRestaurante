package mvc.clases;

public class Repartidor extends Persona {

    protected Persona per;
    protected int repartidor_No;    
    protected boolean disponibilidad;

    Repartidor(Persona per,int repartidor_No, boolean disponibilidad){
        super(per.nombre,per.apellidos,per.edad,per.genero);

    }
    @Override
    public void set_nombre(String nombre){

        this.nombre=nombre;
    }
    @Override
    public String get_nombre(){

        return nombre;      
    }
    @Override
    public void set_apellido(String apellido) {
        
        this.apellidos = apellido;
        
    }
    @Override
    public String get_apellido() {
        
        return apellidos;
    }
    @Override
    public void set_edad(int edad) {
        
        this.edad = edad;
        
    }
    @Override
    public int get_edad() {
        
        return edad;
    }
    @Override
    public void set_genero(String genero) {
        
        this.genero = genero;
    }
    @Override
    public String get_genero() {
        
        return genero;
    }

    public void set_repartidor_No(int repartidor_No){

        this.repartidor_No = repartidor_No;

    }

    public int get_repartidor_No(){

        return repartidor_No;

    }

    public void set_disponibilidad(boolean disponibilidad){

        this.disponibilidad = disponibilidad;

    }


    public boolean get_disponibilidad(){

        return disponibilidad;

    }
}
