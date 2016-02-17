package com.company;


import com.company.MyCollection.ArrayListM;
import com.company.MyCollection.LinkedListM;
import com.company.MyCollection.MyType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * Main start class
 */
public class Main {

    public static void main(String[] args) {

        /** input value from keyboard*/
        Scanner in = new Scanner(System.in);

        /** */
        StringBuilder buf = new StringBuilder("");

        /** value for chouse*/
        int chouse = 0;


        while ((chouse<1)||(chouse>4)) {
            System.out.println("1 - Arraylist, 2 - LinkedList; 3 - Map; 4 - Set;");
            System.out.println("please enter your chouse");
            try {
                chouse = in.nextInt();
            } catch (InputMismatchException ex) {
                ex.printStackTrace();
                chouse = 0;
                in.reset();
                System.out.println(" -only number!!");
            }
        }

//        LinkedListM<Integer> ol = new LinkedListM<>();
//        ol.add(1);
//        ol.add(2);
//        ol.add(3);
//        ol.add(2, 3);
//        System.out.println(ol.get(0) + " " + ol.get(1) + " " + ol.get(2));
//        ol.remove(2);
//        System.out.println(ol.get(0) + " " + ol.get(1) + " " + ol.get(2));
    }
}
