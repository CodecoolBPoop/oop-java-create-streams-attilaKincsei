package hu.akincsei.fibonacci;

import com.codecool.Fibonacci;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * http://www.java2s.com/Tutorials/Java/java.util.function/Supplier/index.htm
 * */
public class Practice {

    private int[] randomArray;

    public static void main(String[] args) {

        Practice instance = new Practice();

        int minimum = 10_000;
        int maximum = 100_000;
        int length = 500_000_000;
        instance.createRandomArray(length, minimum, maximum);
        double simpleStream = instance.getMaximumWithStreams(minimum);
        double parallelStream = instance.getMaximumWithParallelStreams(minimum);
        double forLoop = instance.getMaximumWithForLoop(minimum);

        double percentage = (parallelStream / simpleStream) * 100;
        System.out.println(String.format("Percentage parallel per simple stream: %f", percentage));

        double percentage2 = (forLoop / simpleStream) * 100;
        System.out.println(String.format("Percentage for loop per simple stream: %f", percentage2));

        double percentage3 = (forLoop / parallelStream) * 100;
        System.out.println(String.format("Percentage for loop per parallel stream: %f", percentage3));

    }

    private double getMaximumWithForLoop(int minimum) {
        long actualMaximum;
        long start = System.currentTimeMillis();
        for (int element : randomArray) {
            if (element > minimum) {
                actualMaximum = element;
            }
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.printf("Time to get maximum value with for each: %d", (end - start));
        System.out.println();
//        System.out.printf("Actual maximum value: %d", actualMaximum);
//        System.out.println();
        return duration;

    }

    private long getMaximumWithStreams(int minimum) {
        long start = System.currentTimeMillis();
        long actualMaximum = Arrays.stream(randomArray).reduce(minimum, Math::max);
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.printf("Time to get maximum value with streams: %d", (end - start));
        System.out.println();
//        System.out.printf("Actual maximum value: %d", actualMaximum);
//        System.out.println();
        return duration;
    }

    private long getMaximumWithParallelStreams(int minimum) {
        long start = System.currentTimeMillis();
        long actualMaximum = Arrays.stream(randomArray).parallel().reduce(minimum, Math::max);
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.printf("Time to get maximum value with parallel streams: %d", duration);
        System.out.println();
//        System.out.printf("Actual maximum value: %d", actualMaximum);
//        System.out.println();
        return duration;
    }


    private void createRandomArray(int length, int minimum, int maximum) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            int element = random.nextInt(minimum, maximum);
            randomArray[i] = element;
        }

    }

    private void supplierPractice() {
        Supplier<Integer> fibonacciGenerator = new Fibonacci();
        Stream<Integer> s61 = Stream.generate(fibonacciGenerator).limit(17);

        // Summing the elements of an array
        List<Integer> streamList = s61.collect(Collectors.toList());
        int fibSum = streamList.stream().reduce(0, (i1, i2) -> i1 * i2);
        System.out.println(fibSum);
    }

}