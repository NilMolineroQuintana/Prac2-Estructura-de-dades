import com.sun.security.jgss.InquireSecContextPermission;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Ex1();
        Ex2();
        Ex3();
        Ex4();
        Ex5();
        Ex6();
        Ex7();
        Ex8();
        Ex9();
        Ex10();
    }

    public static void Ex1()
    {
        System.out.println("------Ex1------");
        List<Department> departments = new ArrayList<>();
        List<Engineer> engineers = new ArrayList<>(); // Puedes usar ArrayList o LinkedList

        // Crear algunos ingenieros
        Engineer engineer1 = new Engineer("Pepito");
        Engineer engineer2 = new Engineer("Ana");
        Engineer engineer3 = new Engineer("Carlos");

        // Crear algunos departamentos
        Department department1 = new Department(engineer1);
        Department department2 = new Department(engineer2);
        Department department3 = new Department(engineer3);

        // Agregar los departamentos a la lista
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);

        addHeadsToEngineers(departments, engineers);
        printNames(engineers);
    }

    public static void addHeadsToEngineers(List<Department> ldpt,List<? super Engineer> leng) {
        Iterator<Department> it = ldpt.iterator();
        while (it.hasNext()){
            leng.add(it.next().getHead());
        }
    }

    public static void printNames(List<? extends Person> lp) {
        Iterator<? extends Person> itr = lp.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().getName());
        }
    }

    public static void Ex2()
    {
        System.out.println("------Ex2------");
        LinkedList<Integer> src = new LinkedList<>();
        src.add(1);
        src.add(2);
        src.add(3);
        src.add(4);

        LinkedList<String> trg = new LinkedList<>();
        trg.add("a");
        trg.add("b");
        trg.add("c");

        System.out.println("Abans: src=" + src + ", trg=" + trg);
        modifyPrefix(src, trg);
        System.out.println("Després: src=" + src + ", trg=" + trg);
    }

    public static <E,S> void modifyPrefix(LinkedList<E> src, LinkedList<S> trg)
    {
        if (src != null && trg != null)
        {
            Iterator<S> it = trg.iterator();
            int i = 0;
            while (it.hasNext())
            {
                if (i < src.size())
                {
                    trg.set(i, (S) src.get(i));
                }
                else
                {
                    break;
                }
                it.next();
                i++;
            }
        }
    }

    public static void Ex3()
    {
        System.out.println("------Ex3------");
        MyDate md1 = new MyDate(10);
        MyDate md2 = new MyDate(12);
        MyDate md3 = new MyDate(10);
        System.out.println("md1 i md2 són iguals? " + md1.equals(md2));
        System.out.println("md1 i md3 són iguals? " + md1.equals(md3));
    }

    public static void Ex4()
    {
        System.out.println("------Ex4------");
        List<Integer> l = new ArrayList<>();
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
        System.out.println("a) List<Snake> només es podria utlitzar el mètode que té Comparable<? super E> ja que qui implementa Comparable es Animal que es el super de Snake.");
        System.out.println("b) List<Animal> podria utilitzar el mètode que té Comparable<E> ja que Animal si que l'implemenya.");
    }

    public static void Ex6()
    {
        System.out.println("------Ex6------");
        List<Character> l1 = new ArrayList<>();
        l1.add('a');
        l1.add('b');
        l1.add('b');
        l1.add('b');
        l1.add('d');
        l1.add('e');
        l1.add('b');
        dedup(l1);
        System.out.println(l1);
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
        List<Integer> ls = new ArrayList<>();
        ls.add(2);
        ls.add(20);
        ls.add(30);
        ls.add(1);
        ls.add(11);
        ls.add(10);
        System.out.println(greaterThan(ls.iterator(),10));
    }

    public static <E extends Comparable<? super E>> List<E> greaterThan(Iterator<E> it, E sample)
    {
        List<E> ls = new ArrayList<>();
        while (it.hasNext())
        {
            E next = it.next();
            if (next.compareTo(sample) > 0)
            {
                ls.add(next);
            }
        }
        return ls;
    }

    public static void Ex8()
    {
        System.out.println("------Ex8------");
        System.out.println("a) Fals. Ja que primer de tot food no implementa la interficie 'Comparable' per tant ja donaria error, i a més Food es una classe abstracta i per tant no es pot instanciar.");
        System.out.println("b) Fals. En el method1 no dona problemes ja que el 'Comparable' no necessàriament ho ha d'implementar la clase que inserim sino un supertipus com per exemple 'Meat', però al method2 donaria error ja que 'BigBurguer' no implementa 'Comparable'.");
    }

    public static void Ex9()
    {
        System.out.println("------Ex9------");
        Storage<Number> number1 = new Storage<>();
            number1.additem(1);
            number1.additem(2);

        Storage<Number> number2 = new Storage<>();
            number2.additem(1.5);
            number2.additem(2.5);

        Storage<Integer> integer = new Storage<>();
            integer.additem(1);
            integer.additem(2);

        /*
            Storage<Integer> integer2 = new Storage<>();
            integer2.additem(1.5);
            integer2.additem(2.5);
         */

        number2.copyTo(number1);


        System.out.println("Es pot introduir un 'Number' dins d'un 'Integer' només en el cas de que el number sigui un 'Integer'. Ja que 'Integer' és subtipus de 'Number' però 'Number' no és supertipus de 'Integer'");
        System.out.println("Es pot afegir un Integer dins d'un storage de 'Number', ja que 'Number' es un supertipus de 'Integer' i per tant podriem fer un cast up sense problema.");
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

