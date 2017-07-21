package com.hiquanta.rxjava2.operators.conditional;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class SkipWhile {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS).skipWhile(new Predicate<Long>() {
            public boolean test(@NonNull Long aLong) throws Exception {
                return aLong<6;
            }
        }).subscribe(RxUtils.<Long>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
