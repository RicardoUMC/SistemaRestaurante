package mvc.clases;

import java.util.ArrayList;

public class Restaurante implements IReceta {
    private String nombre;
    private String ubicacion;
    private String telefono;
    protected ArrayList <Pedido> pedido;

    public Restaurante(String nombre, String ubicacion, String telefono) {
        this.pedido = new ArrayList<Pedido>();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    

    public Restaurante() {
        this.pedido = new ArrayList<Pedido>();
    }
}
