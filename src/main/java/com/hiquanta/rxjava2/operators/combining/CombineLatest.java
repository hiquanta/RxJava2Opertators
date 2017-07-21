package com.hiquanta.rxjava2.operators.combining;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function3;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class CombineLatest {
    public static void main(String[] args) {
        Observable<Integer> o1 = Observable.just(1, 2, 3);
        Observable<Integer> o2 = Observable.just(4, 5, 6);
        Observable<Integer> o3 = Observable.just(7, 8, 9);

        Observable.combineLatest(o1, o2, o3, new Function3<Integer, Integer, Integer, Integer>() {
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2, @NonNull Integer integer3) throws Exception {
                return integer + integer2 + integer3;
            }
        }).subscribe(RxUtils.<Integer>getObserver());
    }
}
