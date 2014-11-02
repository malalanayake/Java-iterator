package com.java.iterator.util;

import com.java.iterator.collection.Functor;
import java.util.Iterator;

/**
 * Util class is used to externalizing the do all method
 *
 * @author malalanayake
 * @param <T> - type of Util class
 */
public class Util<T> {

    public <R> void doAll(Functor<T, R> functor, Iterator<T> ite) {
        while (ite.hasNext()) {
            T t = (T) ite.next();
            functor.compute(t);
        }
    }
}
