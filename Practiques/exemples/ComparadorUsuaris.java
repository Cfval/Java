import java.util.*;

public class ComparadorUsuaris implements Comparator<Usuari>{

    @Override
    public int compare(Usuari o1, Usuari o2) {
        return o1.getEdat() - o2.getEdat();
    }
    
}

