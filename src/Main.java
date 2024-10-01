import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        //Ex1();
        Ex2();
        //Ex3();
        Ex4();
        //Ex5();
        //Ex6();
        //Ex7();
        //Ex8();
        //Ex9();
        Ex10();
    }

    public static void Ex1()
    {
        System.out.println("------Ex1------");
    }

    public static void Ex2()
    {
        System.out.println("------Ex2------");
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

    public static void Ex3()
    {
        System.out.println("------Ex3------");
    }

    public static void Ex4()
    {
        System.out.println("------Ex4------");
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(50);
        l.add(100);
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(checkRange(l.iterator(),cmp,1,100));
    }

    public static <E> boolean checkRange(Iterator<E> it, Comparator<E> cmp, E min, E max)
    {
        while (it.hasNext())
        {
            E next = it.next();
            if ((cmp.compare(next,min) < 0) || (cmp.compare(next,max) > 0))
            {
                return false;
            }
        }
        return true;
    }


    public static void Ex5()
    {
        System.out.println("------Ex5------");
    }

    public static void Ex6()
    {
        System.out.println("------Ex6------");
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

    public static void Ex7()
    {
        System.out.println("------Ex7------");
    }

    public static void Ex8()
    {
        System.out.println("------Ex8------");
    }

    public static void Ex9()
    {
        System.out.println("------Ex9------");
    }

    public static void Ex10()
    {
        System.out.println("------Ex10------");
        ContactAgenda CA = new ContactAgenda();
        Contact nil = new Contact("Nil", "611437607");
        Contact miguel = new Contact("Miguel","639845607");
        CA.add(nil);
        CA.add(miguel);
        CA.showAgenda();
    }
}

