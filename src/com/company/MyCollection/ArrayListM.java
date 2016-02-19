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
        if (i<0 || i>size) throw new ArrayIndexOutOfBoundsException();
        if (i == size) {
            add(e);
        }
        else {
        size++;
        elements = Arrays.copyOf(elements,size);
        System.arraycopy(elements, i, elements, i + 1,size-1 - i);
        elements[i] = e;
        }
    }

    /**
     * get object from collection by index
     * @param i index
     */
    @Override
    public E get(int i){
        if (i>=size|| i<0) {
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
        if (i>=size || i<0) {
            throw new ArrayIndexOutOfBoundsException();
        }
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
        if (i>=size || i<0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elements[i] = e;
    }

    /**
     * Sort by Ascending or Descending
     */
    @Override
    public void sort() {
        int start = 0;
        int end = size - 1;
        dosort(start,end);
    }


    public void dosort(int start, int end){
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (elements[i] == elements[cur])) {
                i++;
            }
            while (j > cur && (elements[cur].hashCode() <= elements[j].hashCode())) {
                j--;
            }
            if (i < j) {
                E temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        dosort(start, cur);
        dosort(cur+1, end);
    }

    /**
     * reverse all object of collection
     */
    @Override
    public void reverse() {
        if (size <= 1) {
            return;
        }
        E temp;
        for (int i = 0; i< size/2; i++){
                temp = elements[i];
                elements[i] = elements[size - 1 - i];
                elements[size - 1 - i] = temp;
        }
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

    /**
     * Assign an array to current ArrayList
     */
    @Override
    public void init(E[] e) {
        if(e == null){
            elements=e;
            size = 0;
        } else {
            elements = e;
            size = elements.length;
        }
    }

    /**
     * delete all elements from array
     */
    public void clear() {
        if (size==0) {
            return;
        }
        int i = 0;
        while (i < size) {
            remove(i);
            i++;
        }
        size=0;
    }

    /**
     * return original array from ArrayList
     */
    public E[] getArray(){
        return elements;
    }
}
