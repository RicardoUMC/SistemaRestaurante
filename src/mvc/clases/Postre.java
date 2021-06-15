package mvc.clases;

public class Postre implements IReceta {
    private String nombre;
    private float precio;
    private String ingredientes;

    Postre(){    };

    Postre(String nombre, float precio, String ingredientes){
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
    public void setprecio(float precio) {
        this.precio = precio;
    }

    public float getprecio() {
        return precio;
    }
    public void setingredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getingredientes() {
        return ingredientes;
    }  
}
