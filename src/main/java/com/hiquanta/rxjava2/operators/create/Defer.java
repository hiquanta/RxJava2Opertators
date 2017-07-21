package com.hiquanta.rxjava2.operators.create;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.util.concurrent.Callable;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Defer {
    static int i;
    public static void main(String[] args) {
        i = 10;
        Observable<Integer> justObservable = Observable.just(i);
        i = 12;
        Observable<Integer> deferObservable=Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(i);
            }
        });
        i=15;
        justObservable.subscribe(RxUtils.getObserver(1));
        deferObservable.subscribe(RxUtils.getObserver(2));
    }
}
