package com.hiquanta.rxjava2.operators.mathematical_aggregate;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;

/**
 * Created by hiquanta on 2017/7/20.
 */
public class Reduce {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5).reduce(new BiFunction<Integer, Integer, Integer>() {
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                return integer + integer2;
            }
        }).toObservable().subscribe(RxUtils.<Integer>getObserver());
    }
}
