package com.hiquanta.rxjava2.operators.mathematical_aggregate;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/20.
 */
public class Concat {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4);
        Observable<Integer> observable2 = Observable.just(5, 6, 7, 8);
        Observable.concat(observable1,observable2).subscribe(RxUtils.<Integer>getObserver());
    }
}
