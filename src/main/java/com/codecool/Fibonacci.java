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

    public Integer fibonacciGenerator() {
        fibonacciSequence.addAll(Arrays.asList(fibonacciArray));
        return fibonacciSequence.get(0);
    }
}
