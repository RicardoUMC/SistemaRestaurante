package mvc.clases;

public class Cliente extends Persona {

    protected String direccion;
    protected int numero_telefono;

    Cliente() {}

    Cliente(String nombre, String apellidos, int edad, String genero) {
        super(nombre, apellidos, edad, genero);
       
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

    public void set_direccion(String direccion){

        this.direccion = direccion;

    }

    public String get_direccion(){

        return direccion;
    }

    public void set_numero_tel(int telefono){

        this.numero_telefono = telefono;

    }

    public int get_numero_tel(){

        return numero_telefono;
    }    

    
}
