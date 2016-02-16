package com.company.javadockExemple;

/**
 * class with pow func.
 * @author lego
 * @date 16.02.16.
 * @version 0.1
 */
public class Test {

    /**
     * this value will be raised to the power
     */
    int a;

    /**
     * value for print a
     */
    int b;

    /**
     *  method for pow our value
     * @param a input value
     * @return b with result of pow
     */
    public int pow(int a){
        b= a*a;
        return b;
    }

    /**
     * method for print result
     */
    public void print(){
        System.out.println(a + " - a; " + b+" -b;");
    }

}
