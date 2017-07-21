package com.hiquanta.rxjava2.operators.combining;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/18.
 */
public class StartWith {
    public static void main(String[] args) {
     Observable.just(10, 20, 30).startWith(2).subscribe(RxUtils.<Integer>getObserver());
    }
}
