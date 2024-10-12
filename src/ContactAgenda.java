import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Codi fet per Guillem Alcoverro i Nil Molinero

public class ContactAgenda {
    private List<Contact> list;

    public ContactAgenda() // Constructor de la ContactAgenda
    {
        list = new LinkedList<>();
    }

    public void add(Contact c)
    {
        if (search(c) == null)
        {
            list.add(c);
            System.out.println("Contact '" + c.name + "' added to agenda!");
        }
        else
        {
            System.out.println("'"+c.name+"' already in contacts!");
        }
    }

    public void remove(Contact c)
    {
        Iterator<Contact> it = list.iterator();
        Contact found = search(c);
        if (found != null)
        {
            list.remove(found);
            System.out.println("Contact '" + c.name + "' removed!");
        }
        else
        {
            System.out.println("Contact '" + c.name +"' not found in agenda!");
        }

    }

    public Contact search(Contact c)
    {
        Iterator<Contact> it = list.iterator();
        while (it.hasNext())
        {
            Contact next = it.next();
            if (next.name.equals(c.name))
            {
                return next; // Si troba
            }
        }
        return null; // En el cas que no trobi
    }

    public void showAgenda()
    {
        System.out.println();

        System.out.println("Contacts");
        System.out.println("---------");

        Iterator<Contact> it = list.iterator();

        while (it.hasNext())
        {
            System.out.println(it.next().toString());
            System.out.println("---------");
        }

        System.out.println();
    }
}

// Codi fet per Guillem Alcoverro i Nil Molinero