package com.hiquanta.rxjava2.operators.create;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Timer {
    public static void main(String[] args) {
        Observable.timer(4, TimeUnit.SECONDS).subscribe(RxUtils.getObserver(Long.valueOf(0)));
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
