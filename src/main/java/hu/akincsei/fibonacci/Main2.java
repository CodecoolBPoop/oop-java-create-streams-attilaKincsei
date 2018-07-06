package hu.akincsei.fibonacci;

/*  w  w w  .j a  va2 s.  c om*/
import java.util.Objects;
import java.util.function.Supplier;

public class Main2 {
    public static SunPower produce(Supplier<SunPower> supp) {
        return supp.get();
    }

    static Integer integerCreator() {
        return 10;
    }

    public static void main(String[] args) {
        // Variations for creating a supplier function
        SunPower power = new SunPower();
        // Lambda 1:
        SunPower p1 = produce(() -> power);
        // Lambda 2:
        SunPower p2 = produce(() -> new SunPower());
        // Method reference:
        SunPower p3 = produce(SunPower::new);

        System.out.println("Check the same object? " + Objects.equals(p1, p2));


        SunPower sunPower = new SunPower();
        Supplier<SunPower> supp1 = () -> sunPower;
        Supplier<SunPower> supp2 = () -> new SunPower();
        Supplier<SunPower> supp3 = SunPower::new;

        Supplier<Integer> integerSupplier = () -> integerCreator();
        System.out.println(integerSupplier.get());

    }
}

class SunPower {

    public SunPower() {
        System.out.println("Sun Power initialized..");
    }
}