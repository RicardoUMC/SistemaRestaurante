package mvc.clases;

public class Pedido {
    protected Repartidor repartidor;
    protected Cliente cliente;

    public Pedido() {
        this.repartidor = new Repartidor();
    }

    public Pedido(Cliente cliente) {
        this.repartidor = new Repartidor();
        this.cliente = cliente; 
    }
}