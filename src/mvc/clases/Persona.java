package mvc.clases;

public abstract class Persona {
    
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected char genero;

    public Persona() {}

    public Persona(String nombre, String apellido, int edad, char genero){

    }

    public abstract void setNombre(String nombre);

    public abstract String getNombre();

    public abstract void setApellido(String apellido);

    public abstract String getApellido();

    public abstract void setEdad(int edad);

    public abstract int getEdad();

    public abstract void setGenero(char genero);

    public abstract char getGenero();

}