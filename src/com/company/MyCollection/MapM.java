package com.company.MyCollection;

/**
 * @author Lego on 16.02.2016.
 * @version 1.0
 */
public class MapM<K,E> {

    /** */
    static class Backet<E> {
        E object;
        Backet<E> key;
        Backet<E> value;

        Backet(E e) {
            object = e;
        }
    }
    /**size of array */
    private int size=0;




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
    public E get(int i) {
        if ((i < 0 || i >= size) || (size==0) ) throw new ArrayIndexOutOfBoundsException();
        Link<E> eLink = start.next;
        while (i > 0) {
            eLink = eLink.next;
            i--;
        }
        return eLink.object;
    }



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
    public void sort() {

    }

    /**
     * reverse all object of collection
     */
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
    public int size() {
        return size;
    }

    /**
     * return min value of collection
     */
    public E min() {
        return null;
    }

    /**
     * return max value of collection
     */
    public E max() {
        return null;
    }

    /**
     * @param e
     */
    public void init(E[] e) {
        clear();
        int i =0;
        while (i<e.length) {
            add(e[i]);
            i++;
        }
    }

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
