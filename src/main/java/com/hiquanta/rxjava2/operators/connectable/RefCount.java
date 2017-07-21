package com.hiquanta.rxjava2.operators.connectable;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by hiquanta on 2017/7/20.
 */
public class RefCount {
    public static void main(String[] args) {
        Observable<Integer> observable=Observable.just(1,2,3);
        ConnectableObservable<Integer> connectableObservable = observable.publish();
      Observable observable1=  connectableObservable.refCount();
        observable1.subscribe(RxUtils.<Integer>getObserver());
     //   connectableObservable.connect();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
