package com.company;


import com.company.ClientServer.MainControlConnection;
import com.company.FileTask.FileMain;
import com.company.MyCollection.ArrayListM;
import com.company.MyCollection.LinkedListM;
import com.company.MyCollection.MapM;
import com.company.MyCollection.SetM;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Main start class
 */
public class Main implements Connect{

    /** */
    static StringBuilder buf;

    /** input value from keyboard*/
    static Scanner in;


    public static void main(String[] args) {

        Presentation present = new Presentation();

        /** value for choise*/
        int choice = 0;


        int size = 0;



        while ((choice<1)||(choice>4)) {
            in = new Scanner(System.in);
            System.out.println(soutMenu[0]);
            System.out.println(soutMenu[1]);
            try {
                if (in.hasNextInt()) {
                    choice = in.nextInt();
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            } catch (InputMismatchException ex) {
                ex.printStackTrace();
                choice = 0;
                System.out.println(soutMenu[2]);
            }
        }
            while (size==0){
                in = new Scanner(System.in);
                System.out.println(soutMenu[3]);
                if(in.hasNextInt()){
                    size = in.nextInt();
                }
                else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }


        switch (choice){
            case 1:
                present.presentArray(size);
                break;
            case 2:
                present.presentLink(size);
                break;
            case 3:
                present.presentMap(size);
                break;
            case 4:
                present.presentSet(size);
                break;
        }
//        FileMain fileMain = new FileMain();
//        fileMain.start();
    }
}
