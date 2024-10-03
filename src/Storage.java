import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Storage <T> {

    private List<T> srg;

    public Storage (){
        srg = new ArrayList<T>();
    }

    public void additem (T lai){
        srg.add(lai);
    }

    public List<T> getitems(){
        return srg;
    }

    public void copyTo (Storage <? super T> otherStorage)
    {
        Iterator it = this.srg.iterator();
        while (it.hasNext()) {
            otherStorage.additem((T) it.next());
        }
    }

}
