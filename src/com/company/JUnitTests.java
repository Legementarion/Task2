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

    ArrayListM<Integer> tst = new ArrayListM<>();
    LinkedListM<Integer> ll = new LinkedListM<>();
    SetM<Integer> setM = new SetM<>();

    @Before
    public void b(){
        setM = new SetM<>();
        tst = new ArrayListM<>();
        ll = new LinkedListM<>();
    }

    @Test
    public void test1(){
        tst.add(1);
        int exp = 1;
        int act = tst.size();
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
        tst.init(numbers);
        tst.reverse();
        assertArrayEquals(new Integer[]{6, 5, 4, 3, 2, 1}, tst.getArray(new Integer[tst.size()]));
    }

    @Test
    public void testReverseWithOddLengthOfArray() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        tst.init(numbers);
        tst.reverse();
        assertArrayEquals(new Integer[]{7, 6, 5, 4, 3, 2, 1}, tst.getArray(new Integer[tst.size()]));
    }

    @Test
    public void testReverseWithEmptyArray() {
        Integer[] numbers = {};
        tst.init(numbers);
        tst.reverse();
        assertArrayEquals(new Integer[]{}, (new Integer[tst.size()]));
    }

    @Test
    public void testReverseWithNullArray() {
        Integer[] numbers = null;
        Integer[] test ={};
        tst.init(numbers);
        tst.reverse();
        assertArrayEquals(test, tst.getArray(new Integer[tst.size()]));
    }

    @Test
    public void testReverseWithJustOneElementArray() {
        Integer[] numbers = {1};
        tst.init(numbers);
        tst.reverse();
        assertArrayEquals(new Integer[]{1}, tst.getArray(new Integer[tst.size()]));
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
        ll.add(3);
        ll.add(2, 3);
        ll.remove(2);
        assertArrayEquals(new Integer[]{1,2,3}, ll.getArray());
    }

    @Test
    public void testSize_null()
    {
        Integer[] ini = null;
        tst.init(ini);
        assertEquals(0, tst.size());
    }
    @Test
    public void testSize_0()
    {
        Integer[] ini = new Integer[0];
        tst.init(ini);
        assertEquals(0, tst.size());
    }
    @Test
    public void testSize_1()
    {
        Integer[] ini = {10};
        tst.init(ini);
        assertEquals(1, tst.size());
    }
    @Test
    public void testSize_2()
    {
        Integer[] ini = {10,20};
        tst.init(ini);
        assertEquals(2, tst.size());
    }
    @Test
    public void testSize_3()
    {
        Integer[] ini = {10,20,30};
        tst.init(ini);
        assertEquals(3, tst.size());
    }
    @Test
    public void testSize_4()
    {
        Integer[] ini = {10,20,30,40};
        tst.init(ini);
        assertEquals(4, tst.size());
    }
    @Test
    public void testSize_many()
    {
        Integer[] ini = {10,20,30,40,50,60};
        tst.init(ini);
        assertEquals(6, tst.size());
    }
    @Test
    public void testSize_many_ForAListR()
    {
        Integer[] ini = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60};
        tst.init(ini);
        assertEquals(60, tst.size());
    }
    @Test
    public void testSize_many_ForAListR_100()
    {
        Integer[] ini = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
        tst.init(ini);
        assertEquals(100, tst.size());
    }
    @Test
    public void testSize_many_ForAListR_101()
    {
        Integer[] ini = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101};
        tst.init(ini);
        assertEquals(101, tst.size());
    }


    //============================================
    //              Clear
    //============================================
    @Test
    public void testClear_null()
    {
        Integer[] ini ={};
        tst.init(ini);
        tst.clear();
        assertEquals(0, tst.size());
    }
    @Test
    public void testClear_0()
    {
        Integer[] ini = new Integer[0];
        tst.init(ini);
        tst.clear();
        assertEquals(0, tst.size());
    }
    @Test
    public void testClear_1()
    {
        Integer[] ini ={10};
        tst.init(ini);
        tst.clear();
        assertEquals(0, tst.size());
    }
    @Test
    public void testClear_2()
    {
        Integer[] ini ={10,20};
        tst.init(ini);
        tst.clear();
        assertEquals(0, tst.size());
    }
    @Test
    public void testClear_many()
    {
        Integer[] ini ={10,20,30,40,50};
        tst.init(ini);
        tst.clear();
        assertEquals(0, tst.size());
    }
    @Test
    public void testClear_many_ForAListR()
    {
        Integer[] ini ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60};
        tst.init(ini);
        tst.clear();
        assertEquals(0, tst.size());
    }

    //============================================
    //              Init
    //============================================
    @Test
    public void testInit_null()
    {
        Integer[] ini = null;
        tst.init(ini);
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testInit_0()
    {
        Integer[] ini = {};
        tst.init(ini);
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testInit_1()
    {
        Integer[] ini = {10};
        tst.init(ini);
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {10};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testInit_2()
    {
        Integer[] ini = {10,20};
        tst.init(ini);
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {10,20};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testInit_many()
    {
        Integer[] ini = {10,20,30,40,50,60,70};
        tst.init(ini);
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {10,20,30,40,50,60,70};
        assertArrayEquals(expected, actual);
    }

    //============================================
    //              Add
    //============================================
    @Test
    public void testAddEnd_null()
    {
        Integer[] ini = null;
        tst.init(ini);
        tst.add(3);
        assertEquals(1, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {3};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddEnd_0()
    {
        Integer[] ini = {};
        tst.init(ini);
        tst.add(3);
        assertEquals(1, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {3};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddEnd_1()
    {
        Integer[] ini = {132};
        tst.init(ini);
        tst.add(3);
        assertEquals(2, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {132,3};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddEnd_2()
    {
        Integer[] ini = {10,20};
        tst.init(ini);
        tst.add(30);
        assertEquals(3, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {10,20,30};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddEnd_many()
    {
        Integer[] ini = {132,435,57,9,2};
        tst.init(ini);
        tst.add(3);
        assertEquals(6, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {132,435,57,9,2,3};
        assertArrayEquals(expected, actual);
    }

    //============================================
    //              AddPos
    //============================================
    @Test
    public void testAddPos_null()
    {
        Integer[] ini = null;
        tst.init(ini);
        tst.add(0, 0);
        assertEquals(1, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {0};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddPos_0()
    {
        Integer[] ini = {};
        tst.init(ini);
        tst.add(0, 0);
        assertEquals(1, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {0};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddPos_1()
    {
        Integer[] ini = {132};
        tst.init(ini);
        tst.add(1, 1);
        assertEquals(2, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {132,1};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddPos_2()
    {
        Integer[] ini = {10,20};
        tst.init(ini);
        tst.add(2, 30);
        assertEquals(3, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {10,20,30};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddPos_many1()
    {
        Integer[] ini = {10,20,30,40,50,60,70};
        tst.init(ini);
        tst.add(3, 80);
        assertEquals(8, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {10,20,30,80,40,50,60,70};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddPos_many2()
    {
        Integer[] ini = {10,20,30,40,50,60,70};
        tst.init(ini);
        tst.add(7, 80);
        assertEquals(8, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {10,20,30,40,50,60,70,80};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddPos_many3()
    {
        Integer[] ini = {10,20,30,40,50,60,70};
        tst.init(ini);
        tst.add(0, 80);
        assertEquals(8, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {80,10,20,30,40,50,60,70};
        assertArrayEquals(expected, actual);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddPos_Ex1()
    {
        Integer[] ini = {1,4,6,8};
        tst.init(ini);
        tst.add(5, 344);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddPos_Ex2()
    {
        Integer[] ini = {1,4,6,8};
        tst.init(ini);
        tst.add(-1, 344);
    }

    //============================================
    //              DelPos
    //============================================
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testDelPos_null()
    {
        Integer[] ini = null;
        tst.init(ini);
        tst.remove(0);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testDelPos_0()
    {
        Integer[] ini = {};
        tst.init(ini);
        tst.remove(0);
    }
    @Test
    public void testDelPos_1()
    {
        Integer[] ini = {132};
        tst.init(ini);
        tst.remove(0);
        assertEquals(0, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testDelPos_2()
    {
        Integer[] ini = {132,435};
        tst.init(ini);
        tst.remove(1);
        assertEquals(1, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {132};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testDelPos_many1()
    {
        Integer[] ini = {132,435,57,9,2};
        tst.init(ini);
        tst.remove(2);
        assertEquals(4, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {132,435,9,2};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testDelPos_many2()
    {
        Integer[] ini = {132,435,57,9,2};
        tst.init(ini);
        tst.remove(2);
        assertEquals(4, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {132,435,9,2};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testDelPos_many3()
    {
        Integer[] ini = {132,234,555};
        tst.init(ini);
        tst.remove(0);
        assertEquals(2, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {234,555};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testDelPos_many4()
    {
        Integer[] ini = {10,20,30};
        tst.init(ini);
        tst.remove(2);
        assertEquals(2, tst.size());
        Integer[] actual = tst.getArray(new Integer[tst.size()]);
        Integer[] expected = {10,20};
        assertArrayEquals(expected, actual);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testDelPos_Ex1()
    {
        Integer[] ini = {10,20,30,40,50,60,70};
        tst.init(ini);
        tst.remove(8);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testDelPos_Ex2()
    {
        Integer[] ini = {10,20,30,40,50,60,70};
        tst.init(ini);
        tst.remove(-1);
    }

//    //============================================
//    //              Max
//    //============================================
//    @Test (expected = IllegalArgumentException.class)
//    public void testMax_null()
//    {
//        Integer[] ini = null;
//        tst.init(ini);
//        tst.max();
//    }
//    @Test (expected = IllegalArgumentException.class)
//    public void testMax_0()
//    {
//        Integer[] ini = {};
//        tst.init(ini);
//        tst.max();
//    }
//    @Test
//    public void testMax_1()
//    {
//        Integer[] ini = {12};
//        tst.init(ini);
//        assertEquals(12, tst.max());
//    }
//    @Test
//    public void testMax_2()
//    {
//        Integer[] ini = {324,6};
//        tst.init(ini);
//        assertEquals(324, tst.max());
//    }
//    @Test
//    public void testMax_many()
//    {
//        Integer[] ini = {12,4,5,45,324,6};
//        tst.init(ini);
//        assertEquals(324, tst.max());
//    }

//    //============================================
//    //              Min
//    //============================================
//    @Test (expected = IllegalArgumentException.class)
//    public void testMin_null()
//    {
//        Integer[] ini = null;
//        tst.init(ini);
//        tst.min();
//    }
//    @Test (expected = IllegalArgumentException.class)
//    public void testMin_0()
//    {
//        Integer[] ini = {};
//        tst.init(ini);
//        tst.min();
//    }
//    @Test
//    public void testMin_1()
//    {
//        Integer[] ini = {324};
//        tst.init(ini);
//        assertEquals(324, tst.min());
//    }
//    @Test
//    public void testMin_2()
//    {
//        Integer[] ini = {124,57};
//        tst.init(ini);
//        assertEquals(57, tst.min());
//    }
//    @Test
//    public void testMin_many()
//    {
//        Integer[] ini = {324,6,24,64,124,57};
//        tst.init(ini);
//        assertEquals(6, tst.min());
//    }

//    //============================================
//    //              MaxIndex
//    //============================================
//    @Test (expected = IllegalArgumentException.class)
//    public void testMaxIndex_null()
//    {
//        Integer[] ini = null;
//        tst.init(ini);
//        tst.maxIndex();
//    }
//    @Test (expected = IllegalArgumentException.class)
//    public void testMaxIndex_0()
//    {
//        Integer[] ini = {};
//        tst.init(ini);
//        tst.maxIndex();
//    }
//    @Test
//    public void testMaxIndex_1()
//    {
//        Integer[] ini = {132};
//        tst.init(ini);
//        assertEquals(0, tst.maxIndex());
//    }
//    @Test
//    public void testMaxIndex_2()
//    {
//        Integer[] ini = {10,20};
//        tst.init(ini);
//        assertEquals(1, tst.maxIndex());
//    }
//    @Test
//    public void testMaxIndex_many1()
//    {
//        Integer[] ini = {132,435,57,9,2};
//        tst.init(ini);
//        assertEquals(1, tst.maxIndex());
//    }
//    @Test
//    public void testMaxIndex_many2()
//    {
//        Integer[] ini = {10,20,30,40,50};
//        tst.init(ini);
//        assertEquals(4, tst.maxIndex());
//    }

//    //============================================
//    //              MinIndex
//    //============================================
//    @Test (expected = IllegalArgumentException.class)
//    public void testMinIndex_null()
//    {
//        Integer[] ini = null;
//        tst.init(ini);
//        tst.minIndex();
//    }
//    @Test (expected = IllegalArgumentException.class)
//    public void testMinIndex_0()
//    {
//        Integer[] ini = {};
//        tst.init(ini);
//        tst.minIndex();
//    }
//    @Test
//    public void testMinIndex_1()
//    {
//        Integer[] ini = {132};
//        tst.init(ini);
//        assertEquals(0, tst.minIndex());
//    }
//    @Test
//    public void testMinIndex_2()
//    {
//        Integer[] ini = {132,435};
//        tst.init(ini);
//        assertEquals(0, tst.minIndex());
//    }
//    @Test
//    public void testMinIndex_many1()
//    {
//        Integer[] ini = {132,435,57,9,2};
//        tst.init(ini);
//        assertEquals(4, tst.minIndex());
//    }
//    @Test
//    public void testMinIndex_many2()
//    {
//        Integer[] ini = {10,20,30,40,50};
//        tst.init(ini);
//        assertEquals(0, tst.minIndex());
//    }
//    @Test
//    public void testMinIndex_many3()
//    {
//        Integer[] ini = {50,40,30,20,10};
//        tst.init(ini);
//        assertEquals(4, tst.minIndex());
//    }

//    //============================================
//    //              Sort
//    //============================================
//    @Test (expected = IllegalArgumentException.class)
//    public void testSort_null()
//    {
//        Integer[] ini = null;
//        tst.init(ini);
//        tst.sort();
//    }
//    @Test(expected = IllegalArgumentException.class)
//    public void testSort_0()
//    {
//        Integer[] ini = {};
//        tst.init(ini);
//        tst.sort();
//    }
//    @Test
//    public void testSort_1()
//    {
//        Integer[] ini = {132};
//        tst.init(ini);
//        tst.sort();
//        Integer[] act = tst.getArray(new Integer[tst.size()]();
//        Integer[] exp = {132};
//        assertArrayEquals(exp, act);
//    }
//    @Test
//    public void testSort_2()
//    {
//        Integer[] ini = {10,20};
//        tst.init(ini);
//        tst.sort();
//        Integer[] act = tst.getArray(new Integer[tst.size()]();
//        Integer[] exp = {10,20};
//        assertArrayEquals(exp, act);
//    }
//    @Test
//    public void testSort_many()
//    {
//        Integer[] ini = {132,435,57,9,2};
//        tst.init(ini);
//        tst.sort();
//        Integer[] act = tst.getArray(new Integer[tst.size()]();
//        Integer[] exp = {2, 9, 57, 132, 435};
//        assertArrayEquals(exp, act);
//    }

    //============================================
    //              Reverse
    //============================================
    @Test
    public void testReverse_null()
    {
        Integer[] ini = null;
        tst.init(ini);
        tst.reverse();
    }
    @Test
    public void testReverse_0()
    {
        Integer[] ini = {};
        tst.init(ini);
        tst.reverse();
    }
    @Test
    public void testReverse_1()
    {
        Integer[] ini = {9};
        tst.init(ini);
        tst.reverse();
        Integer[] act = tst.getArray(new Integer[tst.size()]);
        Integer[] exp = {9};
        assertArrayEquals(exp, act);
    }
    @Test
    public void testReverse_2()
    {
        Integer[] ini = {9,2};
        tst.init(ini);
        tst.reverse();
        Integer[] act = tst.getArray(new Integer[tst.size()]);
        Integer[] exp = {2, 9};
        assertArrayEquals(exp, act);
    }
    @Test
    public void testReverse_many()
    {
        Integer[] ini = {132,435,57,9,2};
        tst.init(ini);
        tst.reverse();
        Integer[] act = tst.getArray(new Integer[tst.size()]);
        Integer[] exp = {2, 9 ,57, 435, 132};
        assertArrayEquals(exp, act);
    }

    //============================================
    //              Get
    //============================================
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGet_null()
    {
        Integer[] ini = null;
        tst.init(ini);
        tst.get(0);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGet_0()
    {
        Integer[] ini = {};
        tst.init(ini);
        tst.get(0);
    }
    @Test
    public void testGet_1()
    {
        Integer[] ini = {435};
        tst.init(ini);
        int res = tst.get(0);
        assertEquals(435, res);
    }
    @Test
    public void testGet_many()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        int res = tst.get(3);
        assertEquals(2, res);
    }
    @Test
    public void testGet_many2()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        int res = tst.get(2);
        assertEquals(9, res);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGet_10()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        tst.get(10);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGet_min()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        tst.get(-1);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGet_min2()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        tst.get(-10);
    }

    //============================================
    //              Set
    //============================================
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSet_null()
    {
        Integer[] ini = null;
        tst.init(ini);
        tst.set(0, 200);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSet_0()
    {
        Integer[] ini = {};
        tst.init(ini);
        tst.set(0, 200);
    }
    @Test
    public void testSet_1()
    {
        Integer[] ini = {435};
        tst.init(ini);
        tst.set(0, 200);
        Integer[] act = tst.getArray(new Integer[tst.size()]);
        Integer[] exp = {200};
        assertArrayEquals(exp, act);
    }
    @Test
    public void testSet_2()
    {
        Integer[] ini = {435,57};
        tst.init(ini);
        tst.set(1, 200);
        Integer[] act = tst.getArray(new Integer[tst.size()]);
        Integer[] exp = {435, 200};
        assertArrayEquals(exp, act);
    }
    @Test
    public void testSet_many1()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        tst.set(2, 100);
        Integer[] act = tst.getArray(new Integer[tst.size()]);
        Integer[] exp = {435, 57, 100, 2};
        assertArrayEquals(exp, act);
    }
    @Test
    public void testSet_many2()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        tst.set(1, 200);
        Integer[] act = tst.getArray(new Integer[tst.size()]);
        Integer[] exp = {435, 200, 9, 2};
        assertArrayEquals(exp, act);
    }
    @Test
    public void testSet_many3()
    {
        Integer[] ini = {10,20,30,40,50,60,70};
        tst.init(ini);
        tst.set(6, 80);
        Integer[] act = tst.getArray(new Integer[tst.size()]);
        Integer[] exp = {10,20,30,40,50,60,80};
        assertArrayEquals(exp, act);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSet_Ex10()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        tst.set(10, 999);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSet_Ex0()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        tst.set(-10, 999);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSet_Ex1()
    {
        Integer[] ini = {435,57,9,2};
        tst.init(ini);
        tst.set(-1, 999);
    }
}
