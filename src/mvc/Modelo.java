package mvc;

import mvc.clases.Repartidor;
import mvc.clases.Restaurante;

public class Modelo {
    public Restaurante miRestaurante;

    //Método que invoca el botón 3
    public void guardarRepartidor (Repartidor r){
        miRestaurante.agregarRepartidor(r);
    }

    //Método que invoca el botón 5
    public void registrarDatosRestaurante(String nombre, String ubicacion){
        miRestaurante = new Restaurante(nombre, ubicacion, 30);
    }

}

