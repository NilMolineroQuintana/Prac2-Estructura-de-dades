import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactAgenda {
    private List<Contact> list;

    public ContactAgenda()
    {
        list = new LinkedList<>();
    }

    public void add(Contact c)
    {
        if (search(c.name) == null)
        {
            list.add(c);
            System.out.println("Contact added!");
        }
        else
        {
            System.out.println("Already in contacts!");
        }
    }

    public void remove(String name)
    {
        Iterator<Contact> it = list.iterator();

        while (it.hasNext())
        {
            Contact next = it.next();
            if (next.name.equalsIgnoreCase(name))
            {
                it.remove();
                System.out.println("Contact removed!");
                break;
            }
        }
    }

    public Contact search(String name)
    {
        Iterator<Contact> it = list.iterator();
        while (it.hasNext())
        {
            Contact next = it.next();
            if (next.name.equalsIgnoreCase(name))
            {
                return next;
            }
        }
        return null;
    }

    public void showAgenda()
    {
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
