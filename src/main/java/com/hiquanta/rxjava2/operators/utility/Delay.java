package com.hiquanta.rxjava2.operators.utility;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/18.
 */
public class Delay {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4).delay(5, TimeUnit.SECONDS).subscribe(RxUtils.<Integer>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
