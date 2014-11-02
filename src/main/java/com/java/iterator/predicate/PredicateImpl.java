package com.java.iterator.predicate;

import com.java.iterator.collection.Predicate;

/**
 *
 * @author malalanayake
 */
public class PredicateImpl implements Predicate<Integer> {

    @Override
    public boolean isValid(Integer element) {
        if (element > 2) {
            return true;
        }
        return false;
    }

}
