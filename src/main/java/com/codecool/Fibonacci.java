package com.codecool;

import java.util.function.Supplier;

public class Fibonacci implements Supplier<Integer> {

    Integer current = 0;
    Integer next = 1;
    int iterator = 0;

    Integer nextFibonacci() {
        Integer temp = next;
        next = next + current;
        current = temp;
        iterator++;

        return next;
    }

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public Integer get() {
        return nextFibonacci();

    }
}
