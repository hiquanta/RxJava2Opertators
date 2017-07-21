package com.hiquanta.rxjava2.operators.mathematical_aggregate;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/20.
 */
public class Count {
    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .count().toObservable()
                .subscribe(RxUtils.<Long>getObserver());
    }
}
