package com.codecool;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.UnaryOperator;

public class Streams {

    public static void main(String[] args) {
        /*
         * Create a stream out of the following array.
         */

        String[] a1 = {"one", "two", "three"};

        Stream<String> s1 = Arrays.stream(a1);

        /*
         * Create a stream containing the Strings "one" , "two" and "three"
         * without using an array
         */

        Stream<String> s2 = Stream.of("one", "two", "three");

        /*
         * Create a stream using a stream builder.
         */

        Stream.Builder<String> b1 = Stream.builder();
        b1.add("one");
        b1.add("two");
        b1.add("three"); // accept(t) return this: what does it return actually???
        b1.accept("four"); // void

        Stream<String> s3 = b1.build();

        /*
         * Collect one of the above defined streams into a list.
         *
         * HINT: the keyword here is "collect"
         */

        List<String> l1 = s3.collect(Collectors.toList());

        /*
         * Streams can be infinite.  We obviously cannot create such a
         * stream by supplying all the elements ourselves.
         *
         * HINT: When looking for methods to create such streams
         * realize that:
         * - These methods cannot belong to an instance
         * - They are returning streams
         */

        /*
         * Create a stream of the powers of two.
         */
        Integer twoToTheZeroth = 1;
        UnaryOperator<Integer> doubler = (Integer x) -> 2 * x;
        Stream<Integer> s4 = Stream.iterate(twoToTheZeroth, doubler);

        /*
         * Create a stream containing the first ten elements of s4.
         */
        Stream<Integer> s5 = Stream.iterate(1, doubler).limit(10);

        /*
         * Create a stream containing the elements of the Fibonacci
         * sequence.
         *
         * HINT: You will need to create a new class for this.
         */
        // Solution 5: invoked function does all the work
        Fibonacci fibonacciObject = new Fibonacci();
        Stream<Integer> s60 = Stream.iterate(1, fibonacciObject::nextFibonacciNumber).limit(15);
//        s60.forEach(System.out::println);

        // Solution 6: invoked function does all the work
        Fibonacci fibonacci = new Fibonacci();
        Supplier<Integer> fibonacciGenerator = () -> fibonacci.nextFibonacciNumberNoParam();
        Stream<Integer> s66 = Stream.iterate(1, x -> fibonacciGenerator.get()).limit(15);
        s66.forEach(System.out::println);


//        Supplier<Integer> fibSupp = new Fibonacci();
//        Stream<Integer> s6 = ;

    }
}
