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
     * create new empty Array
     */
    public SetM() {
        elements = (E[])new Object[]{};
    }

    /**
     * create new Array with fixed size
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
        if(size!=0) {
            for (E each : elements) {
                if (each.equals(e)) {
                    return;
                }
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
     * remove object from collection by index
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
     * remove object from collection by value
     * @param e value
     */
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
     * assigns the value by the index
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
    public boolean sort(boolean fromMinToMax) {
        E[] sortedArray = elements;

        if (size() == 0) {
            return false;
        }
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                checkForCompare(elements[j], elements[j + 1]);
                if (((Comparable) sortedArray[j]).compareTo(sortedArray[j + 1]) == 1) {
                    E tmp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = tmp;
                }
            }
        }

        if (!fromMinToMax)
            reverse();
        elements = sortedArray;
        return true;
    }

    /**
     * method to compare two values with unknown type
     */
    private boolean checkForCompare(E e1, E e2) {
        if (e1 == null || e2 == null)
            throw new ClassCastException("Values contains nulls!!!");
        else if (!e1.getClass().equals(e2.getClass()))
            throw new ClassCastException("Elements with different classes!");
        else if (!(e1 instanceof Comparable) || !(e2 instanceof Comparable))
            throw new ClassCastException("No criteria to compare");
        return true;
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
        E min = elements[0];
        for (int i = 1; i < size() ; i++) {
            checkForCompare(min, elements[i]);
            if (((Comparable) min).compareTo(elements[i]) == 1)
                min = elements[i];
        }
        return min;
    }

    /**
     * return max value of collection
     */
    @Override
    public E max() {
        E max = elements[0];
        for (int i = 1; i < size() ; i++) {
            checkForCompare(max, elements[i]);
            if (((Comparable) max).compareTo(elements[i]) == -1)
                max = elements[i];
        }
        return max;
    }

    /**
     * Assign an array to current Set
     */
    @Override
    public void init(E[] e) {
        if(e == null){
            elements=e;
            size = 0;
        } else {
            elements = (E[])new Object[]{};
            size = 0;
            for (E each: e){
                if (!each.equals(e)){
                    add(each);
                }
            }
        }
        size = elements.length;
    }

    /**
     * return original array from Set
     */
    public E[] getArray(){
        return elements;
    }
}
