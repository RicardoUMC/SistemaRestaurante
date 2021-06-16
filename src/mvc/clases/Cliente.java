package mvc.clases;

public class Cliente extends Persona {

    protected String direccion;
    protected int numeroTelefono;

    Cliente() {}

    Cliente(String nombre, String apellido, int edad, char genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
    }

    @Override
    public void setNombre(String nombre){

        this.nombre = nombre;
    }
    @Override
    public String getNombre(){

        return nombre;      
    }
    @Override
    public void setApellido(String apellido) {
        
        this.apellido = apellido;
        
    }
    @Override
    public String getApellido() {
        
        return apellido;
    }
    @Override
    public void setEdad(int edad) {
        
        this.edad = edad;
        
    }
    @Override
    public int getEdad() {
        
        return edad;
    }
    @Override
    public void setGenero(char genero) {
        
        this.genero = genero;
    }
    @Override
    public char getGenero() {
        
        return genero;
    }

    public void setDireccion(String direccion){

        this.direccion = direccion;

    }

    public String getDireccion(){

        return direccion;
    }

    public void setNumTel(int telefono){

        this.numeroTelefono = telefono;

    }

    public int getNumTel(){

        return numeroTelefono;
    }    

    
}
