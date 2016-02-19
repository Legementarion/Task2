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
public class Main {

    /** */
    static StringBuilder buf;

    /** input value from keyboard*/
    static Scanner in;


    public static void main(String[] args) {




        /** value for choise*/
        int choice = 0;

        int size = 0;


        while ((choice<1)||(choice>4)) {
            in = new Scanner(System.in);
            System.out.println("1 - Arraylist, 2 - LinkedList; 3 - Map; 4 - Set;");
            System.out.println("please enter your choice");
            try {
                if (in.hasNextInt()) {
                    choice = in.nextInt();
                } else {
                    in.reset();
                    System.out.println("Only number!!!");
                    System.out.println();
                }
            } catch (InputMismatchException ex) {
                ex.printStackTrace();
                choice = 0;
                System.out.println(" - only number!!");
            }
        }
            while (size==0){
                in = new Scanner(System.in);
                System.out.println("please enter size of Array");
                if(in.hasNextInt()){
                    size = in.nextInt();
                }
                else {
                    in.reset();
                    System.out.println(" - only number!!!");
                    System.out.println();
                }
            }


        switch (choice){
            case 1: ArrayListM<Integer> listM = new ArrayListM<>();
                listM.init(fillCollection(size));
                testA(listM);
                break;
            case 2: LinkedListM<Integer> linkedList = new LinkedListM<>();
                linkedList.init(fillCollection(size));
                testL(linkedList);
                break;
            case 3: MapM<Integer,Integer> mapM = new MapM<>();

                break;
            case 4:
                SetM<Integer> setM = new SetM<>();
                setM.init(fillCollection(size));
                printS(setM);
                testS(setM);
                break;
        }
//        FileMain fileMain = new FileMain();
//        fileMain.start();
    }

    public static Integer[] fillCollection(int size){
        Integer[] num = new Integer[size];

        for(int i = 0; i <size; i++){
            num[i] = (int)(Math.random() *100);
        }

        return num;
    }


    public static void testA(ArrayListM arrayListM){
        System.out.println(arrayListM);
    }

    public static void testL(LinkedListM linkedListM){

    }

    public static void testM(MapM mapM){

    }

    public static void testS(SetM setM){
        buf = new StringBuilder("");
        System.out.println("-----------------   1. ADD  ------------------------");
        boolean ok = true;
            while(ok){
                System.out.println("add to SET -");
                if(in.hasNextInt()){
                    setM.add(in.nextInt());
                    buf.setLength(0);
                    printS(setM);
                } else {
                    buf.append(in.next());
                    if (buf.toString().equals("next")){
                        ok = false;
                        break;
                    } else {
                        in.reset();
                        buf.setLength(0);
                        System.out.println(" - only number!!!");
                        System.out.println();
                    }
                }
            }

//        System.out.println("-----------------   1.1 ADD(INSERT)  ------------------------");
//        ok = true;
//        while(ok){
//            System.out.println("add to SET by index -");
//            if(in.hasNextInt()){
//                setM.add(in.nextInt());
//                buf.setLength(0);
//                printS(setM);
//            } else {
//                buf.append(in.next());
//                if (buf.equals("next")){
//                    ok = false;
//                } else {
//                    in.reset();
//                    System.out.println(" - only number!!!");
//                    System.out.println();
//                }
//            }
//        }

        System.out.println("-----------------   2. GET  ------------------------");
        ok = true;
        while(ok){
            System.out.println("get from set -");
            if(in.hasNextInt()){
                System.out.println(setM.get(in.nextInt()));
                buf.setLength(0);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(" - only number!!!");
                    System.out.println();
                }
            }
        }

        System.out.println("-----------------   3. REMOVE  ------------------------");
        ok = true;
        while(ok){
            System.out.println("Remove from set -");
            if(in.hasNextInt()){
                setM.remove(in.nextInt());
                buf.setLength(0);
                printS(setM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(" - only number!!!");
                    System.out.println();
                }
            }
        }

        System.out.println("-----------------   4. SET  ------------------------");
        ok = true;
        while(ok){
            System.out.println("set to SET -");
            if(in.hasNextInt()){
                setM.add(in.nextInt());
                buf.setLength(0);
                printS(setM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(" - only number!!!");
                    System.out.println();
                }
            }
        }

        System.out.println("-----------------   5. REVERSE  ------------------------");
        ok = true;
        while(ok) {
            System.out.println("Type anything to reverse");
            if (in.hasNext()) {
                buf.append(in.next());
                if (buf.toString().equals("next")) {
                    ok = false;
                } else {
                    setM.reverse();
                    buf.setLength(0);
                    printS(setM);
                    in.reset();
                    System.out.println();
                }
            }
        }

        System.out.println("-----------------   6. SIZE  ------------------------");
        ok = true;
        while(ok){
            System.out.println("Type anything to see size-");
            if (in.hasNext()) {
                buf.append(in.next());
                if (buf.toString().equals("next")) {
                    ok = false;
                } else {
                    System.out.println(setM.size());
                    buf.setLength(0);
                    in.reset();
                    System.out.println();
                }
            }
        }

        System.out.println("-----------------   7. INIT  ------------------------");
        ok = true;
//        while(ok){
//            System.out.println("add to set -");
//            if(in.hasNextInt()){
//                setM.add(in.nextInt());
//                buf.setLength(0);
//                printS(setM);
//            } else {
//                buf.append(in.next());
//                if (buf.equals("next")){
//                    ok = false;
//                } else {
//                    in.reset();
//                    System.out.println(" - only number!!!");
//                    System.out.println();
//                }
//            }
//        }

    }

    public static void printS(SetM setM){
        for (int i = 0; i < setM.size(); i++){
            System.out.print(setM.get(i)+" ");
        }
        System.out.println("");
    }

}
