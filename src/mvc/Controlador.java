package mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                //registrarDatosRestaurante
            }

            if(vista.btnSalir == e.getSource()) {
                System.exit(0);
            }


        }
    };
}
