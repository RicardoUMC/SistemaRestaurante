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
    public DefaultTableModel modeloPostres = new DefaultTableModel();
    public DefaultTableModel modeloBebidas = new DefaultTableModel();
    
    //Creamos 4 paneles
    JPanel panelNorte = new JPanel();
    JPanel panelIzquierdo = new JPanel();
    JPanel panelCentro = new JPanel();
    JPanel panelDerecho = new JPanel();
    
    public MenuDelDia() {
        modeloComidas.addColumn("Nombre");
        modeloComidas.addColumn("Precio");  
        panelCentro.setLayout(new GridBagLayout());
        panelIzquierdo.setLayout(new GridBagLayout());
        panelNorte.setLayout(new FlowLayout());
        panelDerecho.setLayout(new GridBagLayout());
    }
    
    public void mostrar (String[][] comidas, String[][] bebidas, String[][] postres){


        setTitle("Menú del día");
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;
        
        JLabel titulo = new JLabel();
        
        


        //añadimos títlo
        titulo = new JLabel("<html><span style='color: teal;'>MENÚ DEL DÍA</span></html>");
        titulo.setFont(titulo.getFont().deriveFont(40.0f));
        panelNorte.add(titulo);

        titulo.setFont(titulo.getFont().deriveFont(25.0f));


        //Añadimos sección de comida
        //Creamos tabla comida
        llenarTabla(comidas);
        titulo = new JLabel("<html><span style='color: teal;'>Comida</span></html>");
        c.gridx = 0;
        c.gridy = 0;
        panelIzquierdo.add(titulo, c);
        c.gridx = 0;
        c.gridy = 2;   
        panelIzquierdo.add(new JScrollPane(tablaComidas), c);

        
        //Añadimos sección de Bebida
        //Creamos tabla Bebida
        //Se definen los títulos  
        modeloBebidas.addColumn("Nombre");
        modeloBebidas.addColumn("Precio");  
        //Se llena la tabla con la información que viene desde el controlador
        // modeloBebidas = llenarTabla(modeloBebidas, bebidas);
        tablaBebidas.setModel(modeloBebidas);   
        titulo = new JLabel("<html><span style='color: teal;'>Bebidas</span></html>");
        c.gridx = 0;
        c.gridy = 0;
        panelCentro.add(titulo, c);
        c.gridx = 0;
        c.gridy = 2;   
        panelCentro.add(new JScrollPane(tablaBebidas), c);
        
        //Añadimos sección de Postres
        //Creamos tabla Postres
        //Se definen los títulos  
        modeloPostres.addColumn("Nombre");
        modeloPostres.addColumn("Precio");  
        //Se llena la tabla con la información que viene desde el controlador
        // modeloPostres = llenarTabla(modeloPostres, postres);
        tablaPostres.setModel(modeloPostres);     
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

    //Llena a tabla a partir de la información que el controlador nos da
    private void llenarTabla (String [][] data){
        

        //Se definen los títulos  
        


        
        modeloComidas.setRowCount(0);
        
        Object [] fila = new Object[2];
        
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i][0]);
            System.out.println(data[i][1]);
            fila[0] = data[i][0];
            fila[1] = data[i][1];
            modeloComidas.addRow(fila);  
        }
        
        tablaComidas.setModel(modeloComidas); 
        modeloComidas.fireTableDataChanged();
        tablaComidas.setVisible(true);
        
    }
    // private void buildContractorResultTable(){
    //     DefaultTableModel model = tablaComidas.getModel();
    //     model.setDataVector(modeloComidas.getMatchingCriteria(), aModel.getColumnNames());
    // }
}
