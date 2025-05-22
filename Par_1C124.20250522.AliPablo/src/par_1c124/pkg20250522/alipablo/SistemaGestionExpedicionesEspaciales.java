package par_1c124.pkg20250522.alipablo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class SistemaGestionExpedicionesEspaciales {
    //Dos naves se consideran iguales si tienen el mismo nombre y el mismo año de lanzamiento.
    
    public static void main(String[]args){
        int opcion;

        Scanner console = new Scanner(System.in);
        
        List<Nave> listaNaves = new ArrayList<>();
        
        Nave nave;

        do {
            System.out.println("\n ===MENÚ DE GESTIÓN DE EXPEDICIONES ESPACIALES=== \n");
            System.out.println("1. Agregar nave");
            System.out.println("2. Mostrar todas las naves");
            System.out.println("3. Iniciar exploración");
            System.out.println("4. Mostrar naves ordenadas por nombre");
            System.out.println("5. Mostrar naves ordenadas por año de lanzamiento (desc)");
            System.out.println("6. Mostrar naves ordenadas por tripulación (desc)");
            System.out.println("7. Salir");

            opcion = console.nextInt();

            switch (opcion) {
                case 1:
                    agregarNave(listaNaves, console);
                    break;

                case 2:
                    mostrarNaves(listaNaves);
                    break;

                case 3:
                    iniciarExploracion(listaNaves);
                    break;

                case 4:
                    
                    break;

                case 5:
                    ordenarPorAnio(listaNaves, new ComparadorAnio());
                    break;
                
                case 6:
                    
                    break;
                    
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 7);
    }
    
    public static boolean compararExistente(Nave nave, List<Nave> listaNaves) {
        return !listaNaves.contains(nave);
    }
    
    public static void agregarNave(List<Nave> listaNaves, Scanner console){
        Nave nave;
        
        int opcion;
        String nombre;
        int anioLanzamiento;
        int capacidadTripulacion;
        String mision;
        Double capacidadCarga;
        int cantidadPasajeros;
        
        do {
            System.out.println("\n ---Tipo de Nave--- \n");
            System.out.println("1. Nave de exploración");
            System.out.println("2. Carguero");
            System.out.println("3. Crucero espacial");
            System.out.println("4. Volver al menú");

            opcion = console.nextInt();
            

            switch (opcion) {
                case 1:
                    // Consumo el salto de linea del nextInt
                    console.nextLine();
                    
                    do {
                        System.out.println("Ingrese la Misión:\nCARTOGRAFIA\nINVESTIGACION\nCONTACTO");
                        mision = console.nextLine().toUpperCase();
                    } while (!mision.equals("CARTOGRAFIA") && !mision.equals("INVESTIGACION") && !mision.equals("CONTACTO"));
                           
                    do{
                        System.out.println("Ingrese el nombre de la nave");
                        nombre = console.nextLine();
                    }while(nombre.isEmpty());
                    

                    do{
                        System.out.println("Ingrese la capacidad de tripulación");
                        capacidadTripulacion = console.nextInt();
                    }while(capacidadTripulacion < 1);
                    
                    //falta validar
                    System.out.println("Ingrese el año del lanzamiento");
                    anioLanzamiento = console.nextInt();
                    
                    nave = new NaveExploracion(mision, nombre,capacidadTripulacion, anioLanzamiento);

                    if (compararExistente(nave, listaNaves)) {
                        listaNaves.add(nave);
                        System.out.println("Nave cargada correctamente");
                    } else {
                        System.out.println("\nLa nave ya existe");
                    }
                    
                    break;

                case 2:

                    do{
                        System.out.println("Ingrese la capacidad de carga (Entre 100 y 500)");
                        capacidadCarga = console.nextDouble();
                    }while(capacidadCarga < 100 || capacidadCarga > 500);
                    
                    // Consumo el salto de linea del nextDouble
                    console.nextLine();       
                    
                    do{
                        System.out.println("Ingrese el nombre de la nave");
                        nombre = console.nextLine();
                    }while(nombre.isEmpty());
                    
                    
                    do{
                        System.out.println("Ingrese la capacidad de tripulación");
                        capacidadTripulacion = console.nextInt();
                    }while(capacidadTripulacion < 1);
                    
                    //falta validar
                    System.out.println("Ingrese el año del lanzamiento");
                    anioLanzamiento = console.nextInt();
                    
                    nave = new Carguero(capacidadCarga, nombre, capacidadTripulacion, anioLanzamiento);
                    
                    if (compararExistente(nave, listaNaves)) {
                        listaNaves.add(nave);
                        System.out.println("Nave cargada correctamente");
                    } else {
                        System.out.println("\nLa nave ya existe");
                    }
                    
                    break;
                    

                case 3:
                    
                    do{
                        System.out.println("Ingrese la cantidad de pasajeros");
                        cantidadPasajeros = console.nextInt();
                    }while(cantidadPasajeros < 1); //debe tener al menos un pasajero
                    
                    // Consumo el salto de linea del nextInt
                    console.nextLine();       
                    
                    do{
                        System.out.println("Ingrese el nombre de la nave");
                        nombre = console.nextLine();
                    }while(nombre.isEmpty());
                    
                    
                    do{
                        System.out.println("Ingrese la capacidad de tripulación");
                        capacidadTripulacion = console.nextInt();
                    }while(capacidadTripulacion < 1);
                    
                    //Falta validar
                    System.out.println("Ingrese el año del lanzamiento");
                    anioLanzamiento = console.nextInt();
                    
                    nave = new CruceroEstelar(cantidadPasajeros, nombre, capacidadTripulacion, anioLanzamiento);
                    
                    if (compararExistente(nave, listaNaves)) {
                        listaNaves.add(nave);
                        System.out.println("Nave cargada correctamente");
                    } else {
                        System.out.println("\nLa nave ya existe");
                    }
                    
                    break;
                    
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }
    
    public static void mostrarNaves(List<Nave> listaNaves){
        if (listaNaves.isEmpty()) {
            System.out.println("Aun no hay naves registradas");
        } else {
            System.out.println("\n---Naves Registradas---\n");
            for (int i = 0; i < listaNaves.size(); i++) {
                System.out.println(listaNaves.get(i).toString());
            }
        }
    }
    
    public static void iniciarExploracion(List<Nave> listaNaves){
        if (listaNaves.isEmpty()) {
            System.out.println("Aun no hay naves registradas");
        } else {
            System.out.println("\n---Iniciar Exploración---\n");
            for (Nave n : listaNaves){
                if(n instanceof Explorador){
                    ((Explorador) n).explorar();
                }else{
                    System.out.println("El crucero estelar " + n.getNombre() + " no puede realizar exploraciones");
                }
            }
        }
    }
    
    public static void ordenarPorNombre(){
        
    }
    
    public static void ordenarPorAnio(List<Nave> listaNaves, ComparadorAnio comparador){
        if (listaNaves.isEmpty()) {
            System.out.println("Aun no hay naves registradas");
        } else {
            Collections.sort(listaNaves, comparador);
            System.out.println("Lista de naves ordenadas por lanzamiento más reciente");
            for (Nave n : listaNaves){
                System.out.println("Año: " + n.getAnioLanzamiento() + " | Nave: " + n.getNombre());
            }
        }
    }
    
    public static void ordenarPorTripulantes(){
        
    }
}
