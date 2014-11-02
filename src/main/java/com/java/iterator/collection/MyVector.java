package com.java.iterator.collection;

import java.util.Iterator;
import java.util.Vector;

/**
 * MyVector is collection which can holds any type
 *
 * @author malalanayake
 * @param <T> - Type of the MyVector
 */
public class MyVector<T> extends Vector<T> {

    private Predicate<T> predicate;

    public MyVector() {
        predicate = null;
    }

    public Iterator<T> selectiveIterator(Predicate<T> predicate) {
        return new IteratorSelective<T>(this, predicate);
    }

    public <R> void doAll(Functor<T, R> functor) {
        Iterator ite = this.iterator();
        while (ite.hasNext()) {
            T t = (T) ite.next();
            functor.compute(t);
        }
    }

    public <R> void doAll(Functor<T, R> functor, Predicate<T> predicate) {
        IteratorSelective<T> iteratorSelective = new IteratorSelective<T>(this, predicate);
        while (iteratorSelective.hasNext()) {
            T t = iteratorSelective.next();
            functor.compute(t);
        }
    }

    public Predicate<T> getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    /**
     * This method is going to use in the for each
     *
     * @return
     */
    @Override
    public synchronized Iterator<T> iterator() {
        return this.selectiveIterator(predicate);
    }

    /**
     * Inner class which is provides the selective iterator
     *
     * @param <T> - Type of the iterator
     */
    public class IteratorSelective<T> implements Iterator<T> {

        private MyVector<T> myVector;
        private int currentIndex = 0;
        Predicate<T> predicate;

        IteratorSelective(MyVector myVector, Predicate<T> predicate) {
            this.myVector = myVector;
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext() {
            while (myVector.size() > currentIndex) {
                //predicate is null then work for all
                if (predicate != null) {
                    if (predicate.isValid(myVector.get(currentIndex))) {
                        currentIndex++;
                        return true;
                    } else {
                        currentIndex++;
                    }
                } else {
                    currentIndex++;
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {
            T next = myVector.get(currentIndex - 1);
            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
