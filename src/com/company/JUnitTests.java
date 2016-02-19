package com.company;

import com.company.MyCollection.ArrayListM;
import com.company.MyCollection.LinkedListM;
import com.company.MyCollection.SetM;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Lego on 17.02.2016.
 * @version 1.0
 */
public class JUnitTests {

    ArrayListM<Integer> al = new ArrayListM<>();
    LinkedListM<Integer> ll = new LinkedListM<>();
    SetM<Integer> setM = new SetM<>();

    @Before
    public void b(){
        setM = new SetM<>();
        al = new ArrayListM<>();
        ll = new LinkedListM<>();
    }

    @Test
    public void test1(){
        al.add(1);
        int exp = 1;
        int act = al.size();
        assertEquals(act, exp);
    }

    @Test
    public void testSetM(){
        setM.add(4);
        setM.add(4);
        int exp = 4;
        int act = setM.get(0);
        assertEquals(act, exp);
    }

    @Test
    public void testReverseWithEvenLengthOfArray() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        al.init(numbers);
        al.reverse();
        assertArrayEquals(new Integer[]{6, 5, 4, 3, 2, 1}, al.getArray());
    }

    @Test
    public void testReverseWithOddLengthOfArray() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        al.init(numbers);
        al.reverse();
        assertArrayEquals(new Integer[]{7, 6, 5, 4, 3, 2, 1}, al.getArray());
    }

    @Test
    public void testReverseWithEmptyArray() {
        Integer[] numbers = {};
        al.init(numbers);
        al.reverse();
        assertArrayEquals(new Integer[]{}, al.getArray());
    }

    @Test
    public void testReverseWithNullArray() {
        Integer[] numbers = null;
        al.init(numbers);
        al.reverse();
        assertArrayEquals(null, al.getArray());
    }

    @Test
    public void testReverseWithJustOneElementArray() {
        Integer[] numbers = {1};
        al.init(numbers);
        al.reverse();
        assertArrayEquals(new Integer[]{1}, al.getArray());
    }


    @Test
    public void testSet(){
        Integer[] numbers = {1,3,4,3};
        setM.init(numbers);

        assertArrayEquals(new Integer[]{1, 3, 4}, setM.getArray());
    }

    @Test
    public void LinkedListTest(){

        ll.add(1);
        ll.add(2);
//        ll.add(3);
//       ll.add(2, 3);
//        ll.remove(2);
        assertArrayEquals(new Integer[]{1, 2,3}, ll.getArray());
    }







}
