package org.example.lab1;

/* метод последовательного поиска */

import org.example.lab0.Product;

import java.util.List;

public class LinearSearch {

    public static int search(List<Product> array, int id){

        for (int i = 1; i < array.size(); i++){
            if (array.get(i).getId() == id){
                System.out.println("<Linear search in unsorted array>\tsteps to find "+
                        array.get(i).toString() + " ====> " + i);
                return i;
            }
        }
        System.out.println("Element not found!");
        return -1;
    }


}
