package com.company.MyCollection;

import com.company.MyCollection.Exeptions.OutEception;

/**
 * interface of all executable method
 * @author Lego on 16.02.2016.
 * @version 1.0
 */
public interface AllMethod<E> {

    /** add object to collection*/
    public void add(E e);

    /** get object from collection*/
    public E get(int i);

    /** remove object from collection*/
    public void remove(int i);

    /** assigns the value of the index*/
    public void set(int i, E e);

    /**Sort Ascending or Descending */
    public boolean sort(boolean fromMinToMax);

    /**reverse all object of collection */
    public void reverse();

    /**return size of collection */
    public int size();

    /**return min value of collection */
    public E min();

    /**return max value of collection */
    public E max();

    /** */
    public void init(E[] e);
}
