package mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import mvc.clases.Repartidor;

public class Controlador{
    
    Modelo modelo;
    Vista vista;

    public Controlador(Modelo m, Vista v) {
        modelo = m;
        vista = v;
    }

    public void iniciarVista(){
        vista.menuPrincipal();
        this.vista.btnMostrarMenu.addActionListener(listenerMenu);
        this.vista.btnPedido.addActionListener(listenerMenu);
        this.vista.btnRegRepartidor.addActionListener(listenerMenu);
        this.vista.btnRegPlatilo.addActionListener(listenerMenu);
        this.vista.btnRegRestaurante.addActionListener(listenerMenu);
        this.vista.btnSalir.addActionListener(listenerMenu);
    }

    ActionListener listenerMenu = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(vista.btnMostrarMenu == e.getSource()) {
                //mostrarMenú
            }

            else if(vista.btnPedido == e.getSource()) {
                //realizarPedido
            }

            else if(vista.btnRegRepartidor == e.getSource()) {

                //Si no se han registrado datos del restaurante, no podemos crear repartidores
                if(modelo.miRestaurante == null){
                    JOptionPane.showMessageDialog(null, "No puede crear un repartidor sin antes registrar los datos del restaurante.");
                    return;
                }

                //Pedimos datos del repartidor
                String nombre = compareString(JOptionPane.showInputDialog("Nombre del repartidor: "), "Nombre del repartidor: ");
                String apellido = compareString(JOptionPane.showInputDialog("Apellido del repartidor: "), "Apellido del repartidor: ");
                //TODO: Comprobar que el string pase a entero
                int edad = Integer.parseInt(compareString(JOptionPane.showInputDialog("Edad del repartidor: "), "Edad del repartidor: "));
                char genero = JOptionPane.showInputDialog("Genero del repartidor (M o F): ").charAt(0);
                JOptionPane.showMessageDialog(null, genero);
                String medioTransporte = JOptionPane.showInputDialog("Medio de transporte: ");
                int tiempoLlegada = Integer.parseInt(JOptionPane.showInputDialog("Tiempo promedio de llegada (minutos): "));
                float calificacion = Float.parseFloat(JOptionPane.showInputDialog("Calificación de 1 - 5 estrellas: "));

                //Registramos los datos del repartidor (instanciamos persona y repartidor)
                Repartidor repartidor = new Repartidor(nombre, apellido, edad, genero, medioTransporte, tiempoLlegada, calificacion);

                //Guardamos en el arreglo de repartidores, que se encuentra en la clase Restaurante, la cual se invoca desde modelo
                modelo.guardarRepartidor(repartidor);
                JOptionPane.showMessageDialog(null, "El repartidor se ha guardado correctamente.");
            }

            else if(vista.btnRegPlatilo == e.getSource()) {
                //regsitrarPlatillo
            }

            else if(vista.btnRegRestaurante == e.getSource()) {
                //Pedimos datos al usuario
                String nombre = compareString(JOptionPane.showInputDialog("Nombre del restaurante: "), "Ingrese un nombre válido: ");
                String ubicacion = compareString(JOptionPane.showInputDialog("Ubicación (dirección) del restaurante: "), "Ingrese una dirección válida: ");
                String telefono = compareString(JOptionPane.showInputDialog("Teléfono del restaurante: "), "Ingrese un teléfono válido: ");

                //Registramos los datos del restaurante
                modelo.registrarDatosRestaurante(nombre, ubicacion, telefono);

                //Asignamos dichos datos a los labels del menu
                vista.nombreRestaurante.setText(modelo.miRestaurante.getNombre());
                vista.ubicacionRestaurante.setText(modelo.miRestaurante.getUbicacion());
                vista.telefonoRestaurante.setText(modelo.miRestaurante.getTelefono());
            }

            else if(vista.btnSalir == e.getSource()) {
                System.exit(0);
            }


        }
    };

    //Metodo recursivo para validar que la entrada de texto no sea nula
    //Primer parametro es el texto a validar, el segundo parametro es el mensaje para pedir un dato valido
    private String compareString(String validacion, String mensajeVal) {
        if (!"".equals(validacion)) {
            try{
                return validacion;
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo registrar el valor apropiadamente.");
            }
        }
        return compareString(JOptionPane.showInputDialog(mensajeVal), mensajeVal);
    }

    /*private char comparString(char validacion, String mensajeVal) {
        if (!"".equals(validacion)) {
            try {
                return validacion;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el valor apropiadamente.");
            }
        }
        return compareString(JOptionPane.showInputDialog(mensajeVal), mensajeVal);
    }*/

    /*private String compareString(String validacion, String mensajeVal) {
        if (!"".equals(validacion)) {
            try {
                return validacion;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el valor apropiadamente.");
            }
        }
        return compareString(JOptionPane.showInputDialog(mensajeVal), mensajeVal);
    }

    private String compareString(String validacion, String mensajeVal) {
        if (!"".equals(validacion)) {
            try {
                return validacion;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el valor apropiadamente.");
            }
        }
        return compareString(JOptionPane.showInputDialog(mensajeVal), mensajeVal);
    }*/
}
