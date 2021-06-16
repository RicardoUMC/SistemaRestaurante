package mvc.Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class MenuDelDia extends JFrame{
    
    // public DefaultTableModel modelo = new DefaultTableModel();
    String [] columnas = {"Nombre", "Precio"};
    public JTable tablaComidas;
    public JTable tablaBebidas;
    public JTable tablaPostres;
    
    
    public void mostrar (Object[][] comidas, Object[][] bebidas, Object[][] postres){
        setTitle("Menú del día");
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;
        
        JLabel titulo = new JLabel();
        

        //Creamos 4 paneles
        JPanel panelNorte = new JPanel();
        panelNorte.setLayout(new FlowLayout());
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridBagLayout());
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridBagLayout());
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());

        //añadimos títlo
        titulo = new JLabel("<html><span style='color: teal;'>MENÚ DEL DÍA</span></html>");
        titulo.setFont(titulo.getFont().deriveFont(40.0f));
        panelNorte.add(titulo);

        titulo.setFont(titulo.getFont().deriveFont(25.0f));
        //Añadimos sección de comida
        //Creamos tabla comida
        tablaComidas = new JTable(comidas, columnas);        

        titulo = new JLabel("<html><span style='color: teal;'>Comida</span></html>");
        c.gridx = 0;
        c.gridy = 0;
        panelIzquierdo.add(titulo, c);

        c.gridx = 0;
        c.gridy = 2;   
        panelIzquierdo.add(new JScrollPane(tablaComidas), c);

        
        //Añadimos sección de Bebidas
        //Creamos tabla Bebidas
        tablaBebidas = new JTable(bebidas, columnas);        
        titulo = new JLabel("<html><span style='color: teal;'>Bebidas</span></html>");
        c.gridx = 0;
        c.gridy = 0;
        panelCentro.add(titulo, c);
        c.gridx = 0;
        c.gridy = 2;   
        panelCentro.add(new JScrollPane(tablaBebidas), c);
        
        //Añadimos sección de Postres
        //Creamos tabla Postres
        tablaPostres = new JTable(postres, columnas);        
        titulo = new JLabel("<html><span style='color: teal;'>Postres</span></html>");
        c.gridx = 0;
        c.gridy = 0;
        panelDerecho.add(titulo, c);
        c.gridx = 0;
        c.gridy = 2;   
        panelDerecho.add(new JScrollPane(tablaPostres), c);


        //Añadimos los paneles a la ventana
        getContentPane().setLayout(new BorderLayout());
        add(panelNorte, BorderLayout.NORTH);
        add(panelIzquierdo, BorderLayout.LINE_START);
        add(panelCentro, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.LINE_END);

        setSize(800, 500);
		setLocation(800, 300);
		setVisible(true);
        pack();

    }


}
