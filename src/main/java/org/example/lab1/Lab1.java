package org.example.lab1;

import org.example.lab0.Product;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Lab1 {

    public static int askForNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter ID to search: ");
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }

    public static void main(String[] args) throws IOException {

        //4 метода поиска в отсортированных и неотсортированных массивах по ключевому полю
        // в текстовом файле созданном ранее

        String file = "MOCK_DATA.json";
        List<Product> products = Product.readFromFile(file);
        Product.shuffle(products);

        System.out.println("№ |         name         |       description         |" +
                " price   | amount  | measure");
        for (Product prod : products) {
            prod.printProduct();
        }

        int id = askForNumber();

        /* linear search in not sorted array */
        LinearSearch.search(products, id);

        /* Search in Binary tree */

        BinaryTreeSearch binTree = new BinaryTreeSearch();
        binTree.makeBinaryTree(products, null, null);
        //System.out.println(binTree.getHead());
        binTree.binaryTreeSearch(id);

        /* binary search */
        List<Product> sortedList = Product.readFromFile(file);
        BinarySearch.binarySearch(sortedList, id);
        BinarySearch.interpolationSearch(sortedList, id);
        FibonacciSearch.fibonacciSearch(sortedList, id);
    }

}
