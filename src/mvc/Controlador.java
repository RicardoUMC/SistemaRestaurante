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
    CrearPedido crearPedido;
   
    public Controlador(Modelo m, Vista v) {
        modelo = m;
        vista = v;
        menuPrincipal = v.menuPrincipal;
        menuDelDia = v.menuDelDia;
        crearPedido = v.crearPedido;
        
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
                    if (modelo.platillos()) {

                        String comidas [][] = obtenerComidas();
                        String bebidas [][] = obtenerBebidas();
                        String postres [][] = obtenerPostres();
                        
                        //Le pasamos esta información a la ventana que muestra el menú del día
                        menuDelDia.mostrar(comidas, bebidas, postres);
                        
                        return;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Aún no se registran platillos.");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "No puede ver el menú sin antes registrar los datos del restaurante.");
            }
            //Realizar Pedido
            else if(menuPrincipal.btnPedido == e.getSource()) {

                //Si no se han registrado los datos del Restaurante, no podemos crear platillos
                if (existeRestaurante()){
                    
                    if (modelo.platillos()) {
                        //------------LO QUE AGREGO------------//
                        String repartidores[][];
                        String comidas[][];
                        String bebidas[][];
                        String postres[][];
                        
                        //Si no hay repartidores no habrá quien entregue el pedido, por eso lo validamos primero
                        try {
                            repartidores = obtenerRepartidores();
                            
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(null, "No tenemos repartidores disponibles para tu solicitud.");
                            return;
                        }
                        
                        //Se registra al primer cliente
                        if (modelo.miRestaurante.getCliente() == null){
                            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
                            modelo.miRestaurante.setCliente(clientes);
                        }
                        
                        //Hacemos referencia al objeto que nos ayude a registrar el platillo en el ListArray
                        modelo.regCliente = new Cliente();
                        //Pedimos datos del Cliente
                        modelo.regCliente.setNombre(validString(JOptionPane.showInputDialog(modelo.nomCli), modelo.nomCli));
                        modelo.regCliente.setApellido(validString(JOptionPane.showInputDialog(modelo.apeCli), modelo.apeCli));
                        modelo.regCliente.setEdad(validInt(validString(JOptionPane.showInputDialog(modelo.EdCli), modelo.EdCli), modelo.EdCli));
                        //Se valida solamente F o M
                        String[] options = {"F", "M"};
                        String n = (String) JOptionPane.showInputDialog(null, modelo.genRep, null, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        modelo.regCliente.setGenero(n.charAt(0));
                        modelo.regCliente.setNumTel(validInt(validString(JOptionPane.showInputDialog(modelo.TelCli), modelo.TelCli), modelo.TelCli));
                        modelo.regCliente.setDireccion(validString(JOptionPane.showInputDialog(modelo.DirCli), modelo.DirCli));
                        
                        try {
                            modelo.guardarCliente(modelo.regCliente);
                            JOptionPane.showMessageDialog(null, "Los datos del cliente se han guardado correctamente.");
                        } catch (NullPointerException nullPointer) {
                            JOptionPane.showMessageDialog(null, "No se pudo completar.");
                        }
                        
                        comidas = obtenerComidas();
                        bebidas = obtenerBebidas();
                        postres = obtenerPostres();
                            
                        //Le pasamos esta información a la ventana que muestra el menú del día
                        crearPedido.mostrar(comidas, bebidas, postres, repartidores);
                        return;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Aún no se registran platillos.");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "No se puede realizar un pedido sin antes registrar los datos del restaurante.");
            
                //realizarPedido
            }
            //Registrar repartidores
            else if(menuPrincipal.btnRegRepartidor == e.getSource()) {
                //Si no se han registrado datos del restaurante, no podemos crear repartidores
                if(existeRestaurante()){
                    //Primera vez registrando a un repartidor
                    if (modelo.miRestaurante.getRepartidores() == null){
                        ArrayList<Repartidor> repartidor = new ArrayList<Repartidor>();
                        modelo.miRestaurante.setRepartidores(repartidor);
                    }

                    //Hacemos referencia al objeto que nos ayude a registrar el platillo en el ListArray
                    modelo.regRepartidor = new Repartidor();
                    //Pedimos datos del repartidor
                    modelo.regRepartidor.setNombre(validString(JOptionPane.showInputDialog(modelo.nomRep), modelo.nomRep));
                    modelo.regRepartidor.setApellido(validString(JOptionPane.showInputDialog(modelo.apeRep), modelo.apeRep));
                    modelo.regRepartidor.setEdad(validInt(validString(JOptionPane.showInputDialog(modelo.edRep), modelo.edRep), modelo.edRep));
                    //Se valida solamente F o M
                    String[] options = {"F", "M"};
                    String n = (String) JOptionPane.showInputDialog(null, modelo.genRep, null, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    modelo.regRepartidor.setGenero(n.charAt(0));
                    modelo.regRepartidor.setRepartidorNo(validInt(validString(JOptionPane.showInputDialog(modelo.noRep), modelo.noRep), modelo.noRep));
                    modelo.regRepartidor.setMedioTransporte(validString(JOptionPane.showInputDialog(modelo.transRep), modelo.transRep));
                    modelo.regRepartidor.setCalificacion(validRango(validFloat(validString(JOptionPane.showInputDialog(modelo.calRep), modelo.calRep), modelo.calRep), modelo.calRep));

                    try {
                        modelo.guardarRepartidor(modelo.regRepartidor);
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
                    //Primera vez registrando un platillo
                    if (!modelo.platillos()) {
                        //Se instancian objetos de las clases de miRestaurante
                        ArrayList<Comida> comidas = new ArrayList<Comida>();
                        ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
                        ArrayList<Postre> postres = new ArrayList<Postre>();
                        modelo.miRestaurante.setComidas(comidas);
                        modelo.miRestaurante.setBebidas(bebidas);
                        modelo.miRestaurante.setPostres(postres);
                    }
                    
                    //Hacemos referencia al objeto que nos ayude a registrar el platillo en el ListArray
                    modelo.regComida = new Comida();
                    modelo.regBebida = new Bebida();
                    modelo.regPostre = new Postre();
                    //Pedimos datos del platillo
                    //Datos de comida
                    modelo.regComida.setNombre(validString(JOptionPane.showInputDialog(modelo.nomComida), modelo.nomComida));
                    modelo.regComida.setPrecio(validFloat(JOptionPane.showInputDialog(modelo.preComida), modelo.preComida));
                    modelo.regComida.setIngredientes(validString(JOptionPane.showInputDialog(modelo.ingComida), modelo.ingComida));
                    
                    //Datos de la bebida
                    modelo.regBebida.setNombre(validString(JOptionPane.showInputDialog(modelo.nomBebida), modelo.nomBebida));
                    modelo.regBebida.setPrecio(validFloat(JOptionPane.showInputDialog(modelo.preBebida), modelo.preBebida));
                    
                    //Datos del postre
                    modelo.regPostre.setNombre(validString(JOptionPane.showInputDialog(modelo.nomPostre), modelo.nomPostre));
                    modelo.regPostre.setPrecio(validFloat(JOptionPane.showInputDialog(modelo.prePostre), modelo.prePostre));
                    modelo.regPostre.setIngredientes(validString(JOptionPane.showInputDialog(modelo.ingPostre), modelo.ingPostre));


                    try {
                        modelo.guardarPlatillo(modelo.regComida, modelo.regBebida, modelo.regPostre);
                        JOptionPane.showMessageDialog(null, "El platillo se ha guardado correctamente.");
                    } catch (NullPointerException nullPointer) {
                        JOptionPane.showMessageDialog(null, "No se pudo completar.");
                    }
                    return;
                }
                JOptionPane.showMessageDialog(null, "No puede crear un platillo sin antes registrar los datos del restaurante.");                
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

    private String [][] obtenerRepartidores(){
        //Contamos las Repartidores que hay registradas
        int cantidadRepartidor = modelo.miRestaurante.getRepartidores().size();

        //Creamos el arreglo para posteriormente pasarlo a la tabla del menú
        String Repartidores [][] = new String[cantidadRepartidor][cantidadRepartidor + 1];

        //Extraemos las Repartidores que hay registradas
        for (int i = 0; i < cantidadRepartidor; i++) {
            
            if(i < Repartidores.length){
                Repartidores [i][0] = modelo.miRestaurante.getRepartidores().get(i).getNombre();
                Repartidores [i][1] = String.valueOf(modelo.miRestaurante.getRepartidores().get(i).getRepartidorNo());
            }
        }

        return Repartidores;
    }

    private boolean existeRestaurante(){
        if(modelo.miRestaurante != null){
            return true;
        }
        return false;
    }

    //Metodos recursivos para validar que la entrada de texto no sea nula o incongruente al que se pide
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
