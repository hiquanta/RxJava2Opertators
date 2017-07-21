package com.hiquanta.rxjava2.operators.conditional;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class SkipUntil {
    public static void main(String[] args) {
//        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5);
//        Observable observable2 = Observable.timer(3, TimeUnit.SECONDS);
//        observable1.skipUntil(observable2).subscribe(RxUtils.<Integer>getObserver());
//        observable2.subscribe(RxUtils.getObserver());
        Observable.interval(1, TimeUnit.SECONDS).skipUntil(Observable.timer(5,TimeUnit.SECONDS)).subscribe(RxUtils.<Long>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
