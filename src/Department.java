public class Department {
    private Engineer head; // Guardem el jefe del departament

    public Department(Engineer head) {
        this.head = head; // Asignar el enginyer introduït com a jefe del departament
    }

    public Engineer getHead() { // Retorna el jefe del departament
        return head;
    }
}
