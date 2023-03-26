package org.example.lab1;

import org.example.lab0.Product;

import java.util.List;

/* binary search for sorted array */
public class BinarySearch {

    public static int binarySearch(List<Product> array, int id) {
        int left = 0;
        int right = array.size() - 1;

        int stepsToFind = 1;
        System.out.println("<Binary Search> for Product id[" + id +"]");

        while (left + 1 <= right) {

            int middle = (left + right) / 2;

            if (array.get(middle).getId() == id) {
                System.out.println("\tsteps to find element: ====> " + stepsToFind);
                return stepsToFind;
            }

            if (array.get(middle).getId() < id) {
                left = middle + 1;
            } else {
                right = middle;
            }
            stepsToFind++;
        }
        System.out.println("Product is not found!");
        return -1;
    }


    public static int interpolationSearch(List<Product> array, int id) {
        int low = 0;
        int high = array.size() - 1;

        int stepsToFind = 1;
        System.out.println("<Interpolation Search> for Product id [" + id +"]");

        while (low <= high && id >= array.get(low).getId() && id <= array.get(high).getId()) {

            if (low == high) {
                if (id == array.get(low).getId()) {
                    break;
                }
                System.out.println("Product is not found!");
                return -1;
            }

            int pos = low + ((id - array.get(low).getId()) * (high - low))
                    / (array.get(high).getId() - array.get(low).getId());

            if (id == array.get(pos).getId()) {
                break;
            }
            if (id > array.get(pos).getId()) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
            stepsToFind++;
        }
        System.out.println("\tsteps to find ====> " + stepsToFind);
        return stepsToFind;
    }


}
