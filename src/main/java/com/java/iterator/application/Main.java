package com.java.iterator.application;

import com.java.iterator.collection.Functor;
import com.java.iterator.collection.MyVector;
import com.java.iterator.collection.Predicate;
import com.java.iterator.functor.AverageFunctorImpl;
import com.java.iterator.functor.SumFunctorImpl;
import com.java.iterator.predicate.PredicateImpl;
import com.java.iterator.util.Util;

/**
 *
 * @author malalanayake
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        MyVector<Integer> myVector = new MyVector<Integer>();
        for (int i = 1; i <= 10; i++) {
            myVector.add(i);
        }

        main.internalSumFunctor(myVector);
        main.externalSumFunctor(myVector);
        main.internalAverageFunctor(myVector);
        main.externalAverageFunctor(myVector);
        main.internalSelectiveSumFunctor(myVector);
        main.internalSelectiveAverageFunctor(myVector);
        main.externalSelectiveSumFunctor(myVector);
        main.externalSelectiveAverageFunctor(myVector);
        main.selectiveIterable(myVector);
    }

    public void internalSumFunctor(MyVector<Integer> myVector) {
        Functor<Integer,Float> sumFunctor = new SumFunctorImpl();
        myVector.doAll(sumFunctor);
        System.out.println("Internal SumFunctor:" + sumFunctor.getValue());
    }

    public void externalSumFunctor(MyVector<Integer> myVector) {
        Util<Integer> util = new Util<>();
        Functor<Integer,Float> sumFunctor = new SumFunctorImpl();
        util.doAll(sumFunctor, myVector.iterator());
        System.out.println("External SumFunctor:" + sumFunctor.getValue());
    }

    public void internalAverageFunctor(MyVector<Integer> myVector) {
        Functor<Integer,Float> avarageFunctor = new AverageFunctorImpl();
        myVector.doAll(avarageFunctor);
        System.out.println("Internal AverageFunctor:" + avarageFunctor.getValue());
    }

    public void externalAverageFunctor(MyVector<Integer> myVector) {
        Util<Integer> util = new Util<>();
        Functor<Integer,Float> avarageFunctor = new AverageFunctorImpl();
        util.doAll(avarageFunctor, myVector.iterator());
        System.out.println("External AverageFunctor:" + avarageFunctor.getValue());
    }

    public void internalSelectiveSumFunctor(MyVector<Integer> myVector) {
        Functor<Integer,Float> sumFunctor = new SumFunctorImpl();
        Predicate<Integer> predicate = new PredicateImpl();
        myVector.doAll(sumFunctor, predicate);
        System.out.println("Internal Selective X>2 SumFunctor:" + sumFunctor.getValue());
    }

    public void internalSelectiveAverageFunctor(MyVector<Integer> myVector) {
        Functor<Integer,Float> functor = new AverageFunctorImpl();
        Predicate<Integer> predicate = new PredicateImpl();
        myVector.doAll(functor, predicate);
        System.out.println("Internal Selective X>2 AverageFunctor:" + functor.getValue());
    }

    public void externalSelectiveSumFunctor(MyVector<Integer> myVector) {
        Util<Integer> util = new Util<>();
        Functor<Integer,Float> functor = new SumFunctorImpl();
        Predicate<Integer> predicate = new PredicateImpl();
        util.doAll(functor, myVector.selectiveIterator(predicate));
        System.out.println("External Selective X>2 SumFunctor:" + functor.getValue());
    }

    public void externalSelectiveAverageFunctor(MyVector<Integer> myVector) {
        Util<Integer> util = new Util<>();
        Functor<Integer,Float> functor = new AverageFunctorImpl();
        Predicate<Integer> predicate = new PredicateImpl();
        util.doAll(functor, myVector.selectiveIterator(predicate));
        System.out.println("External Selective X>2 AverageFunctor:" + functor.getValue());
    }
    
    public void selectiveIterable(MyVector<Integer> myVector) {
        Predicate<Integer> predicate = new PredicateImpl();
        System.out.println("Selective Iterable X>2");
        for(Integer i:myVector.filter(predicate)){
            System.out.print(" " + i);
        }
    }
}
