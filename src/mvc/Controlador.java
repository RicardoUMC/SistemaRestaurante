package mvc;
import mvc.Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import mvc.clases.*;

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
            //Mostrar menu
            if(menuPrincipal.btnMostrarMenu == e.getSource()) {
                //Si no se han registrado los datos del Restaurante, no podemos crear platillos
                if (existeRestaurante()){

                    String comidas [][] = obtenerComidas();
                    String bebidas [][] = obtenerBebidas();
                    String postres [][] = obtenerPostres();

                    //Le pasamos esta información a la ventana que muestra el menú del día
                    menuDelDia.mostrar(comidas, bebidas, postres);

                    return;
                }
                JOptionPane.showMessageDialog(null, "No puede ver el menú sin antes registrar los datos del restaurante.");
            }
            //Realizar Pedido
            else if(menuPrincipal.btnPedido == e.getSource()) {
                //realizarPedido
            }
            //Registrar repartidores
            else if(menuPrincipal.btnRegRepartidor == e.getSource()) {
                //Si no se han registrado datos del restaurante, no podemos crear repartidores
                if(existeRestaurante()){
                    //Mensajes que se mostrarán al usuario
                    String nomRep = "Nombre del repartidor: "; 
                    String apeRep = "Apellido del repartidor: ";
                    String edRep = "Edad del repartidor: ";
                    String genRep = "Género del repartidor (F o M):";
                    String noRep = "Asigne un numero de repartidor: "; 
                    String transRep = "Medio de transporte: ";
                    String calRep = "Calificacion del repartidor (1 - 5): ";
    
                    //Hacemos referencia al objeto que nos ayude a registrar el platillo en el ListArray
                    modelo.regRepartidor = new Repartidor();  
                    modelo.miRestaurante.repartidores = new ArrayList<Repartidor>();
                    
                    //Pedimos datos del repartidor
                    modelo.regRepartidor.setNombre(validString(JOptionPane.showInputDialog(nomRep), nomRep));
                    modelo.regRepartidor.setApellido(validString(JOptionPane.showInputDialog(apeRep), apeRep));
                    modelo.regRepartidor.setEdad(validInt(validString(JOptionPane.showInputDialog(edRep), edRep), edRep));
                    //Se valida solamente F o M
                    String[] options = {"F", "M"};
                    String n = (String) JOptionPane.showInputDialog(null, genRep, null, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    modelo.regRepartidor.setGenero(n.charAt(0));
                    modelo.regRepartidor.setRepartidorNo(validInt(validString(JOptionPane.showInputDialog(noRep), noRep), noRep));
                    modelo.regRepartidor.setMedioTransporte(validString(JOptionPane.showInputDialog(transRep), transRep));
                    modelo.regRepartidor.setCalificacion(validRango(validFloat(validString(JOptionPane.showInputDialog(calRep), calRep), calRep), calRep));

                    try {
                        modelo.miRestaurante.repartidores.add(modelo.regRepartidor);
                        JOptionPane.showMessageDialog(null, "El repartidor se ha guardado correctamente.");
                    } catch (NullPointerException nullPointer) {
                        JOptionPane.showMessageDialog(null, "No se pudo completar.");
                    }
                    return;                    
                }
                JOptionPane.showMessageDialog(null, "No puede crear un repartidor sin antes registrar los datos del restaurante.");
            }
            //Registrar platillos
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

                    //Hacemos referencia al objeto que nos ayude a registrar el platillo en el ListArray
                    modelo.regComida = new Comida();
                    modelo.regBebida = new Bebida();
                    modelo.regPostre = new Postre();
                    
                    //Pedimos datos del platillo
                    //Datos de comida
                    modelo.regComida.setNombre(validString(JOptionPane.showInputDialog(nomComida), nomComida));
                    modelo.regComida.setPrecio(validFloat(JOptionPane.showInputDialog(preComida), preComida));
                    modelo.regComida.setIngredientes(validString(JOptionPane.showInputDialog(ingComida), ingComida));
                    
                    //Datos de la bebida
                    modelo.regBebida.setNombre(validString(JOptionPane.showInputDialog(nomBebida), nomBebida));
                    modelo.regBebida.setPrecio(validFloat(JOptionPane.showInputDialog(preBebida), preBebida));
                    
                    //Datos del postre
                    modelo.regPostre.setNombre(validString(JOptionPane.showInputDialog(nomPostre), nomPostre));
                    modelo.regPostre.setPrecio(validFloat(JOptionPane.showInputDialog(prePostre), prePostre));
                    modelo.regPostre.setIngredientes(validString(JOptionPane.showInputDialog(ingPostre), ingPostre));
                    
                    //Agregamos la comida, la bebida y el platillo a los ListArray
                    //modelo.miRestaurante.getComidas().add(modelo.regComida);
                    //modelo.miRestaurante.getBebidas().add(modelo.regBebida);
                    //modelo.miRestaurante.getPostres().add(modelo.regPostre);
                    
                    try {
                        modelo.guardarPlatillo(modelo.regComida, modelo.regBebida, modelo.regPostre);
                        JOptionPane.showMessageDialog(null, "El postre se ha guardado correctamente.");
                    } catch (NullPointerException nullPointer) {
                        JOptionPane.showMessageDialog(null, "No se pudo completar.");
                    }

                    return;
                }
                JOptionPane.showMessageDialog(null, "No puede crear un repartidor sin antes registrar los datos del restaurante.");                
            }
            //Registrar restaurante
            else if(menuPrincipal.btnRegRestaurante == e.getSource()) {
                //Instanciamos un Restaurante
                modelo.miRestaurante = new Restaurante();
                //Pedimos datos al usuario y registramos los datos
                modelo.miRestaurante.setNombre(validString(JOptionPane.showInputDialog("Nombre del restaurante: "), "Ingrese un nombre válido: "));
                modelo.miRestaurante.setUbicacion(validString(JOptionPane.showInputDialog("Ubicación (dirección) del restaurante: "), "Ingrese una dirección válida: "));
                modelo.miRestaurante.setTelefono(validString(JOptionPane.showInputDialog("Teléfono del restaurante: "), "Ingrese un teléfono válido: "));
                //Asignamos dichos datos a los labels del menu
                menuPrincipal.nombreRestaurante.setText(modelo.miRestaurante.getNombre());
                menuPrincipal.ubicacionRestaurante.setText(modelo.miRestaurante.getUbicacion());
                menuPrincipal.telefonoRestaurante.setText(modelo.miRestaurante.getTelefono());
            }
            //Salir
            else if(menuPrincipal.btnSalir == e.getSource()) {
                System.exit(0);
            }
        }
    };

    private String [][] obtenerComidas(){
        //Contamos las comidas que hay registradas
        int cantidadComidas = modelo.miRestaurante.getComidas().size();

        //Creamos el arreglo para posteriormente pasarlo a la tabla del menú
        String comidas [][] = new String[cantidadComidas][cantidadComidas + 1];

        //Extraemos las comidas que hay registradas
        for (int i = 0; i < cantidadComidas; i++) {
            
            if(i < comidas.length){
                comidas [i][0] = modelo.miRestaurante.getComidas().get(i).getNombre();
                comidas [i][1] = String.valueOf(modelo.miRestaurante.getComidas().get(i).getPrecio());
            }
        }

        return comidas;
    }

    private String [][] obtenerBebidas(){
        //Contamos las Bebidas que hay registradas
        int cantidadBebidas = modelo.miRestaurante.getBebidas().size();

        //Creamos el arreglo para posteriormente pasarlo a la tabla del menú
        String bebidas [][] = new String[cantidadBebidas][cantidadBebidas + 1];

        //Extraemos las Bebidas que hay registradas
        for (int i = 0; i < cantidadBebidas; i++) {
            
            if(i < bebidas.length){
                bebidas [i][0] = modelo.miRestaurante.getBebidas().get(i).getNombre();
                bebidas [i][1] = String.valueOf(modelo.miRestaurante.getBebidas().get(i).getPrecio());
            }
        }

        return bebidas;
    }

    private String [][] obtenerPostres(){
        //Contamos las postres que hay registradas
        int cantidadPostres = modelo.miRestaurante.getPostres().size();

        //Creamos el arreglo para posteriormente pasarlo a la tabla del menú
        String postres [][] = new String[cantidadPostres][cantidadPostres + 1];

        //Extraemos las postres que hay registradas
        for (int i = 0; i < cantidadPostres; i++) {
            
            if(i < postres.length){
                postres [i][0] = modelo.miRestaurante.getPostres().get(i).getNombre();
                postres [i][1] = String.valueOf(modelo.miRestaurante.getPostres().get(i).getPrecio());
            }
        }

        return postres;
    }


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
            return validFloat(validString(JOptionPane.showInputDialog(mensajeVal), mensajeVal), mensajeVal);
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
