package com.hiquanta.rxjava2.operators.filter;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Distinct {
    public static void main(String[] args) {
        Observable.just(1, 2, 1, 1, 2, 3,3,3,5).distinct().subscribe(RxUtils.<Integer>getObserver());
    }
}
