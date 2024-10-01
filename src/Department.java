public class Department {
    private Engineer head;

    public Department(Engineer head) {
        System.out.println("S'ha creat un departament");
        this.head = head;
    }

    public Engineer getHead() {
        return head;
    }
}