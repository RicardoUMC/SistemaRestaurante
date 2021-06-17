package mvc.Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MenuDelDia extends JFrame{
    
    // public DefaultTableModel modelo = new DefaultTableModel();
    String [] columnas = {"Nombre", "Precio ($)"};
    
    public JTable tablaComidas = new JTable();
    public JTable tablaBebidas = new JTable();
    public JTable tablaPostres = new JTable();
    
    public DefaultTableModel modeloComidas = (DefaultTableModel) tablaComidas.getModel();
    public DefaultTableModel modeloBebidas = (DefaultTableModel) tablaBebidas.getModel();
    public DefaultTableModel modeloPostres = (DefaultTableModel) tablaPostres.getModel();
    
    //Creamos 4 paneles
    JPanel panelNorte = new JPanel();
    JPanel panelTitulos = new JPanel();
    
    JLabel tituloApp = new JLabel();

    public MenuDelDia() {
        //Se definen los títulos para los headers de la tabla  
        modeloComidas.addColumn("Nombre");
        modeloComidas.addColumn("Precio ($)");  
        modeloBebidas.addColumn("Nombre");
        modeloBebidas.addColumn("Precio ($)");  
        modeloPostres.addColumn("Nombre");
        modeloPostres.addColumn("Precio ($)");  

        panelNorte.setLayout(new GridLayout(2,1));
        panelTitulos.setLayout(new GridLayout(1, 3));

        tituloApp.setFont(tituloApp.getFont().deriveFont(25.0f));
        tituloApp = new JLabel("<html><span style='color: teal;'>MENÚ DEL DÍA</span></html>");
    }
    
    public void mostrar (String[][] comidas, String[][] bebidas, String[][] postres){
        
        setTitle("Menú del día");
        
        //añadimos títlo
        tituloApp.setFont(tituloApp.getFont().deriveFont(25.0f));
        panelNorte.add(tituloApp);

        //Añadimos títulos de tablas
        JLabel titulo = new JLabel();
        titulo = new JLabel("<html><span style='color: teal;'>Comida</span></html>");
        panelTitulos.add(titulo);
        titulo = new JLabel("<html><span style='color: teal;'>Bebidas</span></html>");
        panelTitulos.add(titulo);
        titulo = new JLabel("<html><span style='color: teal;'>Postres</span></html>");
        panelTitulos.add(titulo);
        panelNorte.add(panelTitulos, BorderLayout.SOUTH);

        //Añadimos sección de comida
        //Creamos tabla comida
        modeloComidas = llenarTabla(modeloComidas, comidas);
        tablaComidas.setModel(modeloComidas); 
        modeloComidas.fireTableDataChanged();
        
        //Añadimos sección de Bebida
        //Creamos tabla Bebida
        modeloBebidas = llenarTabla(modeloBebidas, bebidas);
        tablaBebidas.setModel(modeloBebidas); 
        modeloBebidas.fireTableDataChanged();
        
        //Añadimos sección de Postre
        //Creamos tabla Postre
        modeloPostres = llenarTabla(modeloPostres, postres);
        tablaPostres.setModel(modeloPostres); 
        modeloPostres.fireTableDataChanged();   

        //Añadimos los paneles a la ventana
        getContentPane().setLayout(new BorderLayout());
        add(panelNorte, BorderLayout.NORTH);
        add(new JScrollPane(tablaComidas), BorderLayout.LINE_START);
        add(new JScrollPane(tablaBebidas), BorderLayout.CENTER);
        add(new JScrollPane(tablaPostres), BorderLayout.LINE_END);

        setSize(800, 500);
		setLocation(500, 500);
		setVisible(true);
        pack();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                getContentPane().removeAll();
                repaint();
            }
        });
    }

    //Llena a tabla a partir de la información que el controlador nos da
    private DefaultTableModel llenarTabla (DefaultTableModel modelo, String [][] data){
        modelo.setRowCount(0);
        
        Object [] fila = new Object[2];
        
        for(int i = 0; i < data.length; i++){
            fila[0] = data[i][0];
            fila[1] = data[i][1] + "0";
            modelo.addRow(fila);  
        }
        return modelo;       
    }
}
