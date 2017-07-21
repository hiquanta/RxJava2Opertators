package com.hiquanta.rxjava2.operators.transform;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Scan {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5).scan(new BiFunction<Integer, Integer, Integer>() {
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                return integer+integer2;
            }
        }).subscribe(RxUtils.<Integer>getObserver());
    }
}
