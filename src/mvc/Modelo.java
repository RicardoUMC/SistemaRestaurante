package mvc;

import mvc.clases.*;

public class Modelo {
    public Restaurante miRestaurante;
    public Comida regComida;
    public Bebida regBebida;
    public Postre regPostre;
    public Repartidor regRepartidor;

    public Pedido pedido;

    public boolean platillos(){
        if (miRestaurante.getBebidas() != null && miRestaurante.getComidas() != null && miRestaurante.getPostres() != null) {
            return true;
        } 
        return false;
    }
    //Método que invoca el botón 2
    public void guardarPedido(Comida comida, Bebida bebida, Postre postre){
        //Se puede llamar cuantas veces sea necesario, dependiendo de la cantidad de platillos que el usuario añada
        pedido.agregarPlatillo(comida, bebida, postre);
    }

    //Método que invoca el botón 3
    public void guardarRepartidor (Repartidor r){
        miRestaurante.agregarRepartidor(r);
    }

    //Método que invoca el botón 4
    public void guardarPlatillo (Comida c, Bebida b, Postre p){
        miRestaurante.agregarPlatillo(c, b, p);
    }

    //Método que invoca el botón 5
    public void registrarDatosRestaurante(String nombre, String ubicacion, String telefono){
        miRestaurante = new Restaurante(nombre, ubicacion, telefono);
    }

}

