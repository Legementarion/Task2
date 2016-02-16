package com.company;


import com.company.MyCollection.ArrayListM;
import com.company.MyCollection.LinkedListM;
import com.company.MyCollection.MyType;

import java.util.ArrayList;
import java.util.List;

/**
 * Main start class
 */
public class Main {

    public static void main(String[] args) {

        int chouse = 0;
        ArrayListM<Integer> fd= new ArrayListM<>();
        fd.add(1);
        fd.add(0, 3);
        fd.add(2);
        Integer[] eee = new Integer[]{1,3,2};
        fd.init(eee);
        System.out.println(fd.get(0) + " " + fd.get(1) + " " + fd.get(2));
        fd.remove(0);
        System.out.println(fd.get(0) + " " + fd.get(1) + " ");

        System.out.println("1 - Arraylist, 2 - LinkedList; 3 - Map; 4 - Set;");
        System.out.println("please enter your chouse");



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
