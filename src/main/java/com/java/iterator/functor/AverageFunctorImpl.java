package com.java.iterator.functor;

import com.java.iterator.collection.Functor;

/**
 *
 * @author malalanayake
 */
public class AverageFunctorImpl implements Functor<Integer, Float> {

    Float sum = 0f;
    Integer elemtCount = 0;

    @Override
    public Float compute(Integer data) {
        sum = sum + data;
        elemtCount = elemtCount + 1;
        return sum;
    }

    @Override
    public Float getValue() {
        return sum / elemtCount;
    }

}
