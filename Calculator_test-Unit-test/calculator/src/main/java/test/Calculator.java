package test;

import java.util.stream.Stream;

public class Calculator {

    public int sum(int a, int b) throws InterruptedException {
        Thread.sleep(1200);
        return a + b;
    }

    public int division(int a, int b){
        return a / b;
    }

    public int substruction(int a, int b){
        return a - b;
    }

    public int multiplication(int a, int b){
        return a * b;
    }



}
