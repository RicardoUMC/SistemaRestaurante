package mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import mvc.clases.Repartidor;

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

            else if(vista.btnPedido == e.getSource()) {
                //realizarPedido
            }

            else if(vista.btnRegRepartidor == e.getSource()) {

                //Si no se han registrado datos del restaurante, no podemos crear repartidores
                if(modelo.miRestaurante == null){
                    JOptionPane.showMessageDialog(null, "No puede crear un repartidor sin antes registrar los datos del restaurante.");
                    return;
                }

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
                //TODO: Comprobar que el string pase a flotante y esté en el rango solicitado
                float calificacion = validRango(validFloat(JOptionPane.showInputDialog(calRep), calRep), calRep);

                //Registramos los datos del repartidor (instanciamos persona y repartidor)
                Repartidor repartidor = new Repartidor(nombre, apellido, edad, genero, medioTransporte, tiempoLlegada, calificacion);

                //Guardamos en el arreglo de repartidores, que se encuentra en la clase Restaurante, la cual se invoca desde modelo
                modelo.guardarRepartidor(repartidor);
                JOptionPane.showMessageDialog(null, "El repartidor se ha guardado correctamente.");

            }

            else if(vista.btnRegPlatilo == e.getSource()) {
                //regsitrarPlatillo
                
            }

            else if(vista.btnRegRestaurante == e.getSource()) {
                //Pedimos datos al usuario
                String nombre = validString(JOptionPane.showInputDialog("Nombre del restaurante: "), "Ingrese un nombre válido: ");
                String ubicacion = validString(JOptionPane.showInputDialog("Ubicación (dirección) del restaurante: "), "Ingrese una dirección válida: ");
                String telefono = validString(JOptionPane.showInputDialog("Teléfono del restaurante: "), "Ingrese un teléfono válido: ");

                //Registramos los datos del restaurante
                modelo.registrarDatosRestaurante(nombre, ubicacion, telefono);

                //Asignamos dichos datos a los labels del menu
                vista.nombreRestaurante.setText(modelo.miRestaurante.getNombre());
                vista.ubicacionRestaurante.setText(modelo.miRestaurante.getUbicacion());
                vista.telefonoRestaurante.setText(modelo.miRestaurante.getTelefono());
            }

            else if(vista.btnSalir == e.getSource()) {
                System.exit(0);
            }


        }
    };

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
        if(validacion > 0 && validacion < 5){
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
