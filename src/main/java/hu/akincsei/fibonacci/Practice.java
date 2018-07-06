package hu.akincsei.fibonacci;

import com.codecool.Fibonacci;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * http://www.java2s.com/Tutorials/Java/java.util.function/Supplier/index.htm
 * */
public class Practice {

    public static SunPower produce(Supplier<SunPower> supp) {
        return supp.get();
    }

    public static void main(String[] args) {


    }

}