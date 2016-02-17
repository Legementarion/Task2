package com.company;

import com.company.MyCollection.ArrayListM;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Lego on 17.02.2016.
 * @version 1.0
 */
public class JUnitTests {

    ArrayListM<Integer> al = new ArrayListM<>();

    @Before
    public void b(){
        al = new ArrayListM<>();
    }

    @Test
    public void test1(){
        al.add(1);
        int exp = 1;
        int act = al.size();
        assertEquals(act, exp);
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
