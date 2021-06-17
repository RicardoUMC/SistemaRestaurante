package mvc;

import mvc.clases.*;

public class Modelo {
    public Restaurante miRestaurante;
    public Comida regComida;
    public Bebida regBebida;
    public Postre regPostre;
    public Repartidor regRepartidor;

    public Pedido pedido;

    //Mensajes que se mostrarán al usuario al registrar platillos
    String nomComida = "Nombre de la comida: ";
    String preComida = "Precio de la comida: ";
    String ingComida = "Ingredientes de la comida: ";
    String nomBebida = "Nombre de la bebida: ";
    String preBebida = "Precio de la bebida: ";
    String nomPostre = "Nombre del postre: ";
    String prePostre = "Precio del postre: ";
    String ingPostre = "Ingredientes del postre: ";

    // Mensajes que se mostrarán al usuario al registrar repartidores
    String nomRep = "Nombre del repartidor: ";
    String apeRep = "Apellido del repartidor: ";
    String edRep = "Edad del repartidor: ";
    String genRep = "Género del repartidor (F o M):";
    String noRep = "Asigne un numero de repartidor: ";
    String transRep = "Medio de transporte: ";
    String calRep = "Calificacion del repartidor (1 - 5): ";

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

