package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Fibonacci {

    static Integer[] fibonacciArray = new Integer[] {1, 2, 3, 5, 8, 13, 21};

    static List<Integer> fibonacciSequence = new ArrayList<>();
    Integer fibonacciElement;

    public Fibonacci() {

    }

    void fibonacciGenerator1(Integer fibLength) {
        fibonacciSequence.clear();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);
        for (int i = 0; i < fibLength; i++) {
            fibonacciSequence.add(fibonacciSequence.get(fibonacciSequence.size() - 1) + fibonacciSequence.get(fibonacciSequence.size() - 2));
        }
    }

    List<Integer> fibonacciGenerator2(int fibLength) {
        List<Integer> fibonacciSequenc = new ArrayList<>();
        fibonacciSequenc.add(0);
        fibonacciSequenc.add(1);
        for (int i = 0; i < fibLength - 2; i++) {
            fibonacciSequenc.add(fibonacciSequenc.get(fibonacciSequenc.size() - 1) + fibonacciSequenc.get(fibonacciSequenc.size() - 2));
        }

        return fibonacciSequenc;
    }

    void fibonacciGenerator3(int fibLength) {
        Integer current = 0;
        Integer next = 1;
        Integer temp;

        for (int i = 0; i < fibLength; i++) {
            temp = next;
            next += current;
            current = temp;
            System.out.println(next);
        }

    }

    List<Integer> currentList = new ArrayList<>();

    Integer memorizeCurrentReturnPrevious(Integer current) {
        if (currentList.isEmpty()) {
            currentList.add(0);
        }
        currentList.add(current);
        return currentList.get(currentList.size() - 2);
    }

    Integer fibonacciByElement(Integer current) {
        if (currentList.isEmpty()) {
            currentList.add(0);
        }

        Integer previous = currentList.get(currentList.size() - 1);
        Integer next = current + previous;
        currentList.add(current);

        return next;
    }
    Integer previous = 0;
    Integer fibonacciByElementNoList(Integer current) {
        Integer temp = current;
        current = current + previous;
        previous = temp;

        return current;
    }


    List<Integer> fibGen() {
        List<Integer> fibonacciSequenc = new ArrayList<>();
        fibonacciSequenc.add(0);
        fibonacciSequenc.add(1);
        for (int i = 0; i < 10; i++) {
            fibonacciSequenc.add(fibonacciSequenc.get(fibonacciSequenc.size() - 1) + fibonacciSequenc.get(fibonacciSequenc.size() - 2));
        }

        return fibonacciSequenc;
    }

    public Integer fibElemGen(Integer n) {
        return (n < 2) ? n : fibElemGen(n - 2) + fibElemGen(n - 1);
    }

    public Integer fibGenNoParam() {
        return fibElemGen(10);
    }

    public static void main(String[] args) {
        Fibonacci testFib = new Fibonacci();
//        // 1. static array transformed into a stream:
//        Stream<Integer> s60 = Arrays.stream(fibonacciArray);
//
//        // 2. Static list filled up with a dibSeq generating method:
        testFib.fibonacciGenerator1(10);
//        Stream<Integer> s61 = fibonacciSequence.stream();
//

        // 3. Local variable list filled up with the same method
        testFib.fibonacciGenerator2(10);
        List<Integer> fibSeq = testFib.fibonacciGenerator2(10);
        Stream<Integer> s62 = fibSeq.stream();

        // 4.
        Supplier<List> fibSupp = () -> (new Fibonacci()).fibGen();
        Stream<Integer> s6 = fibSupp.get().stream();

        // 5.
        testFib.fibonacciGenerator3(10);

    }

}
