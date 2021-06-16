package mvc.clases;

public class Comida implements IReceta {
    private String nombre;
    private float precio;
    private String ingredientes;

    public Comida(){    };

    public Comida(String nombre, float precio, String ingredientes){
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    };

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getIngredientes() {
        return ingredientes;
    }  
}
