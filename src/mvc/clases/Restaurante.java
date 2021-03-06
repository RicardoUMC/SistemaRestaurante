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
    protected ArrayList <Cliente> clientes;
    protected ArrayList <Repartidor> repartidores;

    public Restaurante() {
        this.pedido = new ArrayList<Pedido>();

    }
    
    public Restaurante(String nombre, String ubicacion, String telefono) {
        this.pedido = new ArrayList<Pedido>();
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

    public void agregarCliente (Cliente r){
        clientes.add(r);
    }

    public void agregarPlatillo (Comida c, Bebida b, Postre p){
        comidas.add(c);
        bebidas.add(b);
        postres.add(p);
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public ArrayList<Postre> getPostres() {
        return postres;
    }

    public void setPostres(ArrayList<Postre> postres) {
        this.postres = postres;
    }

    public ArrayList<Repartidor> getRepartidores() {
        return repartidores;
    }

    public void setRepartidores(ArrayList<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }

    public ArrayList<Cliente> getCliente() {
        return clientes;
    }

    public void setCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    //---------NO BORRAR---------//
    public ArrayList<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Pedido> pedido) {
        this.pedido = pedido;
    }
    //---------NO BORRAR---------//
}
