package sistemarestaurante;

import mvc.*;
import mvc.Vista.*;

public class SistemaRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciarVista();
    }

}
