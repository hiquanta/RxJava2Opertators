package com.hiquanta.rxjava2.operators.conditional;

import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class SequenceEqual {
    public static void main(String[] args) {
      Observable<Integer> observable=  Observable.just(1,2,3);
      Observable<Integer> observable2=Observable.just(1,2,3);
      Observable<Integer> observable3=Observable.just(4,6,7);
      System.out.println(Observable.sequenceEqual(observable,observable2).blockingGet());
      System.out.println(Observable.sequenceEqual(observable,observable3).blockingGet());



    }
}
