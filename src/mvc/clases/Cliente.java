package mvc.clases;

public class Cliente extends Persona {

    protected String direccion;
    protected int numero_telefono;

    Cliente() {}

    Cliente(String nombre, String apellidos, int edad, char genero) {
        //super(nombre, apellidos, edad, genero);
       
        // Se pone "this.atributo" porque no se pueden pasar los datos a Persona (Clase Abstracta)
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
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
