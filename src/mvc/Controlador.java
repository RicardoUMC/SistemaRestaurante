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
                String nombre = validString(JOptionPane.showInputDialog("Nombre del repartidor: "), "Nombre del repartidor: ");
                String apellido = validString(JOptionPane.showInputDialog("Apellido del repartidor: "), "Apellido del repartidor: ");
                //TODO: Comprobar que el string pase a entero
                int edad = Integer.parseInt(validString(JOptionPane.showInputDialog("Edad del repartidor: "), "Edad del repartidor: "));
                
                //Se valida solamente F o M
                String[] options = {"F", "M"};
                String n = (String) JOptionPane.showInputDialog(null, "Género del repartidor:", null, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                char genero = n.charAt(0);
                
                String medioTransporte = validString(JOptionPane.showInputDialog("Medio de transporte: "), "Medio de transporte: ");
                // TODO: Comprobar que el string pase a entero
                int tiempoLlegada = Integer.parseInt(validString(JOptionPane.showInputDialog("Tiempo promedio de llegada (minutos): "), "Tiempo promedio de llegada (minutos): "));
                //TODO: Comprobar que el string pase a flotante y esté en el rango solicitado
                float calificacion = Float.parseFloat(validString(JOptionPane.showInputDialog("Calificación de 1 - 5 estrellas: "), "Calificación de 1 - 5 estrellas: "));

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
                String nombre = validString(JOptionPane.showInputDialog("Nombre del restaurante: "), "Ingrese un nombre válido: ");
                String ubicacion = validString(JOptionPane.showInputDialog("Ubicación (dirección) del restaurante: "), "Ingrese una dirección válida: ");
                String telefono = validString(JOptionPane.showInputDialog("Teléfono del restaurante: "), "Ingrese un teléfono válido: ");

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
    private String validString(String validacion, String mensajeVal) {
        if (!"".equals(validacion)) {
            try{
                return validacion;
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo registrar el valor apropiadamente.");
            }
        }
        return validString(JOptionPane.showInputDialog(mensajeVal), mensajeVal);
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
