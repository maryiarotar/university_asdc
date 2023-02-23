package org.example;

import org.example.lab1.Product;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String file = "MOCK_DATA.json";
        List<Product> products = Product.readFromFile(file);

        System.out.println("№ |         name         |       description         |" +
                " price   | amount  | measure");

        for (Product prod : products) {
            prod.printProduct();
        }

        Product newProd = new Product();
        newProd.setId(products.size()+1);
        newProd.setName("Bbb Ccccccc");
        newProd.writeToFile(file);

    }
}