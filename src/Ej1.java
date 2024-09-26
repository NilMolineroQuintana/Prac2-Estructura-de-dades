import java.util.LinkedList;
import java.util.List;

public class Ej1 {
    public static void addHeadsToEngineers(List<? extends Department> departments,List<? super Engineer> engineers) {
        for (int i = 0; i < departments.size(); i++) {
            Engineer head = departments.get(i).getHead();
            if (head != null) {
                engineers.add(head);
            }
        }
    }

    void printNames(List<? extends Person> lp){
        for (int i = 0; i < lp.size(); i++) {
            System.out.println(lp);
        }

    public static void main(String[] args) {
        List<Department> departments = new LinkedList<>();
        List<Engineer> engineers = new LinkedList<>(); // Puedes usar ArrayList o LinkedList

        // Crear algunos ingenieros
        Engineer engineer1 = new Engineer("Pepito");
        Engineer engineer2 = new Engineer("Ana");
        Engineer engineer3 = new Engineer("Carlos");

        // Crear algunos departamentos
        Department department1 = new Department(engineer1);
        Department department2 = new Department(engineer2);
        Department department3 = new Department(engineer3);

        // Agregar los departamentos a la lista
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);

        addHeadsToEngineers(departments,engineers);
    }
}
