import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ej2 {

    public static <E,S> void modifyPrefix(LinkedList<E> src, LinkedList<S> trg)
    {
        if (src != null && trg != null)
        {
            for (int i = 0; i < trg.size(); i++)
            {
                if (i < src.size())
                {
                     trg.set(i, (S) src.get(i));
                }
                else
                {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> src = new LinkedList<>();
        src.add(1);
        src.add(2);
        src.add(3);

        LinkedList<String> trg = new LinkedList<>();
        trg.add("a");
        trg.add("b");
        trg.add("c");

        System.out.println("Antes: src=" + src + ", trg=" + trg);
        modifyPrefix(src, trg);
        System.out.println("Después: src=" + src + ", trg=" + trg);
    }
}
