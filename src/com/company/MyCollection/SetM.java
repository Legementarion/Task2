package com.company.MyCollection;

import java.util.Arrays;

/**
 * @author Lego on 16.02.2016.
 * @version 1.0
 */
public class SetM<E> implements AllMethod<E> {

    /**Array of objects */
    private E[] elements;

    /**size of array */
    private int size=0;


    /**
     * create new empty ArrayListM
     */
    public SetM() {
        elements = (E[])new Object[]{};
    }

    /**
     * create new ArrayListM with fixed size
     * @param size
     */
    public SetM(int size) {
        elements = (E[])new Object[size];
    }

    /**
     * add object to the end of collection
     * @param e value
     */
    @Override
    public void add(E e) {
        for (E each: elements){
            if (each.equals(e)){
                return;
            }
        }
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
        for (E each: elements){
            if (each.equals(e)){
                return;
            }
        }
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

    public void remove(E e) {
        for (int i = 0; i < size; i ++){
            if (elements[i].equals(e)){
                elements = Arrays.copyOf(elements,size);
                System.arraycopy(elements, i+1, elements, i,size - i-1);
                size--;
            }
        }

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
        for (E each: elements){
            if (each.equals(e)){
                return;
            }
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
            for (E each: e){
                if (!each.equals(e)){
                    add(each);
                }
            }
        }
        size = elements.length;
    }

    /**
     * return original array from ArrayList
     */
    public E[] getArray(){
        return elements;
    }
}
