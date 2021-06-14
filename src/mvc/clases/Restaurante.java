package mvc.clases;

public class Restaurante implements IReceta {
    private String nombre;
    private String ubicacion;
    private int maxPersonas;

    protected Pedido pedido;

    public Restaurante(String nombre, String ubicacion, int maxPersonas) {
        this.pedido = new Pedido();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.maxPersonas = maxPersonas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setMaxPersonas(int maxPersonas) {
        this.maxPersonas = maxPersonas;
    }

    public int getMaxPersonas() {
        return maxPersonas;
    }
}
