package mvc.clases;

public class Repartidor extends Persona {

    protected int repartidor_No;    
    protected String medioTransporte;    

    public Repartidor() {}

    public Repartidor(String nombre, String apellido, int edad, char genero,int repartidor_No,String medioTransporte){

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.repartidor_No= repartidor_No;
        this.medioTransporte = medioTransporte;
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
    public void set_repartidor_No(int repartidor_No){

        this.repartidor_No = repartidor_No;

    }

    public int get_repartidor_No(){

        return repartidor_No;

    }

}
