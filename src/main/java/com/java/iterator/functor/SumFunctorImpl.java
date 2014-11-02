package com.java.iterator.functor;

import com.java.iterator.collection.Functor;

/**
 *
 * @author DMalalanayake
 */
public class SumFunctorImpl implements Functor<Integer, Float> {

    Float sum = 0f;

    @Override
    public Float compute(Integer data) {
        sum = sum + data;
        return sum;
    }

    @Override
    public Float getValue() {
        return sum;
    }
}
