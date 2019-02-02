package hu.akincsei.fibonacci;

/*from  w  w  w .  java2s  .  c o  m*/
import java.util.function.Supplier;

public class Main3 {

    private static Employee maker(Supplier<Employee> fx) {
        return fx.get();
    }




    public static void main(String[] args) {
        // Two solutions: same thing.
        // First: using lambda
        // Second: using method reference
        System.out.println(maker(() -> new Employee()));
        System.out.println(maker(Employee::new));
    }

}

class Employee {
    @Override
    public String toString() {
        return "A EMPLOYEE";
    }
}