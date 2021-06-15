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

                //Pedimos datos al usuario
                String nombre = JOptionPane.showInputDialog("Nombre del repartidor: ");
                String apellido = JOptionPane.showInputDialog("Apellido del repartidor: ");
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del repartidor: "));
                char genero = JOptionPane.showInputDialog("Genero del repartidor (M o F): ").charAt(0);
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
                String nombre = JOptionPane.showInputDialog("Nombre del restaurante: ");
                String ubicacion = JOptionPane.showInputDialog("Ubicación (dirección) del restaurante: ");     
                String telefono = JOptionPane.showInputDialog("Teléfono del restaurante: ");

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

    /*private void compareString(String compare) {
        if (!"".equals(compare)) {
            try
        }
    }*/
}
