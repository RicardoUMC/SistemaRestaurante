package mvc.clases;

public abstract class Persona {

    protected String nombre;
    protected String apellidos;
    protected int edad;
    protected String genero;

    public abstract void set_nombre();

    public abstract String get_nombre();

    public abstract void set_apellido();

    public abstract String get_apellido();

    public abstract void set_edad();

    public abstract int get_edad();

    public abstract void set_genero();

    public abstract String get_genero();

}