package org.example.lab1;

import org.example.lab0.Product;

import java.util.List;

public class FibonacciSearch {

    public static int fibonacciSearch(List<Product> array, int id) {
        System.out.println("<Fibonacci Search> for Product id [" + id +"]");
        int fib1 = 0;
        int fib2 = 1;
        int fib = fib1 + fib2;

        while (fib < array.size()) {
            fib1 = fib2;
            fib2 = fib;
            fib = fib1 + fib2;
        }

        int stepsToFind = 1;
        int offset = -1;

        while (fib > 1) {
            int i = Math.min(offset + fib1, array.size() - 1);

            if (array.get(i).getId() < id) {
                fib = fib2;
                fib2 = fib1;
                fib1 = fib - fib2;
                offset = i;
            } else if (array.get(i).getId() > id) {
                fib = fib1;
                fib2 = fib2 - fib1;
                fib1 = fib - fib2;
            } else {
                System.out.println("\tsteps to find ====> " + stepsToFind);
                return stepsToFind;
            }
            stepsToFind++;
        }

        if (fib2 == 1 && array.get(offset + 1).getId() == id) {
            System.out.println("\tsteps to find ====> " + stepsToFind);
            return stepsToFind;
        }
        System.out.println("Product is not found!");
        return -1;
    }

}
