package org.example.lab1;

import lombok.Getter;
import lombok.Setter;
import org.example.lab0.Product;

import java.util.*;

/* binary search method and method to make a tree from array */
@Getter
@Setter
public class BinaryTreeSearch {

    BinaryTree head;

    public BinaryTreeSearch(){
        head = new BinaryTree();
    }

    public void makeBinaryTree(List<Product> list, Integer index, BinaryTree root) {

        if (root == null) {
            this.head.setNode(list.get(0));
            root = head;
            index = 1;
        }

        for (int i = index; i< list.size(); i++){
            if (list.get(i).getId() < root.getNode().getId()){
                if (root.hasLeft()){
                    makeBinaryTree(list, i, root.getLeftChild());
                    break;
                }
                root.setLeftChild(new BinaryTree(list.get(i)));
            }

            if (list.get(i).getId() > root.getNode().getId()){
                if (root.hasRight()){
                    makeBinaryTree(list, i, root.getRightChild());
                    break;
                }
                root.setRightChild(new BinaryTree(list.get(i)));
            }
            root = head;
        }
    }


    public int binaryTreeSearch(int id){

        if (this.head == null){
            return -1;
        }
        int stepsToFind = 0;

        BinaryTree current = head;
        while (true){
            stepsToFind++;

            if (current.getNode().getId() < id) {
                if (!current.hasRight()){
                    break;
                }
                current = current.getRightChild();
            }
            if (current.getNode().getId() > id){
                if (!current.hasLeft()){
                    break;
                }
                current = current.getLeftChild();
            }
            if (current.getNode().getId() == id){
                System.out.println("<Search in Binary Tree of unsorted array>\t" +
                        "steps to find product with ID [" + id +"]  ====> " + stepsToFind);
                return stepsToFind;
            }
        }
        System.out.println("Product with id=" +
                id + " ----> is not found!");
        return -1;
    }



}
