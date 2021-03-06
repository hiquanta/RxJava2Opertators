package com.hiquanta.rxjava2.operators.create;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Interval {
    public static void main(String[] args) {
        Observable observable= Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(RxUtils.getObserver(0));
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
