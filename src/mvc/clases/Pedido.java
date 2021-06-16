package mvc.clases;

import java.util.ArrayList;

public class Pedido {
    protected Repartidor repartidor;
    protected int idRepartidor;
    protected Cliente cliente;
    public ArrayList <Comida> comidas;
    public ArrayList <Bebida> bebidas;
    public ArrayList <Postre> postres;

    public Pedido() {
        this.repartidor = new Repartidor();
    }

    public Pedido(Cliente cliente) {
        this.repartidor = new Repartidor();
        this.cliente = cliente;
        this.comidas = new ArrayList<>(); 
        this.bebidas = new ArrayList<>();
        this.postres = new ArrayList<>();
    }

    public ArrayList<Comida> getComidas() {
        return this.comidas;
    }

    public ArrayList<Bebida> getBebidas() {
        return this.bebidas;
    }

    public ArrayList<Postre> getPostres() {
        return this.postres;
    }

    public void asignarRepartidor(int idRepartidor){
        this.idRepartidor = idRepartidor;
    }

    public void agregarPedido(Comida comida, Bebida bebida, Postre postre){
        this.comidas.add(comida);
        this.bebidas.add(bebida);
        this.postres.add(postre);
    }
}
