package mvc.clases;

public abstract class Persona {

    protected String nombre;
    protected String apellidos;
    protected int edad;
    protected String genero;

    public abstract void set_nombre(String nombre);

    public abstract String get_nombre();

    public abstract void set_apellido(String apellido);

    public abstract String get_apellido();

    public abstract void set_edad(int edad);

    public abstract int get_edad();

    public abstract void set_genero(String genero);

    public abstract String get_genero();

}