package mvc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class Vista {

    //Defino las ventanas y elementos globales
    JFrame ventanaMenuPrincipal = new JFrame();

    //Método para mostrar el Menú Principal
    public void menuPrincipal(){
        JPanel panelNorte = new JPanel();
        JPanel panelCentro = new JPanel();
        panelNorte.setLayout(new FlowLayout());
        panelCentro.setLayout(new GridBagLayout());

        JLabel tituloApp = new JLabel("<html><span style='color: teal;'>Sistema gestor de Restaurante</span></html>");
        tituloApp.setFont(tituloApp.getFont().deriveFont(25.0f));

        JButton boton1, boton2, boton3, boton4, boton5, boton6;
        boton1 = new JButton("Mostrar Menú");
        boton1.setPreferredSize(new Dimension(150, 50));
        boton2 = new JButton("Realizar pedido");
        boton2.setPreferredSize(new Dimension(150, 50));
        boton3 = new JButton("Registrar repartidores");
        boton3.setPreferredSize(new Dimension(150, 50));
        boton4 = new JButton("Registrar platillo");
        boton4.setPreferredSize(new Dimension(150, 50));
        boton5 = new JButton("Registrar datos de restaurante");
        boton5.setPreferredSize(new Dimension(150, 50));
        boton6 = new JButton("Salir");
        boton6.setPreferredSize(new Dimension(150, 50));
        
        //Añadimos título al Panel Norte
        panelNorte.add(tituloApp);

        //Añadimos botones al Panel Centro
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;

        c.gridx = 0;
        c.gridy = 0;  
        panelCentro.add(boton1, c);

        c.gridx = 1;
        c.gridy = 0;  
        panelCentro.add(boton2, c);

        c.gridx = 0;
        c.gridy = 2;  
        panelCentro.add(boton3, c);

        c.gridx = 1;
        c.gridy = 2;  
        panelCentro.add(boton4, c);

        c.gridx = 0;
        c.gridy = 3;  
        panelCentro.add(boton5, c);

        c.gridx = 1;
        c.gridy = 3;  
        panelCentro.add(boton6, c);

        //Añadimos paneles a la ventana
        ventanaMenuPrincipal.add(panelNorte, BorderLayout.NORTH);
        ventanaMenuPrincipal.add(panelCentro, BorderLayout.CENTER);

        ventanaMenuPrincipal.setSize(400, 300);
		ventanaMenuPrincipal.setLocation(800, 300);
		ventanaMenuPrincipal.setVisible(true);
    }
}

