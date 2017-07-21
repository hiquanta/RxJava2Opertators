package com.hiquanta.rxjava2.operators.connectable;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/20.
 */
public class Connect {
    public static void main(String[] args) {
        Observable<Long> observable=Observable.interval(1, TimeUnit.SECONDS);
        ConnectableObservable<Long> connectableObservable = observable.publish();
        connectableObservable.connect();
        connectableObservable
                .delaySubscription(3,TimeUnit.SECONDS)
                .subscribe(RxUtils.<Long>getObserver());

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
