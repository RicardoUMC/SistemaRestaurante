package mvc;

import mvc.clases.Restaurante;

public class Modelo {
    Restaurante miRestaurante;

    public void registrarDatosRestaurante(String nombre, String ubicacion){
        miRestaurante = new Restaurante(nombre, ubicacion, 30);
    }

}

