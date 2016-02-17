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
            object=e;
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
     * @param e
     */
    @Override
    public void add(E e) {
        end = end.next = new Link<>(e);
        size++;
    }

    /**
     *
     * @param i
     * @param e
     */
    public void add(int i, E e){
        if (i<0 || i>=size) throw new ArrayIndexOutOfBoundsException();
        Link<E> eLink = start.next;
        while (i > 0) {
            eLink = eLink.next;
            i--;
        }
        Link<E> bLink = new Link<>(e);
        eLink.prev.next = bLink;
        bLink.prev = eLink.prev;
        bLink.next = eLink;
        eLink.prev = bLink;

    }

    /**
     * get by index object from collection
     * @param i index
     */
    @Override
    public E get(int i) {
        if (i<0 || i>=size) throw new ArrayIndexOutOfBoundsException();
        Link<E> eLink = start.next;
        while (i > 0) {
            eLink = eLink.next;
            i--;
        }
        return eLink.object;
    }

    /**
     * remove object from collection
     * @param i
     */
    @Override
    public void remove(int i) {
        if (i<0 || i>=size) throw new ArrayIndexOutOfBoundsException();
        Link<E> eLink = start.next;
        while (i > 0) {
            eLink = eLink.next;
            i--;
        }
        eLink.next.prev=eLink.prev;
        eLink.prev.next=eLink.next;
        eLink=null;
        size--;
    }

    /**
     * assigns the value of the index
     * @param i
     * @param e
     */
    @Override
    public void set(int i, E e) {
        if (i<0 || i>=size) throw new ArrayIndexOutOfBoundsException();
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

    /**
     *
     * @param e
     */
    @Override
    public void init(E[] e) {

    }





}
