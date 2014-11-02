package com.java.iterator.collection;

/**
 * Functor class which is used in MyVector to externalized the computation in
 * doAll() method
 *
 * @author malalanayake
 * @param <T> - Type of the functor
 */
public interface Functor<T,R> {

    public R compute(T data);

    public R getValue();
}
