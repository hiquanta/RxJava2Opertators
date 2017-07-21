package com.hiquanta.rxjava2.operators.connectable;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/20.
 */
public class Replay {
    public static void main(String[] args) {
        Observable<Long> observable=Observable.interval(1, TimeUnit.SECONDS).take(5);
        ConnectableObservable<Long> connectableObservable = observable.publish();
        connectableObservable
             .replay(4,TimeUnit.SECONDS) //缓存4个数据
              .publish();
        connectableObservable.connect();
        connectableObservable
               .delaySubscription(4,TimeUnit.SECONDS)
                .subscribe(RxUtils
                        .<Long>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
