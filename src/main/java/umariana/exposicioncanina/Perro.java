
package umariana.exposicioncanina;

/**
 * @author JULIANA MUÑOZ
 * @author DANNA LAGOS
 */
public class Perro {
     //Atributos
    private String nombre;
    private int edadMeses;
    private String raza;
    private double puntaje;
    private String foto;
    
    //Metodos 
    
        public Perro(){
            //vacio
        }
        public Perro(String nombre, int edadMeses, String raza, double puntaje, String foto ){
        this.nombre = nombre;
        this.edadMeses = edadMeses;
        this.raza = raza; 
        this.puntaje = puntaje;
        this.foto = foto; 
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(int edadMeses) {
        this.edadMeses = edadMeses;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
        
        
    
}
