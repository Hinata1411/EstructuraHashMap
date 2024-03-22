import java.io.Serializable;

public class RegistrodeVacuna implements Serializable {
    //La clase RegistrodeVacuna hereda de la clase Serializable del paquete de java
    //que sirve para crear de un objeto una secuencia de bytes que puede ser leido

    //Creamos variables privadas siguiendo el principio de Encapsulamiento para los datos
    //Personales como cui, vacuna, y fecha.
    private String cui;
    private String vacuna;
    private String fecha;


    //Constructor
    public RegistrodeVacuna(String cui, String vacuna, String fecha){
        this.cui = cui;
        this.vacuna = vacuna;
        this.fecha = fecha;
    }

    //Getters y Setters
    public String getCui(){
        return cui;
    }
    public void setCui(String cui){
        this.cui = cui;
    }
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public String getVacuna(){
        return vacuna;
    }
    public void setVacuna(String vacuna){
        this.vacuna = vacuna;
    }

    @Override
    public String toString(){
        return "Cui: " + cui + "Fecha: " + fecha + "Vacuna: " + vacuna;
    }

}
