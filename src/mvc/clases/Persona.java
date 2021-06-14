package mvc.clases;

public abstract class Persona {
    
    protected String nombre;
    protected String apellidos;
    protected int edad;
    protected char genero;

    public Persona(String nombre, String apellidos, int edad, char genero){

    }

    public abstract void set_nombre(String nombre);

    public abstract String get_nombre();

    public abstract void set_apellido(String apellido);

    public abstract String get_apellido();

    public abstract void set_edad(int edad);

    public abstract int get_edad();

    public abstract void set_genero(char genero);

    public abstract char get_genero();

}