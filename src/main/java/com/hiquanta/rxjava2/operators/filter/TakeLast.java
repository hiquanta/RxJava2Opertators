package com.hiquanta.rxjava2.operators.filter;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class TakeLast {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5,6,7,8).takeLast(3).subscribe(RxUtils.<Integer>getObserver());
    }
}
