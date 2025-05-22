package par_1c124.pkg20250522.alipablo;

import java.util.Comparator;

/**
 *
 * @author pablo
 */
public class ComparadorAnio implements Comparator<Nave>{
    @Override
    public int compare(Nave n1, Nave n2) {
        return Integer.compare(n2.getAnioLanzamiento(), n1.getAnioLanzamiento());
    }
}
