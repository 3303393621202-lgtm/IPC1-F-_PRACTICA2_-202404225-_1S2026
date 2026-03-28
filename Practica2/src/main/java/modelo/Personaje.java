
package modelo;

public class Personaje {
    //innicializar variables
    private String codigo;
    private String nombre;
    private String casa;
    private String escoba;
    private int puntos;

        //constructor
    
    public Personaje() {
    }

    public Personaje(String codigo, String nombre, String casa, String escoba, int puntos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.casa = casa;
        this.escoba = escoba;
        this.puntos = puntos;
    }
    
    //getters and setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCasa() {
        return casa;
    }
    public void setCasa(String casa) {
        this.casa = casa;
    }
    public String getEscoba() {
        return escoba;
    }
    public void setEscoba(String escoba) {
        this.escoba = escoba;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    // Método para definir la velocidad (función)
    public int getVelocidad() {
        switch (escoba) {
            case "Nimbus 2000" -> {
                return 3000;
            }
            case "Nimbus 2001" -> {
                return 2000;
            }
            case "Saeta de Fuego" -> {
                return 1000;
            }
        }
        return 3000;
    }

    public void sumarPuntos(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}