package mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
    
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

    public void actionPerformed(ActionEvent evento) {        

    }

    ActionListener listenerMenu = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(vista.btnSalir == e.getSource()) {
                System.exit(0);
            }
        }
    };
}
