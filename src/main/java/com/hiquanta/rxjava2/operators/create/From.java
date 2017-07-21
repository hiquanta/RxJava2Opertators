package com.hiquanta.rxjava2.operators.create;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class From {
    public static void main(String[] args) {
        Integer[] items = { 0, 1, 2, 3, 4, 5 };
        Observable fromObservable = Observable.fromArray(items);
        fromObservable.subscribe(RxUtils.getObserver(0));

    }
}
