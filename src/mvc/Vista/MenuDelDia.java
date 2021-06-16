package mvc.Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class MenuDelDia extends JFrame{
    
    // public DefaultTableModel modelo = new DefaultTableModel();
    String [] columnas = {"Nombre", "Precio"};
    
    public JTable tablaComidas = new JTable();
    public JTable tablaBebidas = new JTable();
    public JTable tablaPostres = new JTable();
    
    public DefaultTableModel modeloComidas = (DefaultTableModel) tablaComidas.getModel();
    public DefaultTableModel modeloBebidas = (DefaultTableModel) tablaBebidas.getModel();
    public DefaultTableModel modeloPostres = (DefaultTableModel) tablaPostres.getModel();
    
    //Creamos 4 paneles
    JPanel panelNorte = new JPanel();
    JPanel panelIzquierdo = new JPanel();
    JPanel panelCentro = new JPanel();
    JPanel panelDerecho = new JPanel();
    
    JLabel tituloApp = new JLabel();

    public MenuDelDia() {
        //Se definen los títulos para los headers de la tabla  
        modeloComidas.addColumn("Nombre");
        modeloComidas.addColumn("Precio");  
        modeloBebidas.addColumn("Nombre");
        modeloBebidas.addColumn("Precio");  
        modeloPostres.addColumn("Nombre");
        modeloPostres.addColumn("Precio");  

        panelCentro.setLayout(new GridBagLayout());
        panelIzquierdo.setLayout(new GridBagLayout());
        panelNorte.setLayout(new FlowLayout());
        panelDerecho.setLayout(new GridBagLayout());

        tituloApp.setFont(tituloApp.getFont().deriveFont(25.0f));
        tituloApp = new JLabel("<html><span style='color: teal;'>MENÚ DEL DÍA</span></html>");
    }
    
    public void mostrar (String[][] comidas, String[][] bebidas, String[][] postres){
        
        setTitle("Menú del día");
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;

        //añadimos títlo

        tituloApp.setFont(tituloApp.getFont().deriveFont(25.0f));
        panelNorte.add(tituloApp);

        
        JLabel titulo = new JLabel();

        //Añadimos sección de comida
        //Creamos tabla comida
        modeloComidas = llenarTabla(modeloComidas, comidas);
        tablaComidas.setModel(modeloComidas); 
        modeloComidas.fireTableDataChanged();
        titulo = new JLabel("<html><span style='color: teal;'>Comida</span></html>");
        c.gridx = 0;
        c.gridy = 0;
        panelIzquierdo.add(titulo, c);
        c.gridx = 0;
        c.gridy = 2;   
        panelIzquierdo.add(new JScrollPane(tablaComidas), c);

        
        //Añadimos sección de Bebida
        //Creamos tabla Bebida
        modeloBebidas = llenarTabla(modeloBebidas, bebidas);
        tablaBebidas.setModel(modeloBebidas); 
        modeloBebidas.fireTableDataChanged();
        titulo = new JLabel("<html><span style='color: teal;'>Bebidas</span></html>");
        c.gridx = 0;
        c.gridy = 0;
        panelCentro.add(titulo, c);
        c.gridx = 0;
        c.gridy = 2;   
        panelCentro.add(new JScrollPane(tablaBebidas), c);
        
        //Añadimos sección de Postre
        //Creamos tabla Postre
        modeloPostres = llenarTabla(modeloPostres, postres);
        tablaPostres.setModel(modeloPostres); 
        modeloPostres.fireTableDataChanged();   
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
		setLocation(500, 500);
		setVisible(true);
        pack();
    }

    //Llena a tabla a partir de la información que el controlador nos da
    private DefaultTableModel llenarTabla (DefaultTableModel modelo, String [][] data){
        modelo.setRowCount(0);
        
        Object [] fila = new Object[2];
        
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i][0]);
            System.out.println(data[i][1]);
            fila[0] = data[i][0];
            fila[1] = data[i][1];
            modelo.addRow(fila);  
        }
        
        // tablaComidas.setModel(modelo); 
        // modelo.fireTableDataChanged();

        return modelo;
        
    }

}
