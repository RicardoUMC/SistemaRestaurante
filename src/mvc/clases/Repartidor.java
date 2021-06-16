package mvc.clases;

public class Repartidor extends Persona {

    protected int repartidorNo;    
    protected String medioTransporte;
    protected float calificacion;    

    public Repartidor() {}

    public Repartidor(String nombre, String apellido, int edad, char genero,int repartidorNo,String medioTransporte){

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.repartidorNo= repartidorNo;
        this.medioTransporte = medioTransporte;
    }
    @Override
    public void setNombre(String nombre){

        this.nombre = nombre;
    }
    @Override
    public String getNombre(){

        return nombre;      
    }
    @Override
    public void setApellido(String apellido) {
        
        this.apellido = apellido;
        
    }
    @Override
    public String getApellido() {
        
        return apellido;
    }
    @Override
    public void setEdad(int edad) {
        
        this.edad = edad;
        
    }
    @Override
    public int getEdad() {
        
        return edad;
    }

    @Override
    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public char getGenero() {
        return genero;
    }
    public void setRepartidorNo(int repartidorNo){

        this.repartidorNo = repartidorNo;

    }

    public int getRepartidorNo(){

        return repartidorNo;

    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public float getCalificacion() {
        return calificacion;
    }

}
