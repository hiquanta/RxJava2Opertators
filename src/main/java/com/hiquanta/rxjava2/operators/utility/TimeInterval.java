package com.hiquanta.rxjava2.operators.utility;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Timed;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class TimeInterval {
    public static void main(String[] args) {
        Observable.interval(3, TimeUnit.SECONDS)
                .timeInterval()
                .subscribe(RxUtils.<Timed<Long>>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
