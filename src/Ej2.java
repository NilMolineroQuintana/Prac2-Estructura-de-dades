import java.util.Arrays;
import java.util.LinkedList;

public class Ej2 {
    public static <E> void modifyPrefix(LinkedList<E> src, LinkedList<E> trg)
    {
        for (int i = 0; i < trg.size(); i++)
        {
            if (i < src.size())
            {
                trg.set(i,src.get(i));
            }
            else
            {
                break;
            }
        }
        return;
    }

    public static void main(String[] args) {
        LinkedList<Character> src = new LinkedList<>(Arrays.asList('a', 'b', 'c', 'd'));
        LinkedList<Character> trg = new LinkedList<>(Arrays.asList('x', 'y', 'z','0','1'));
        modifyPrefix(src,trg);
    }
}
