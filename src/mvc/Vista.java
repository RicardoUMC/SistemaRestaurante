package mvc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class Vista  extends JFrame{

    //Defino las ventanas y elementos globales
    // public JFrame ventanaMenuPrincipal = new JFrame();
    public JButton btnMostrarMenu, btnPedido, btnRegRepartidor, btnRegPlatilo, btnRegRestaurante, btnSalir;
    
    public JLabel nombreRestaurante = new JLabel();
    public JLabel ubicacionRestaurante = new JLabel();

    //Método para mostrar el Menú Principal
    public void menuPrincipal(){
        JPanel panelNorte = new JPanel();
        JPanel panelCentro = new JPanel();
        panelNorte.setLayout(new GridBagLayout());
        panelCentro.setLayout(new GridBagLayout());

        JLabel tituloApp = new JLabel("<html><span style='color: teal;'>Sistema gestor de Restaurante</span></html>");
        tituloApp.setFont(tituloApp.getFont().deriveFont(25.0f));
        
        btnMostrarMenu = new JButton("Mostrar Menú");
        btnMostrarMenu.setPreferredSize(new Dimension(150, 50));
        btnPedido = new JButton("Realizar pedido");
        btnPedido.setPreferredSize(new Dimension(150, 50));
        btnRegRepartidor = new JButton("Registrar repartidores");
        btnRegRepartidor.setPreferredSize(new Dimension(150, 50));
        btnRegPlatilo = new JButton("Registrar platillo");
        btnRegPlatilo.setPreferredSize(new Dimension(150, 50));
        btnRegRestaurante = new JButton("Registrar datos de restaurante");
        btnRegRestaurante.setPreferredSize(new Dimension(150, 50));
        btnSalir = new JButton("Salir");
        btnSalir.setPreferredSize(new Dimension(150, 50));
        
        //Añadimos elementos al Panel Norte
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;

        c.gridx = 0;
        c.gridy = 0;  
        panelNorte.add(tituloApp, c);

        c.gridx = 0;
        c.gridy = 2;   
        panelNorte.add(nombreRestaurante, c);

        c.gridx = 0;
        c.gridy = 3;  
        panelNorte.add(ubicacionRestaurante, c);


        //Añadimos botones al Panel Centro
        c.gridx = 0;
        c.gridy = 0;  
        panelCentro.add(btnMostrarMenu, c);

        c.gridx = 1;
        c.gridy = 0;  
        panelCentro.add(btnPedido, c);

        c.gridx = 0;
        c.gridy = 2;  
        panelCentro.add(btnRegRepartidor, c);

        c.gridx = 1;
        c.gridy = 2;  
        panelCentro.add(btnRegPlatilo, c);

        c.gridx = 0;
        c.gridy = 3;  
        panelCentro.add(btnRegRestaurante, c);

        c.gridx = 1;
        c.gridy = 3;  
        panelCentro.add(btnSalir, c);

        //Añadimos paneles a la ventana
        add(panelNorte, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);

        setSize(400, 300);
		setLocation(800, 300);
		setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

