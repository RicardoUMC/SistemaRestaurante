package mvc.clases;

public abstract class Persona {

    protected String nombre;
    protected String apellidos;
    protected int edad;
    protected String genero;

    public void set_nombre();

    public String get_nombre();

    public void set_apellido();

    public String get_apellido();

    public void set_edad();

    public int get_edad();

    public void set_genero();

    public String get_genero();

}