package com.codecool;

public class Fibonacci {

    Integer previous = 0;

    Integer nextFibonacciNumber(Integer current) {
        Integer temp = current;
        current += previous;
        previous = temp;
        return current;
    }

    Integer current = 0;
    Integer next = 1;
    int iterator = 0;

    void setIterator() {
        this.iterator++;
    }

    Integer nextFibonacciNumberNoParam() {
        Integer temp = next;
        next = next + current;
        current = temp;
        iterator++;

        return next;
    }

    public Integer fibElemGen(Integer n) {
        return (n < 2) ? n : fibElemGen(n - 2) + fibElemGen(n - 1);
    }

    public Integer fibGenNoParam() {
        // TODO: use this generate elements plus make an iterator variable to record iterations
        return fibElemGen(10);
    }

    public static void main(String[] args) {
        Fibonacci testFib = new Fibonacci();

        for (int i = 0; i < 10; i++) {
            System.out.println(testFib.nextFibonacciNumberNoParam());;
        }


    }

}
