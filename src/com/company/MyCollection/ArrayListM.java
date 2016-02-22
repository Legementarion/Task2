package com.company.MyCollection;

import com.company.MyCollection.Exeptions.OutEception;

import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Lego on 16.02.2016.
 * @version 1.0
 */
public class ArrayListM<E> implements AllMethod<E> {

    /**
     * Array of objects
     */
    private Object[] elements;

    /**
     * size of array
     */
    private int size = 0;


    /**
     * create new empty ArrayListM
     */
    public ArrayListM() {
        elements = (E[]) new Object[]{};
    }

    /**
     * create new ArrayListM with fixed size
     *
     * @param size
     */
    public ArrayListM(int size) {
        elements = (E[]) new Object[size];
    }

    /**
     * add object to the end of collection
     *
     * @param e value
     */
    @Override
    public void add(E e) {
        size++;
        elements = Arrays.copyOf(elements, size);
        elements[size - 1] = e;
    }

    /**
     * add object between values by index
     *
     * @param i index
     * @param e value
     */
    public void add(int i, E e) {
        if (i < 0 || i > size) throw new ArrayIndexOutOfBoundsException();
        if (i == size) {
            add(e);
        } else {
            size++;
            elements = Arrays.copyOf(elements, size);
            System.arraycopy(elements, i, elements, i + 1, size - 1 - i);
            elements[i] = e;
        }
    }

    /**
     * get object from collection by index
     *
     * @param i index
     */
    @Override
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) elements[i];
    }

    /**
     * remove object from collection
     *
     * @param i index
     */
    @Override
    public void remove(int i) {
        if (i > size || i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elements = Arrays.copyOf(elements, size);
        System.arraycopy(elements, i + 1, elements, i, size - i - 1);
        size--;
    }

    /**
     * assigns the value of the index
     *
     * @param i index
     * @param e value
     */
    @Override
    public void set(int i, E e) {
        if (i >= size || i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elements[i] = e;
    }

    /**
     * Sort by Ascending or Descending
     */
    @Override
    public boolean sort(boolean fromMinToMax) {
        E[] sortedArray = (E[]) elements;

        if (size() == 0) {
            return false;
        }
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                checkForCompare((E) elements[j], (E) elements[j + 1]);
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
        System.out.println("Array sorted: \n" + this.toString());
        return true;
    }

    /**
     * method to compare two values
     */
    private boolean checkForCompare(E el1, E el2) {
        if (el1 == null || el2 == null)
            throw new ClassCastException("Can't compare elements. Values contains nulls");
        else if (!el1.getClass().equals(el2.getClass()))
            throw new ClassCastException("Can't compare elements with different classes");
        else if (!(el1 instanceof Comparable) || !(el2 instanceof Comparable))
            throw new ClassCastException("Can't compare elements. No criteria for compare");

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
        for (int i = 0; i < size / 2; i++) {
            temp = (E) elements[i];
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
        if (e == null) {
            elements = new Object[]{};
            ;
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
        if (size == 0) {
            return;
        }
        int i = 0;
        while (i < size) {
            remove(i);
            i++;
        }
        size = 0;
    }

    /**
     * return original array from ArrayList
     */
    public E[] getArray() {

        int i = 0;
        E[] buf = (E[]) new Object[size];
        while (i < size()) {
            buf[i] = (E) elements[i];
            i++;
        }

        return buf;
    }

    public <T> T[] getArray(T[] t) {
        if (t.length < size)
            return (T[]) Arrays.copyOf(elements, size, t.getClass());
        System.arraycopy(elements, 0, t, 0, size);
        if (t.length > size)
            t[size] = null;
        return t;
    }
}
