package com.company.MyCollection;

import com.company.MyCollection.Exeptions.OutEception;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Lego on 16.02.2016.
 * @version 1.0
 */
public class ArrayListM<E> implements AllMethod<E>{

    /**Array of objects */
    private E[] elements;

    /**size of array */
    private int size=0;


    /**
     * create new empty ArrayListM
     */
    public ArrayListM() {
        elements = (E[])new Object[]{};
    }

    /**
     * create new ArrayListM with fixed size
     * @param size
     */
    public ArrayListM(int size) {
        elements = (E[])new Object[size];
    }

    /**
     * add object to the end of collection
     * @param e value
     */
    @Override
    public void add(E e) {
        size++;
        elements = Arrays.copyOf(elements,size);
        elements[size-1] = e;
    }

    /**
     * add object between values by index
     * @param i index
     * @param e value
     */
    public void add(int i, E e){
        size++;
        elements = Arrays.copyOf(elements,size);
        System.arraycopy(elements, i, elements, i + 1,size-1 - i);
        elements[i] = e;
    }

    /**
     * get object from collection by index
     * @param i index
     */
    @Override
    public E get(int i){
        if (i>=size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elements[i];
    }

    /**
     * remove object from collection
     * @param i index
     */
    @Override
    public void remove(int i) {
        elements = Arrays.copyOf(elements,size);
        System.arraycopy(elements, i+1, elements, i,size - i-1);
        size--;
    }

    /**
     * assigns the value of the index
     * @param i index
     * @param e value
     */
    @Override
    public void set(int i, E e) {

        elements[i] = e;
    }

    /**
     * Sort by Ascending or Descending
     */
    @Override
    public void sort() {

    }

    /**
     * reverse all object of collection
     */
    @Override
    public void reverse() {

    }

    /**
     * return size of collection
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * return min value of collection
     */
    @Override
    public E min() {
        return null;
    }

    /**
     * return max value of collection
     */
    @Override
    public E max() {
        return null;
    }

    /** удаляет массив и создаёт новый массив с новыми значениями*/
    @Override
    public void init(E[] e) {
        elements=e;
        size = elements.length;
    }

    public E[] getArray(){
        return elements;
    }
}
