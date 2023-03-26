package org.example.lab2;

import org.example.lab0.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lab2 {

    /*to build header for native functions, you first need to compile:
     1) Measure.java, 2) Product.java,
     3) add previous compiled classes and all import jars (they lay in project/lib/*")
     to javac -classpath when compiling Lab2.class
     4) create header with "javac -h dest_path src_path_Lab2.java"
        **it's better to compile all inside "src/main/java/" dir**
     */

    //TODO: change library path to source dir (-Djava.library.path="/path/to/mylib")

    /* .dll for sortings lays in the system library path. (prog.files/java/jdk/bin) */
    /* move mylib.dll to your lib path */



    //the source code for native methods lays in https://github.com/maryiarotar/ASDC02/ (it's a Rust project) */
    // mylib.dll (lib for windows) lays in lab_asdc/lib/mylib.dll
    //lib for linux hasn't yet compiled
    private static native String bubbleSort(String path);
    private static native String insertionSort(String path);
    private static native String selectionSort(String path);
    private static native String shellSort(String path);
    private static native String mergeSort(String path);

    static {
        //?add checking "if system linux - then to change mylib.dll to linux library"??

        System.loadLibrary("mylib");
    }


    public static void main(String[] args) throws IOException {


        String strB = bubbleSort("./UNSORTED.json");
        System.out.println(strB + "\n----best: O(n), average: O(n^2), worst: O(n^2)-------\n");

        String strI = insertionSort("./UNSORTED.json");
        System.out.println(strI + "\n----best: O(n), average: O(n^2), worst: O(n^2)-------\n");

        String strS = selectionSort("./UNSORTED.json");
        System.out.println(strS + "\n----best: O(n^2), average: O(n^2), worst: O(n^2)-------\n");

        String strSh = shellSort("./UNSORTED.json");
        System.out.println(strSh + "\n----best: O(n), average: O((nlog(n))^2), worst: O((nlog(n))^2)-------\n");

        String strM = mergeSort("./UNSORTED.json");
        System.out.println(strM + "\n----best: O(nlog(n)), average: O(nlog(n)), worst: O(nlog(n))-------\n");





/*
        // Bubble sort just for comparison
        String file = "./UNSORTED.json";
        List<Product> products = Product.readFromFile(file);

        long startTime = System.nanoTime();

        for (int i = 0; i< products.size(); i++){
            for (int j = 1; j < products.size(); j++){
                if (products.get(j-1).getId() > products.get(j).getId() ){
                    Product tmp = products.get(j-1);
                    products.set(j-1, products.get(j));
                    products.set(j, tmp);

                }
            }
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("\nPerformance time for Java Bubble sort in seconds: " + elapsedTime / 1000000000.0);
*/
    }


}
