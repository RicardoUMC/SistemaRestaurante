package mvc.Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CrearPedido extends JFrame{

    

    //String [] columnas = {"Comidas","cantidad"};
    //String [] columnas2 = {"No. Repartidor","Veiculo"};
    
    
    public JTable tablaComidas = new JTable();
    public JTable tablaBebidas = new JTable();
    public JTable tablaPostres = new JTable();
    public JTable tablaRepartidor = new JTable();
    
 
    public DefaultTableModel modeloComidas = (DefaultTableModel) tablaComidas.getModel();
    public DefaultTableModel modeloBebidas = (DefaultTableModel) tablaBebidas.getModel();
    public DefaultTableModel modeloPostres = (DefaultTableModel) tablaPostres.getModel();
    public DefaultTableModel modeloRepartidor = (DefaultTableModel) tablaRepartidor.getModel();
    JPanel panelNorte = new JPanel();
    JPanel panelTitulos = new JPanel();

    String[] metodosPago = { "Efectivo", "Paypal", "Tarjeta de débito", "Tarjeta de crédito", "Código QR" };
    public JComboBox listMetodos = new JComboBox(metodosPago);

    JLabel tituloApp = new JLabel();

    public String nombreCliente;
    public int totalPagar;
    

    //Botón para hacer pedido
    public JButton btnAceptar = new JButton("Hacer pedido");

    public CrearPedido() {
        //Se definen los títulos para los headers de la tabla  
        modeloComidas.addColumn("Nombre");
        modeloComidas.addColumn("Precio ($)");  
        modeloBebidas.addColumn("Nombre");
        modeloBebidas.addColumn("Precio ($)"); 
        modeloPostres.addColumn("Nombre");
        modeloPostres.addColumn("Precio ($)"); 
        modeloRepartidor.addColumn("Nombre");
        modeloRepartidor.addColumn("No. Repartidor");

        panelNorte.setLayout(new GridBagLayout());
        panelTitulos.setLayout(new GridLayout(1,3));

        tituloApp.setFont(tituloApp.getFont().deriveFont(25.0f));
        tituloApp = new JLabel("<html><span style='color: teal;'>Pedidos</span></html>");

        listMetodos.setSelectedIndex(0);
    }
    
    public void mostrar(String[][] comidas, String[][] bebidas, String[][] postres, String[][] Repartidor, String nombreCliente, String apellidoCliente){
        //Asignamos datos del cliente
        this.nombreCliente = nombreCliente + " " + apellidoCliente;

        setTitle("Pedidos");
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;

        //Añadimos lista de métodos de pago
        listMetodos.setSelectedIndex(0);
        c.gridx = 0;
        c.gridy = 0; 
        panelNorte.add(listMetodos, c);

        //añadimos títlo
        c.gridx = 1;
        c.gridy = 0;
        panelNorte.add(tituloApp, c);

        c.gridx = 2;
        c.gridy = 0;
        tituloApp.setFont(tituloApp.getFont().deriveFont(25.0f));
        panelNorte.add(btnAceptar, c);

        //Añadimos títulos de tablas
        JLabel titulo = new JLabel();
        titulo = new JLabel("<html><span style='color: teal;'>Comida</span></html>");
        c.gridx = 0;
        c.gridy = 1;
        panelNorte.add(titulo, c);
        titulo = new JLabel("<html><span style='color: teal;'>Bebidas</span></html>");
        c.gridx = 1;
        c.gridy = 1;
        panelNorte.add(titulo, c);
        titulo = new JLabel("<html><span style='color: teal;'>Postres</span></html>");
        c.gridx = 2;
        c.gridy = 1;
        panelNorte.add(titulo, c);
        // panelNorte.add(panelTitulos, c);

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

        //Creamos tabla repartidor
        modeloRepartidor = llenarTabla(modeloRepartidor, Repartidor);
        tablaRepartidor.setModel(modeloRepartidor); 
        modeloRepartidor.fireTableDataChanged();
        

        //Añadimos los paneles a la ventana
        getContentPane().setLayout(new BorderLayout());
        add(panelNorte, BorderLayout.NORTH);
        add(new JScrollPane(tablaComidas), BorderLayout.WEST);
        add(new JScrollPane(tablaBebidas), BorderLayout.CENTER);
        add(new JScrollPane(tablaPostres), BorderLayout.EAST);
        add(new JScrollPane(tablaRepartidor), BorderLayout.SOUTH);

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
            fila[1] = data[i][1];
            modelo.addRow(fila);  
        }
        

        return modelo;
        
    }
}

// String dato=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));