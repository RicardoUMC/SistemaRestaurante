package mvc.clases;

import java.io.Console;
import java.util.ArrayList;

public class Restaurante implements IReceta {
    private String nombre;
    private String ubicacion;
    private String telefono;
    protected ArrayList <Comida> comidas;
    protected ArrayList <Bebida> bebidas;
    protected ArrayList <Postre> postres;
    protected ArrayList <Pedido> pedido;
    public ArrayList <Repartidor> repartidores;

    public Restaurante() {
        this.pedido = new ArrayList<Pedido>();
    }
    
    public Restaurante(String nombre, String ubicacion, String telefono) {
        this.pedido = new ArrayList<Pedido>();
        this.repartidores = new ArrayList<Repartidor>();
        this.comidas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.postres = new ArrayList<>();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
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
        return this.telefono;
    }

    public void agregarRepartidor (Repartidor r){
        repartidores.add(r);
    }

    public void agregarPlatillo (Comida c, Bebida b, Postre p){
        
        comidas.add(c);
        bebidas.add(b);
        postres.add(p);
    }
}
