package mvc.clases;

public class Repartidor extends Persona {

    protected String medioTransporte;    
    protected float calificacion;
    protected char genero;

    public Repartidor() {}

    public Repartidor(String nombre, String apellido, int edad, char genero, String medioTransporte, int tiempoLlegada, float calificacion){

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.medioTransporte = medioTransporte;
        this.calificacion = calificacion;
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
        
        this.apellido = apellido;
        
    }
    @Override
    public String get_apellido() {
        
        return apellido;
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
    public void set_genero(char genero) {
        this.genero = genero;
    }

    @Override
    public char get_genero() {
        return genero;
    }

}
