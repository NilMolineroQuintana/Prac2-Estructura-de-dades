public class Contact {
    public String num;
    public String name;

    public Contact(String name, String num)
    {
        this.name = name;
        this.num = num.substring(0,9); //Limita caracteres
    }

    public boolean equals(Contact c)
    {
        if (num.equals(c.num) && name.equals(c.name))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Name: "+name+"\nNum: "+num;
    }
}
