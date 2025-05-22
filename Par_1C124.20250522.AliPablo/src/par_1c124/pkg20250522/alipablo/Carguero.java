package par_1c124.pkg20250522.alipablo;

/**
 *
 * @author pablo
 */
public class Carguero extends Nave implements Explorador{
    private Double capacidadCarga;
    

    public Carguero(Double capacidadCarga, String nombre, int capacidadTripulacion, int anioLanzamiento) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.capacidadCarga = capacidadCarga;
    }



    public Double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void explorar() {
        System.out.println("El carguero " + nombre + " ha iniciado la exploración");
    }
    
    @Override
    public String toString(){
        return "Carguero [Nombre: " + nombre + " | Cap. Tripulación: " + capacidadTripulacion + " | Año Lanzamiento: " + anioLanzamiento + " | Capacidad de carga: " + capacidadCarga + "]";
    }
}
