// Codi fet per Guillem Alcoverro i Nil Molinero

public class Contact {
    public String num;
    public String name;

    public Contact(String name, String num)
    {
        this.name = name;
        this.num = num.substring(0,9); // Limitem els caràcters a màxim 9 digits
    }

    public boolean equals(Contact c)
    {
        return num.equals(c.num) && name.equals(c.name); // Comprovem que nom i telèfon siguin iguals
    }

    @Override
    public String toString()
    {
        return "Name: "+name+"\nNum: "+num;
    }
}

// Codi fet per Guillem Alcoverro i Nil Molinero