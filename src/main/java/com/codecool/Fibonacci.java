package com.codecool;

public class Fibonacci {

    Integer current = 0;
    Integer next = 1;
    int iterator = 0;

    Integer nextFibonacciNumberNoParam() {
        Integer temp = next;
        next = next + current;
        current = temp;
        iterator++;

        return next;
    }
}
