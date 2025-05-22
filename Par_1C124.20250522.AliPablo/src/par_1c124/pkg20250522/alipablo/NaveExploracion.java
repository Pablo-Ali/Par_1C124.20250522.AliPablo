package par_1c124.pkg20250522.alipablo;

/**
 *
 * @author pablo
 */
public class NaveExploracion extends Nave implements Explorador{

    private String mision;

    public NaveExploracion(String mision, String nombre, int capacidadTripulacion, int anioLanzamiento) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.mision = mision;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    @Override
    public void explorar() {
        System.out.println("La nave de exploración " + nombre + " ha iniciado la exploración");
    }
    
    @Override
    public String toString(){
        return "Nave de Exploración [Nombre: " + nombre + " Cap. Tripulación: " + capacidadTripulacion + " Año Lanzamiento: " + anioLanzamiento + " Misión: " + mision + "]";
    }

}
