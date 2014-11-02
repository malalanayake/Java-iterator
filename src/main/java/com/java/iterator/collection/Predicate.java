package com.java.iterator.collection;

/**
 * Predicate which is used in MyVector class to externalized the selection logic
 * in IteratorSelective
 *
 * @author malalanayake
 * @param <T> - Type of Predicate
 */
public interface Predicate<T> {

    public boolean isValid(T element);
}
