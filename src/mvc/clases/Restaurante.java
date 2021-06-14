package mvc.clases;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Restaurante implements IReceta {
    protected ArrayList <Pedido> pedido;

    public Restaurante() {
        this.pedido = new ArrayList<Pedido>();
    }
}
