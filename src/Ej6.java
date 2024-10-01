import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ej6 {

    public static <E> void dedup(List<E> list)
    {
        E prev = null;
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext())
        {
            E next = iterator.next();
            if (prev != null && prev.equals(next))
            {
                iterator.remove();
            }
            else
            {
                prev = next;
            }
        }
    }

    public static void main(String args[])
    {
        List<Character> l1 = new LinkedList<>();
        l1.add('a');
        l1.add('b');
        l1.add('b');
        l1.add('b');
        l1.add('d');
        l1.add('e');
        l1.add('b');
        dedup(l1);
        System.out.println(l1.toString());
    }
}
