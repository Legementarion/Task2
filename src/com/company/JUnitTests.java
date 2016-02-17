package com.company;

import com.company.MyCollection.ArrayListM;
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

    @Before
    public void b(){
        al = new ArrayListM<>();
    }

    @Test
    public void test1(){
        al.add(1);
        int act = 1;
        int exp = al.size();
        assertEquals(act, exp);
    }



}
