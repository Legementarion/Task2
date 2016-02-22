package com.company.MyCollection;

import com.company.MyCollection.Exeptions.OutEception;


/**
 * @author Lego on 16.02.2016.
 * @version 1.0
 */
public class LinkedListM<E> implements AllMethod<E> {


    /** */
    static class Link<E> {
        E object;
        Link<E> next;
        Link<E> prev;

        Link(E e) {
            object = e;
        }
    }

    /** */
    Link<E> start = new Link<>(null);

    /** */
    Link<E> end = start;

    /** */
    int size = 0;


    public LinkedListM() {

    }

    /**
     * add object to collection
     *
     * @param e
     */
    @Override
    public void add(E e) {
        end = end.next = new Link<>(e);
        size++;
    }

    /**
     * @param i
     * @param e
     */
    public void add(int i, E e) {
        if (i < 0 || i > size) throw new ArrayIndexOutOfBoundsException();
        Link<E> eLink = start.next;

        if (i == size) {
            add(e);
        } else {
            while (i > 0) {
                eLink = eLink.next;
                i--;
            }
            Link<E> bLink = new Link<>(e);
            size++;

            if ((eLink.prev == null) && (eLink.next != null)) {
                eLink.prev = bLink;
                bLink.next = eLink;
            }  else {
                bLink.next = eLink;
                bLink.prev = eLink.prev;
                eLink.prev = bLink;
                eLink.prev.next = bLink;
            }
        }
    }

    /**
     * get by index object from collection
     *
     * @param i index
     */
    @Override
    public E get(int i) {
        if ((i < 0 || i >= size) || (size==0) ) throw new ArrayIndexOutOfBoundsException();
        Link<E> eLink = start.next;
        while (i > 0) {
            eLink = eLink.next;
            i--;
        }
        return eLink.object;
    }

    /**
     * remove object from collection
     *
     * @param i
     */
    @Override
    public void remove(int i) {
        if (i < 0 || i >= size) throw new ArrayIndexOutOfBoundsException();
        Link<E> eLink = start.next;
        while (i > 0) {
            eLink = eLink.next;
            i--;
        }
        if ((eLink.next == null) && (eLink.prev != null)) {
            eLink.prev.next = null;
        } else if ((eLink.prev == null) && (eLink.next != null)) {
            eLink.next.prev = null;
        } else if ((eLink.prev != null) && (eLink.next != null)) {
            eLink.prev.next = eLink.next;
            eLink.next.prev = eLink.prev;
        }
        eLink = null;
        size--;
    }

    /**
     * assigns the value of the index
     *
     * @param i
     * @param e
     */
    @Override
    public void set(int i, E e) {
        if (i < 0 || i >= size) throw new ArrayIndexOutOfBoundsException();
        Link<E> eLink = start.next;
        while (i > 0) {
            eLink = eLink.next;
            i--;
        }
        eLink.object = e;
    }

    /**
     * Sort Ascending or Descending
     */
    @Override
    public boolean sort(boolean fromMinToMax) {
//        E[] sortedArray = elements;
//
//        if (size() == 0) {
//            return false;
//        }
//        for (int i = size; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                checkForCompare(elements[j], elements[j + 1]);
//                if (((Comparable) sortedArray[j]).compareTo(sortedArray[j + 1]) == 1) {
//                    E tmp = sortedArray[j];
//                    sortedArray[j] = sortedArray[j + 1];
//                    sortedArray[j + 1] = tmp;
//                }
//            }
//        }
//
//        if (!fromMinToMax)
//            reverse();
//
//        elements = sortedArray;
//        System.out.println("Array sorted: \n" + this.toString());
        return true;
    }

    /**
     * reverse all object of collection
     */
    @Override
    public void reverse() {
        int i=0;
        E[] e = (E[])new Object[size];
        Link<E> link = start.next;
        while (i<size) {
            e[i]=link.object;
            link=link.next;
            i++;
        }
        i=size-1;
        clear();
        while (i>=0) {
            add(e[i]);
            i--;
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
     * @param e
     */
    @Override
    public void init(E[] e) {
        clear();
        int i =0;
        while (i<e.length) {
            add(e[i]);
            i++;
        }
    }

    /**
     *
     */
    public void clear() {
        if (size==0) {
            return;
        }
        Link<E> link = start.next;
        start.next=null;
        end=start;
        while (link.next!=null) {
            link=link.next;
            link.prev=null;
        }
        size=0;
    }


    public E[] getArray() {
        E[] temp = (E[]) new Object[size];
        int i = 0;
        Link<E> eLink = start.next;
        while (i < size) {
            temp[i] = get(i);
            i++;
        }
        return temp;
    }


}
