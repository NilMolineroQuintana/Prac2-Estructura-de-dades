public class Person {
    private String name;

    public Person(String name)
    {
        System.out.println("Se crea persona");
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
