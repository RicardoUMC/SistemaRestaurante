package mvc.clases;

public class Repartidor extends Persona {

    protected String medioTransporte;    
    protected float calificacion;
    protected char genero;

    public Repartidor() {}

    public Repartidor(String nombre, String apellido, int edad, char genero, String medioTransporte, int tiempoLlegada, float calificacion){
        super(nombre, apellido, edad, genero);
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
    public void set_genero(char genero) {
        this.genero = genero;
    }

    @Override
    public char get_genero() {
        return genero;
    }

}
