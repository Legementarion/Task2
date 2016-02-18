package com.company;


import com.company.FileTask.FileMain;

import java.util.InputMismatchException;
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


//        while ((chouse<1)||(chouse>4)) {
//            System.out.println("1 - Arraylist, 2 - LinkedList; 3 - Map; 4 - Set;");
//            System.out.println("please enter your chouse");
//            try {
//                chouse = in.nextInt();
//            } catch (InputMismatchException ex) {
//                ex.printStackTrace();
//                chouse = 0;
//                in.reset();
//                System.out.println(" -only number!!");
//            }
//        }

//        FileMain fileMain = new FileMain();
//        fileMain.start();

    }
}
