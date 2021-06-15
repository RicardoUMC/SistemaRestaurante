package mvc;
import mvc.Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import mvc.clases.Repartidor;
import mvc.clases.Comida;
import mvc.clases.Bebida;
import mvc.clases.Postre;

public class Controlador{
    
    Modelo modelo;
    Vista vista;
    MenuPrincipal menuPrincipal;
    MenuDelDia menuDelDia;

    public Controlador(Modelo m, Vista v) {
        modelo = m;
        vista = v;
        menuPrincipal = v.menuPrincipal;
        menuDelDia = v.menuDelDia;
    }

    public void iniciarVista(){
        this.menuPrincipal.mostrar();
        this.menuPrincipal.btnMostrarMenu.addActionListener(listenerMenu);
        this.menuPrincipal.btnPedido.addActionListener(listenerMenu);
        this.menuPrincipal.btnRegRepartidor.addActionListener(listenerMenu);
        this.menuPrincipal.btnRegPlatilo.addActionListener(listenerMenu);
        this.menuPrincipal.btnRegRestaurante.addActionListener(listenerMenu);
        this.menuPrincipal.btnSalir.addActionListener(listenerMenu);
    }

    ActionListener listenerMenu = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(menuPrincipal.btnMostrarMenu == e.getSource()) {
                menuDelDia.mostrar();
            }

            else if(menuPrincipal.btnPedido == e.getSource()) {
                //realizarPedido
            }

            else if(menuPrincipal.btnRegRepartidor == e.getSource()) {

                //Si no se han registrado datos del restaurante, no podemos crear repartidores

                if(existeRestaurante()){
                    //Mensajes que se mostrarán al usuario
                    String nomRep = "Nombre del repartidor: "; 
                    String apeRep = "Apellido del repartidor: ";
                    String edRep = "Edad del repartidor: ";
                    String genRep = "Género del repartidor (F o M):";
                    String transRep = "Medio de transporte: ";
                    String tiemRep = "Tiempo promedio de llegada (minutos): "; 
                    String calRep = "Calificación de 1 - 5 estrellas: ";
    
                    //Pedimos datos del repartidor
                    String nombre = validString(JOptionPane.showInputDialog(nomRep), nomRep);
                    String apellido = validString(JOptionPane.showInputDialog(apeRep), apeRep);
                    int edad = validInt(validString(JOptionPane.showInputDialog(edRep), edRep), edRep);
                    //Se valida solamente F o M
                    String[] options = {"F", "M"};
                    String n = (String) JOptionPane.showInputDialog(null, genRep, null, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    char genero = n.charAt(0);
                    String medioTransporte = validString(JOptionPane.showInputDialog(transRep), transRep);
                    int tiempoLlegada = validInt(validString(JOptionPane.showInputDialog(tiemRep), tiemRep), tiemRep);
                    float calificacion = validRango(validFloat(JOptionPane.showInputDialog(calRep), calRep), calRep);
    
                    //Registramos los datos del repartidor (instanciamos persona y repartidor)
                    Repartidor repartidor = new Repartidor(nombre, apellido, edad, genero, medioTransporte, tiempoLlegada, calificacion);
    
                    //Guardamos en el arreglo de repartidores, que se encuentra en la clase Restaurante, la cual se invoca desde modelo
                    modelo.guardarRepartidor(repartidor);
                    JOptionPane.showMessageDialog(null, "El repartidor se ha guardado correctamente.");
                    
                    return;
                }

                JOptionPane.showMessageDialog(null, "No puede crear un repartidor sin antes registrar los datos del restaurante.");


            }

            else if(menuPrincipal.btnRegPlatilo == e.getSource()) {
                //Si no se han registrado datos del restaurante, no podemos crear platillos
                if(existeRestaurante()){
                    //Mensajes que se mostrarán al usuario
                    String nomComida = "Nombre de la comida: "; 
                    String preComida = "Precio de la comida: ";
                    String ingComida = "Ingredientes de la comida: ";
                    String nomBebida = "Nombre de la bebida: ";
                    String preBebida = "Precio de la bebida: ";
                    String nomPostre = "Nombre del postre: ";
                    String prePostre = "Precio del postre: ";
                    String ingPostre = "Ingredientes del postre: ";

                    //Hacemos referencia al objeto
                    Comida c = new Comida();
                    Bebida b = new Bebida();
                    Postre p = new Postre();

                    //Pedimos datos del platillo
                    //Datos de comida
                    c.setNombre(validString(JOptionPane.showInputDialog(nomComida), nomComida));
                    c.setprecio(validFloat(JOptionPane.showInputDialog(preComida), preComida));
                    c.setingredientes(validString(JOptionPane.showInputDialog(ingComida), ingComida));

                    //Datos de la bebida
                    b.setNombre(validString(JOptionPane.showInputDialog(nomBebida), nomBebida));
                    b.setprecio(validFloat(JOptionPane.showInputDialog(preBebida), preBebida));

                    //Datos del postre
                    p.setNombre(validString(JOptionPane.showInputDialog(nomPostre), nomPostre));
                    p.setprecio(validFloat(JOptionPane.showInputDialog(prePostre), prePostre));
                    p.setingredientes(validString(JOptionPane.showInputDialog(ingPostre), ingPostre));

                    //Agregamos la comida, la bebida y el platillo a los ListArray
                    modelo.guardarPlatillo(c, b, p);


                    return;
                }

                JOptionPane.showMessageDialog(null, "No puede crear un repartidor sin antes registrar los datos del restaurante.");
                
            }

            else if(menuPrincipal.btnRegRestaurante == e.getSource()) {
                //Pedimos datos al usuario
                String nombre = validString(JOptionPane.showInputDialog("Nombre del restaurante: "), "Ingrese un nombre válido: ");
                String ubicacion = validString(JOptionPane.showInputDialog("Ubicación (dirección) del restaurante: "), "Ingrese una dirección válida: ");
                String telefono = validString(JOptionPane.showInputDialog("Teléfono del restaurante: "), "Ingrese un teléfono válido: ");

                //Registramos los datos del restaurante
                modelo.registrarDatosRestaurante(nombre, ubicacion, telefono);

                //Asignamos dichos datos a los labels del menu
                menuPrincipal.nombreRestaurante.setText(modelo.miRestaurante.getNombre());
                menuPrincipal.ubicacionRestaurante.setText(modelo.miRestaurante.getUbicacion());
                menuPrincipal.telefonoRestaurante.setText(modelo.miRestaurante.getTelefono());
            }

            else if(menuPrincipal.btnSalir == e.getSource()) {
                System.exit(0);
            }


        }
    };

    private boolean existeRestaurante(){
        if(modelo.miRestaurante != null){
            return true;
        }

        return false;
        
    }

    //Metodo recursivo para validar que la entrada de texto no sea nula
    //Primer parametro es el texto a validar, el segundo parametro es el mensaje para pedir un dato valido
    private String validString(String validacion, String mensajeVal) {
        if (!"".equals(validacion)) {
            try{
                return validacion;
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo registrar el valor apropiadamente.");
            }
        }
        return validString(JOptionPane.showInputDialog(mensajeVal), mensajeVal);
    }

    private int validInt(String validacion, String mensajeVal) { 
        try {
            return Integer.parseInt(validacion);
        } catch (NumberFormatException a) {
            return validInt(validString(JOptionPane.showInputDialog(mensajeVal), mensajeVal), mensajeVal);
        }
    }

    private float validFloat(String validacion, String mensajeVal) { 
        try {
            return Float.parseFloat(validacion);
        } catch (NumberFormatException a) {
            return validInt(validString(JOptionPane.showInputDialog(mensajeVal), mensajeVal), mensajeVal);
        }
    }

    private float validRango(float validacion, String mensajeVal){
        if(validacion >= 0 && validacion <= 5){
            try{
                return validacion;
            }
            catch(NumberFormatException a){
                JOptionPane.showMessageDialog(null, "No se pudo registrar el valor apropiadamente.");
            }
        }
        return validRango(validFloat(JOptionPane.showInputDialog(mensajeVal), mensajeVal), mensajeVal);
    }
}
