import java.util.*;

// Codi fet per Guillem Alcoverro i Nil Molinero

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

        // Crear llista de tipus ArrayList de Department i de Engineer
        List<Department> departments = new ArrayList<>();
        List<Engineer> engineers = new ArrayList<>();

        // Crear alguns Engineers
        Engineer engineer1 = new Engineer("Pepito");
        Engineer engineer2 = new Engineer("Ana");
        Engineer engineer3 = new Engineer("Carlos");

        // Crear alguns Departments amb els jefes asignats
        Department department1 = new Department(engineer1);
        Department department2 = new Department(engineer2);
        Department department3 = new Department(engineer3);

        // Agregar els Departaments a la lista de Deparments
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);

        // Crida de funcions
        addHeadsToEngineers(departments, engineers);
        printNames(engineers);
        System.out.println();
    }

    public static void addHeadsToEngineers(List<Department> ldpt,List<? super Engineer> leng) { // S'introdueixen llista de Deparment i una llista de Engineers
        Iterator<Department> it = ldpt.iterator(); // Iterador de la llista de Deparments
        while (it.hasNext()){
            leng.add(it.next().getHead()); // Afegir a la llista de Engineers els jefes de Department
        }
    }

    public static void printNames(List<? extends Person> lp) { // S'introdueïx una subclasse de Person (com ara Engineer)
        Iterator<? extends Person> itr = lp.iterator(); // Iterador de la subclasse de Person
        while (itr.hasNext()) {
            System.out.println(itr.next().getName()); // Imprimeix el nom de tots els membres de la llista
        }
    }

    public static void Ex2()
    {
        System.out.println("------Ex2------");

        // Creem llistes per probar-lo
        LinkedList<Integer> src = new LinkedList<>();
        src.add(2);
        src.add(4);
        src.add(6);
        src.add(8);

        LinkedList<Number> trg = new LinkedList<>();
        trg.add(1.5);
        trg.add(3.5);
        trg.add(5.5);
        trg.add(7.5);
        trg.add(9.5);

        System.out.println("Abans: src=" + src + ", trg=" + trg);

        // Utilitzem la funció
        modifyPrefix(src, trg);

        System.out.println("Després: src=" + src + ", trg=" + trg);

        System.out.println();
    }

    public static <E> void modifyPrefix(LinkedList<? extends E> src, LinkedList<E> trg)
    {
        if (src != null && trg != null)
        {
            Iterator<E> it = trg.iterator();
            int i = 0;
            while (it.hasNext())
            {
                if (i < src.size())
                {
                    trg.set(i, src.get(i));
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

        // Creem MyDates de mostra
        MyDate md1 = new MyDate(10);
        MyDate md2 = new MyDate(12);
        MyDate md3 = new MyDate(10);

        // Només ha de donar true si els 2 MyDates coincideixen en el mes
        System.out.println("md1 i md2 són iguals? " + md1.equals(md2));
        System.out.println("md1 i md3 són iguals? " + md1.equals(md3));

        System.out.println();
    }

    public static void Ex4()
    {
        System.out.println("------Ex4------");

        // Creem llistes per provar-lo
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(20);
        l1.add(7);
        l1.add(6);
        l1.add(99);
        l1.add(61);
        l1.add(40);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(11);
        l2.add(22);
        l2.add(45);
        l2.add(91);
        l2.add(7);

        List<Integer> l3 = new ArrayList<>();
        l3.add(1);

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        //Executem el programa per les 3 llistes de mostra
        System.out.println(checkRange(l1.iterator(),cmp,1,100));
        System.out.println(checkRange(l2.iterator(),cmp,1,90));
        System.out.println(checkRange(l3.iterator(),cmp,-100,0));

        System.out.println();
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

        System.out.println("a) En el cas d'una List<Snake, només es podria utilitzar el mètode que fa servir Comparable<? super E>, ja que qui implementa la interfície Comparable és la classe Animal, que és el supertipus de Snake. Com que Snake no implementa directament Comparable<Snake>, però hereta d'Animal, que sí és comparable amb si mateix, es compleix la condició de strongest2, permetent-ne la seva utilització.");
        System.out.println("b) En el cas d'una List<Animal>, es poden utilitzar ambdós mètodes. Això es deu al fet que la classe Animal implementa la interfície Comparable<Animal>, complint així la restricció del mètode strongest1, que requereix que el tipus sigui comparable amb si mateix (Comparable<E>). A més, el mètode strongest2 permet comparar el tipus amb qualsevol supertipus que implementi Comparable, i com que Animal ja implementa Comparable<Animal>, també es compleix aquesta condició.");

        System.out.println();
    }

    public static void Ex6()
    {
        System.out.println("------Ex6------");

        // Creem llista per provar-lo
        List<Character> l1 = new ArrayList<>();
        l1.add('a');
        l1.add('b');
        l1.add('b');
        l1.add('b');
        l1.add('d');
        l1.add('e');
        l1.add('b');

        // Creem llista per demostrar que no retorna null
        List<Character> l2 = new ArrayList<>();

        System.out.println("Abans: l1=" + l1 + ", l2=" + l2);

        dedup(l1); // Prova mostra
        dedup(l2); // Per comprovar algun dels casos que pot trencar el mètode

        System.out.println("Després: l1=" + l1 + ", l2=" + l2);

        System.out.println();
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
                iterator.remove(); // Ho hem de eliminar desde l'iterador, ja que si ho fem directament desde la llista el iterador donarà problemes
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

        // Creem llista per provar-lo
        List<Integer> l1 = new ArrayList<>();
        l1.add(90);
        l1.add(10);
        l1.add(9);
        l1.add(16);
        l1.add(89);
        l1.add(71);
        l1.add(40);

        // Creem llista per provar el cas de que retorni una llista buida
        List<Integer> l2 = new ArrayList<>();
        l2.add(5);

        System.out.println(greaterThan(l1.iterator(),70));
        System.out.println(greaterThan(l2.iterator(),70));

        System.out.println();
    }

    public static <E extends Comparable<? super E>> List<E> greaterThan(Iterator<E> it, E sample)
    {
        List<E> ls = new ArrayList<>();
        while (it.hasNext())
        {
            E next = it.next();
            if (next.compareTo(sample) > 0) // Com el comodi E o algun supertipus seu ha de tindre implementat Comparable, llavor podem fer crida a una funció que es diu compareTo que prové de Comparable. Aquesta funció si next es major que sample la funció retorna un nombre positiu != 0.
            {
                ls.add(next); // Simplement afegim a l'ArrayList els alements que compleixen la condició
            }
        }
        return ls;
    }

    public static void Ex8()
    {
        System.out.println("------Ex8------");

        System.out.println("a) Fals. En primer lloc, la classe 'Food' no implementa la interfície 'Comparable', fet que ja generaria un error de compilació. A més, com que 'Food' és una classe abstracta, no es pot instanciar directament.");
        System.out.println("b) Fals pel method2 i cert pel method1. En el method1 no hi ha problemes perquè la restricció de 'Comparable' es pot complir a través d'un supertipus, com per exemple 'Meat'. No obstant això, en el method2 donaria error perquè 'BigBurger' no implementa 'Comparable<BigBurger>', que és el requeriment específic del mètode.");

        System.out.println();
    }

    public static void Ex9()
    {
        System.out.println("------Ex9------");

        // Creem un storage de tipus number
        Storage<Number> number1 = new Storage<>();
        number1.additem(1);
        number1.additem(2);

        // Creem un altre storage de tipus number per probar després el mètode copyTo()
        Storage<Number> number2 = new Storage<>();
        number2.additem(1.5);
        number2.additem(2.5);

        // Creem un Storage de tipus integer per despés mostrar que no es pot ficar un number en un integer
        Storage<Integer> integer = new Storage<>();
        integer.additem(8);
        integer.additem(9);

        // Testejem el copyTo
        number2.copyTo(number1);
        integer.copyTo(number1);

        /*
        Aquest codi no funcionaria ja que number no es fill de Integer i donaria error de compilació

        number2.copyTo(integer);

         */


        System.out.println("No es pot afegir un 'Number' a un 'Storage<Integer>' perquè, encara que 'Integer' sigui un subtipus de 'Number', no tots els 'Number' són 'Integer'. 'Storage<Integer>' només accepta elements del tipus exacte 'Integer' o dels seus subtipus.");
        System.out.println("Sí, es pot afegir un 'Integer' a un 'Storage<Number>' perquè 'Integer' és un subtipus de 'Number'. Això és possible gràcies a l'herència, ja que 'Storage<Number>' pot emmagatzemar qualsevol objecte que sigui un subtipus de 'Number'.");

        System.out.println();
    }

    public static void Ex10()
    {
        System.out.println("------Ex10------");

        // Creem una agenda
        ContactAgenda CA = new ContactAgenda();

        // Creem uns contactes de mostra
        Contact nil = new Contact("Nil", "611437607");
        Contact test = new Contact("Test","123456789");
        Contact removeTestContact = new Contact("removeTest","987654321");

        // Proves add
        CA.add(nil);
        CA.add(test);
        CA.add(removeTestContact);
        CA.add(removeTestContact); // Per comprovar el cas de que ja estigui a l'agenda

        // Prova mostrar agenda
        CA.showAgenda();

        // Proves remove
        CA.remove(removeTestContact);
        CA.remove(removeTestContact); // Per comprovar el cas de que el contacte no existeixi a l'agenda

        // Veiem que removeTestContact no existèix ja a l'agenda
        CA.showAgenda();

        System.out.println();
    }
}

// Codi fet per Guillem Alcoverro i Nil Molinero