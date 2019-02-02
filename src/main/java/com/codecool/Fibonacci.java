package com.codecool;

import java.util.function.Supplier;

public class Fibonacci implements Supplier<Integer> {

    Integer current = 0;
    Integer next = 1;
    int iterator = 0;

    private Integer nextFibonacci() {

        if (iterator < 2) {
            return iterator++;
        }
        Integer temp = next;
        next += current;
        current = temp;
        iterator++;

        return next;
    }

    @Override
    public Integer get() {
        return nextFibonacci();

    }
}
