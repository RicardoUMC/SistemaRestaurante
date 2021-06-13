package mvc.clases;

public class Restaurante implements IReceta {
    protected Pedido pedido;

    public Restaurante() {
        this.pedido = new Pedido();
    }
}
