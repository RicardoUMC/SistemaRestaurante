package mvc.clases;

public interface IReceta {
    
    public void setNombre(String nombre);
    public String getNombre();

    public void setPrecio(float precio);
    public float getPrecio() ;

    public void setIngredientes(String ingredientes);
    public String getIngredientes() ;
}
