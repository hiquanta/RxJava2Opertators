package com.hiquanta.rxjava2.operators.conditional;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class TakeUntil {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS).takeUntil(Observable.timer(10,TimeUnit.SECONDS))
                .subscribe(RxUtils.<Long>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
