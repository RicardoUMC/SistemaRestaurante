package mvc;

import mvc.clases.Restaurante;

public class Modelo {
    Restaurante miRestaurante;

    public void registrarDatosRestaurante(String nombre, String ubicacion, String telefono){
        miRestaurante = new Restaurante(nombre, ubicacion, telefono);
    }

}

