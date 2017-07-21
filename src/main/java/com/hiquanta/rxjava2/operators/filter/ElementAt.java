package com.hiquanta.rxjava2.operators.filter;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class ElementAt {
    public static void main(String[] args) {
      Observable<Integer> observable=  Observable.just(1,2,3,4,5,6).elementAt(2).toObservable();
      observable.subscribe(RxUtils.<Integer>getObserver());
    }
}
