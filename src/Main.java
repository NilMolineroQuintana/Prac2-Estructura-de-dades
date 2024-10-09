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
        System.out.println("");
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
        System.out.println("");
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
        System.out.println("");
    }

    public static void Ex4()
    {
        System.out.println("------Ex4------");

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(20);
        l.add(7);
        l.add(6);
        l.add(99);
        l.add(61);
        l.add(40);

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(checkRange(l.iterator(),cmp,1,100));
        System.out.println("");
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
        //Revisar
        System.out.println("a) List<Snake> només es podria utlitzar el mètode que té Comparable<? super E> ja que qui implementa Comparable es Animal que es el super de Snake.");
        System.out.println("b) List<Animal> podria utilitzar els 2 mètodes ja que Animal implementa Comparable y per tant pot cridar a la clase que té <Comparable <E>> ja implementa Comparable, a més l'altra funció acepta qualsevol super tipus que utlitzi Comparable i Animal ja la té.");
        System.out.println("");
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

        List<Character> l2 = new ArrayList<>();

        dedup(l1); // Prova mostra
        dedup(l2); // Per comprovar algun dels casos que pot trencar el mètode
        System.out.println(l1);
        System.out.println(l2);
        System.out.println("");
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

        List<Integer> l1 = new ArrayList<>();
        l1.add(90);
        l1.add(10);
        l1.add(9);
        l1.add(16);
        l1.add(89);
        l1.add(71);
        l1.add(40);

        List<Integer> l2 = new ArrayList<>();
        l2.add(5);

        System.out.println(greaterThan(l1.iterator(),70));
        System.out.println(greaterThan(l2.iterator(),70));
        System.out.println("");
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

        //Revisar
        System.out.println("a) Fals. Ja que primer de tot food no implementa la interficie 'Comparable' per tant ja donaria error, i a més Food es una classe abstracta i per tant no es pot instanciar.");
        System.out.println("b) Fals. En el method1 no dona problemes ja que el 'Comparable' no necessàriament ho ha d'implementar la clase que inserim sino un supertipus com per exemple 'Meat', però al method2 donaria error ja que 'BigBurguer' no implementa 'Comparable'.");
        System.out.println("");
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


        System.out.println("No es pot introduir un 'Number' dins d'un 'Storage<Integer>' tret que aquest 'Number' sigui un 'Integer', ja que 'Integer' és un subtipus de 'Number', però 'Number' no és un subtipus de 'Integer'.");
        System.out.println("Sí que es pot afegir un 'Integer' dins d'un 'Storage<Number>', ja que 'Number' és el supertipus de 'Integer', per la qual cosa és possible realitzar un cast up.");

        System.out.println("");
    }

    public static void Ex10()
    {
        System.out.println("------Ex10------");

        ContactAgenda CA = new ContactAgenda();

        Contact nil = new Contact("Nil", "611437607");
        Contact test = new Contact("Test","123456789");
        Contact removeTest = new Contact("removeTest","987654321");

        CA.add(nil);
        CA.add(test);
        CA.add(removeTest);

        CA.showAgenda();

        CA.remove("removeTest");

        CA.showAgenda();

        //Preguntar profe

        System.out.println("");
    }
}

