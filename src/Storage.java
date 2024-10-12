import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Codi fet per Guillem Alcoverro i Nil Molinero

public class Storage <T> {

    private List<T> srg;

    public Storage (){ // Constructor de Storage
        srg = new ArrayList<>();
    }

    public void additem (T lai){
        srg.add(lai); // Simplement afegim un element a la llista
    }

    public List<T> getitems(){
        return srg; // Simplement retornem la llista sencera
    }

    public void copyTo (Storage <? super T> otherStorage)
    {
        Iterator<T> it = this.srg.iterator();
        while (it.hasNext()) {
            otherStorage.additem((T) it.next());
        }
    }
}

// Codi fet per Guillem Alcoverro i Nil Molinero
