package mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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

            if(vista.btnPedido == e.getSource()) {
                //realizarPedido
            }

            if(vista.btnRegRepartidor == e.getSource()) {
                //registrarRepartidor
            }

            if(vista.btnRegPlatilo == e.getSource()) {
                //regsitrarPlatillo
            }

            if(vista.btnRegRestaurante == e.getSource()) {
                //Pedimos datos al usuario
                String nombreRestaurante = JOptionPane.showInputDialog("Nombre del restaurante: ");
                String ubicacioneRestaurante = JOptionPane.showInputDialog("Ubicación (dirección) del restaurante: ");
                String telefonoRestaurante = JOptionPane.showInputDialog("Telefono del restaurante: ");

                //Registramos los datos del restaurante
                modelo.registrarDatosRestaurante(nombreRestaurante, ubicacioneRestaurante, telefonoRestaurante);

                //Asignamos dichos datos a los labels del menu
                vista.nombreRestaurante.setText(modelo.miRestaurante.getNombre());
                vista.ubicacionRestaurante.setText(modelo.miRestaurante.getUbicacion());
                vista.telefonoRestaurante.setText(modelo.miRestaurante.getTelefono());
            }

            if(vista.btnSalir == e.getSource()) {
                System.exit(0);
            }


        }
    };
}
