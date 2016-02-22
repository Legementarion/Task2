package com.company;

import com.company.MyCollection.ArrayListM;
import com.company.MyCollection.LinkedListM;
import com.company.MyCollection.MapM;
import com.company.MyCollection.SetM;

import java.util.Scanner;

/**
 * Class presentation of work for boss and other
 * @author Lego on 16.02.2016.
 * @version 1.0
 */
public class Presentation implements Connect{

    /**buffer */
    static StringBuilder buf;

    /** input value from keyboard*/
    static Scanner in;

    /**position in array */
    public int index = -1;

    /**incoming value for array */
    public int value = -1;


    SetM<Integer> setM = new SetM<>();

    /** SET*/
    public void presentSet(int size){

        setM.init(fillCollection(size));
        in = new Scanner(System.in);

        //add
        buf = new StringBuilder("");
        System.out.println(soutArray[0]);
        boolean ok = true;
        while(ok){
            System.out.println(soutSet[0]);
            if(in.hasNextInt()){
                setM.add(in.nextInt());
                buf.setLength(0);
                printS(setM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                    buf.setLength(0);
                } else {
                    in.reset();
                    buf.setLength(0);
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        //insert
        System.out.println(soutArray[1]);
        ok = true;
        ok = true;
        boolean bvalue;
        while(ok) {
            index = -1;
            bvalue = true;
            System.out.println(soutSet[1]);

            while (index <= -1) {
                if (in.hasNextInt()) {
                    index = in.nextInt();
                    buf.setLength(0);
                } else {
                    buf.append(in.next());
                    if (buf.toString().equals("next")) {
                        bvalue = false;
                        index = -1;
                        ok = false;
                        buf.setLength(0);
                        break;
                    } else {
                        in.reset();
                        buf.setLength(0);
                        System.out.println(soutMenu[2]);
                        System.out.println();
                    }
                }
            }
            while (bvalue) {
                if (in.hasNextInt()) {
                    value = in.nextInt();
                    buf.setLength(0);
                    bvalue = false;
                } else {
                    buf.append(in.next());
                    if (buf.toString().equals("next")) {
                        bvalue = false;
                        ok = false;
                        buf.setLength(0);
                        break;
                    } else {
                        in.reset();
                        buf.setLength(0);
                        System.out.println(soutMenu[2]);
                        System.out.println();
                    }
                }
            }
            if (index != -1) {
                setM.add(index, value);
                printS(setM);
            }
        }


        //get
        System.out.println(soutArray[2]);
        ok = true;
        while(ok){
            System.out.println(soutSet[2]);
            if(in.hasNextInt()){
                System.out.println(setM.get(in.nextInt()));
                buf.setLength(0);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                    buf.setLength(0);
                } else {
                    in.reset();
                    buf.setLength(0);
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        //remove by index
        System.out.println(soutArray[3]);
        ok = true;
        while(ok){
            System.out.println(soutSet[3]);
            if(in.hasNextInt()){
                setM.remove(in.nextInt());
                buf.setLength(0);
                printS(setM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                    buf.setLength(0);
                } else {
                    in.reset();
                    buf.setLength(0);
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }



        //set
        System.out.println(soutArray[4]);
        ok = true;
        while(ok){
            index = -1;
            bvalue = true;
            System.out.println(soutSet[4]);

            while (index <= -1) {
                if (in.hasNextInt()) {
                    index = in.nextInt();
                    buf.setLength(0);
                } else {
                    buf.append(in.next());
                    if (buf.toString().equals("next")) {
                        bvalue =false;
                        index = -1;
                        ok = false;
                        buf.setLength(0);
                        break;
                    } else {
                        in.reset();
                        buf.setLength(0);
                        System.out.println(soutMenu[2]);
                        System.out.println();
                    }
                }
            }
            while (bvalue){
                if (in.hasNextInt()) {
                    value = in.nextInt();
                    buf.setLength(0);
                    bvalue=false;
                } else {
                    buf.append(in.next());
                    if (buf.toString().equals("next")) {
                        bvalue = false;
                        ok = false;
                        buf.setLength(0);
                        break;
                    } else {
                        in.reset();
                        buf.setLength(0);
                        System.out.println(soutMenu[2]);
                        System.out.println();
                    }
                }
            }
            if (index!=-1){
                setM.set(index, value);
                printS(setM);
            }

        }

        //reverse
        System.out.println(soutArray[5]);
        ok = true;
        while(ok) {
            System.out.println(soutSet[5]);
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

        //size
        System.out.println(soutArray[6]);
        ok = true;
        while(ok){
            System.out.println(soutSet[6]);
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

        //init
        System.out.println(soutArray[7]);
        ok = true;
        int i = 0;
        System.out.println("enter size of input mass");
        int sizea = in.nextInt();
        Integer[] numbers = new Integer[sizea];
        while(ok) {
            System.out.println(soutSet[7]);
            while (i < sizea) {
                if (in.hasNextInt()) {
                    numbers[i] = in.nextInt();
                    i++;
                }
            }
            setM.init(numbers);
            printS(setM);
            buf.setLength(0);
            buf.append(in.next());
            if (buf.toString().equals("next")) {
                ok = false;
                break;

            }else {
                in.reset();
                buf.setLength(0);
                System.out.println(soutMenu[2]);
                System.out.println();
            }
        }

        //sort
        System.out.println(soutArray[8]);
        ok = true;
        while(ok){
            System.out.println(soutSet[8]);
            if(in.hasNextBoolean()){
                setM.sort(in.nextBoolean());
                buf.setLength(0);
                printS(setM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    buf.setLength(0);
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }


        //max & min
        System.out.println(soutArray[9]);
        System.out.println(setM.min() + " min");
        System.out.println(setM.max() + " max");
    }


    public void presentMap(int size){
        MapM mapM = new MapM();
        in = new Scanner(System.in);
        buf = new StringBuilder("");
        System.out.println(soutArray[0]);
        boolean ok = true;
        while(ok){
            System.out.println("add to SET -");
            if(in.hasNextInt()){
//                mapM.add(in.nextInt());
                buf.setLength(0);
                printS(mapM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                    break;
                } else {
                    in.reset();
                    buf.setLength(0);
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[1]);
        ok = true;
        while(ok){
            System.out.println("add to SET by index -");
            if(in.hasNextInt()){
//                mapM.add(in.nextInt());
                buf.setLength(0);
                printS(mapM);
            } else {
                buf.append(in.next());
                if (buf.equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[2]);
        ok = true;
        while(ok){
            System.out.println("get from set -");
            if(in.hasNextInt()){
                System.out.println(mapM.get(in.nextInt()));
                buf.setLength(0);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[3]);
        ok = true;
        while(ok){
            System.out.println("Remove from set -");
            if(in.hasNextInt()){
                mapM.remove(in.nextInt());
                buf.setLength(0);
                printS(mapM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[4]);
        ok = true;
        while(ok){
            System.out.println("set to SET -");
            if(in.hasNextInt()){
//                mapM.add(in.nextInt());
                buf.setLength(0);
                printS(mapM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[5]);
        ok = true;
        while(ok) {
            System.out.println("Type anything to reverse");
            if (in.hasNext()) {
                buf.append(in.next());
                if (buf.toString().equals("next")) {
                    ok = false;
                } else {
                    mapM.reverse();
                    buf.setLength(0);
                    printS(mapM);
                    in.reset();
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[6]);
        ok = true;
        while(ok){
            System.out.println("Type anything to see size-");
            if (in.hasNext()) {
                buf.append(in.next());
                if (buf.toString().equals("next")) {
                    ok = false;
                } else {
                    System.out.println(mapM.size());
                    buf.setLength(0);
                    in.reset();
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[7]);
        ok = true;
        while(ok){
            System.out.println("add to set -");
            if(in.hasNextInt()){
//                mapM.add(in.nextInt());
                buf.setLength(0);
                printS(mapM);
            } else {
                buf.append(in.next());
                if (buf.equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }


    }


    public void presentLink(int size){
        LinkedListM<Integer> linkedList = new LinkedListM<>();
        linkedList.init(fillCollection(size));
        in = new Scanner(System.in);
        buf = new StringBuilder("");
        System.out.println(soutArray[0]);
        boolean ok = true;
        while(ok){
            System.out.println("add to SET -");
            if(in.hasNextInt()){
                linkedList.add(in.nextInt());
                buf.setLength(0);
                printS(linkedList);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                    break;
                } else {
                    in.reset();
                    buf.setLength(0);
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[1]);
        ok = true;
        while(ok){
            System.out.println("add to SET by index -");
            if(in.hasNextInt()){
                linkedList.add(in.nextInt());
                buf.setLength(0);
                printS(linkedList);
            } else {
                buf.append(in.next());
                if (buf.equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[2]);
        ok = true;
        while(ok){
            System.out.println("get from set -");
            if(in.hasNextInt()){
                System.out.println(linkedList.get(in.nextInt()));
                buf.setLength(0);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[3]);
        ok = true;
        while(ok){
            System.out.println("Remove from set -");
            if(in.hasNextInt()){
                linkedList.remove(in.nextInt());
                buf.setLength(0);
                printS(linkedList);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[4]);
        ok = true;
        while(ok){
            System.out.println("set to SET -");
            if(in.hasNextInt()){
                linkedList.add(in.nextInt());
                buf.setLength(0);
                printS(linkedList);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[5]);
        ok = true;
        while(ok) {
            System.out.println("Type anything to reverse");
            if (in.hasNext()) {
                buf.append(in.next());
                if (buf.toString().equals("next")) {
                    ok = false;
                } else {
                    linkedList.reverse();
                    buf.setLength(0);
                    printS(linkedList);
                    in.reset();
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[6]);
        ok = true;
        while(ok){
            System.out.println("Type anything to see size-");
            if (in.hasNext()) {
                buf.append(in.next());
                if (buf.toString().equals("next")) {
                    ok = false;
                } else {
                    System.out.println(linkedList.size());
                    buf.setLength(0);
                    in.reset();
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[7]);
        ok = true;
        while(ok){
            System.out.println("add to set -");
            if(in.hasNextInt()){
                linkedList.add(in.nextInt());
                buf.setLength(0);
                printS(linkedList);
            } else {
                buf.append(in.next());
                if (buf.equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

    }


    public void presentArray(int size){
        ArrayListM<Integer> listM = new ArrayListM<>();
        listM.init(fillCollection(size));
        in = new Scanner(System.in);
        buf = new StringBuilder("");
        System.out.println(soutArray[0]);
        boolean ok = true;
        while(ok){
            System.out.println("add to SET -");
            if(in.hasNextInt()){
                listM.add(in.nextInt());
                buf.setLength(0);
                printS(listM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                    break;
                } else {
                    in.reset();
                    buf.setLength(0);
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[1]);
        ok = true;
        while(ok){
            System.out.println("add to SET by index -");
            if(in.hasNextInt()){
                listM.add(in.nextInt());
                buf.setLength(0);
                printS(listM);
            } else {
                buf.append(in.next());
                if (buf.equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[2]);
        ok = true;
        while(ok){
            System.out.println("get from set -");
            if(in.hasNextInt()){
                System.out.println(listM.get(in.nextInt()));
                buf.setLength(0);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[3]);
        ok = true;
        while(ok){
            System.out.println("Remove from set -");
            if(in.hasNextInt()){
                listM.remove(in.nextInt());
                buf.setLength(0);
                printS(listM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[4]);
        ok = true;
        while(ok){
            System.out.println("set to SET -");
            if(in.hasNextInt()){
                listM.add(in.nextInt());
                buf.setLength(0);
                printS(listM);
            } else {
                buf.append(in.next());
                if (buf.toString().equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[5]);
        ok = true;
        while(ok) {
            System.out.println("Type anything to reverse");
            if (in.hasNext()) {
                buf.append(in.next());
                if (buf.toString().equals("next")) {
                    ok = false;
                } else {
                    listM.reverse();
                    buf.setLength(0);
                    printS(listM);
                    in.reset();
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[6]);
        ok = true;
        while(ok){
            System.out.println("Type anything to see size-");
            if (in.hasNext()) {
                buf.append(in.next());
                if (buf.toString().equals("next")) {
                    ok = false;
                } else {
                    System.out.println(listM.size());
                    buf.setLength(0);
                    in.reset();
                    System.out.println();
                }
            }
        }

        System.out.println(soutArray[7]);
        ok = true;
        while(ok){
            System.out.println("add to set -");
            if(in.hasNextInt()){
                listM.add(in.nextInt());
                buf.setLength(0);
                printS(listM);
            } else {
                buf.append(in.next());
                if (buf.equals("next")){
                    ok = false;
                } else {
                    in.reset();
                    System.out.println(soutMenu[2]);
                    System.out.println();
                }
            }
        }

    }


    public Integer[] fillCollection(int size){
        Integer[] num = new Integer[size];

        for(int i = 0; i <size; i++){
            num[i] = (int)(Math.random() *100);
            for(int j = 0; j < i; j++){
                if (num[i]== num[j]){
                    i--;
                }
            }

        }

        return num;
    }


    public static void printS(SetM setM){
        for (int i = 0; i < setM.size(); i++){
            System.out.print(setM.get(i)+" ");
        }
        System.out.println("");
    }

    public static void printS(LinkedListM linkedListM){
        for (int i = 0; i < linkedListM.size(); i++){
            System.out.print(linkedListM.get(i)+" ");
        }
        System.out.println("");
    }

    public static void printS(ArrayListM arrayListM){
        for (int i = 0; i < arrayListM.size(); i++){
            System.out.print(arrayListM.get(i)+" ");
        }
        System.out.println("");
    }

    public static void printS(MapM mapM){
        for (int i = 0; i < mapM.size(); i++){
            System.out.print(mapM.get(i)+" ");
        }
        System.out.println("");
    }
}
