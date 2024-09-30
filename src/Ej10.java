public class Ej10 {
    public static void main(String args[])
    {
        ContactAgenda CA = new ContactAgenda();
        Contact nil = new Contact("Nil", "611437607");
        Contact miguel = new Contact("Miguel","639845607");
        CA.add(nil);
        CA.add(miguel);
        CA.showAgenda();
    }
}
