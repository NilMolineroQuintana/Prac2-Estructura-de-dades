public class Person {
    private String name;

    public Person(String name)
    {
        System.out.println("S'ha creat una persona");
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
