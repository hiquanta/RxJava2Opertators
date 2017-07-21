package com.hiquanta.rxjava2.operators.combining;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;

/**
 * Created by hiquanta on 2017/7/18.
 */
public class Zip {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(10,20,30);
        Observable<Integer> observable2 = Observable.just(4, 8, 12, 16);
        Observable.zip(observable1, observable2, new BiFunction<Integer, Integer, Integer>() {
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                return integer+integer2;
            }
        }).subscribe(RxUtils.<Integer>getObserver());
    }
}
