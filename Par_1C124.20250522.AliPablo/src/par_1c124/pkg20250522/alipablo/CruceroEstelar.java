package par_1c124.pkg20250522.alipablo;

/**
 *
 * @author pablo
 */
public class CruceroEstelar extends Nave{
    private int cantidadPasajeros;

    public CruceroEstelar(int cantidadPasajeros, String nombre, int capacidadTripulacion, int anioLanzamiento) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }
    
    @Override
    public String toString(){
        return "Nave de Exploración [Nombre: " + nombre + " | Cap. Tripulación: " + capacidadTripulacion + " | Año Lanzamiento: " + anioLanzamiento + " | Pasajeros: " + cantidadPasajeros + "]";
    }
}
