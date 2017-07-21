package com.hiquanta.rxjava2.operators.utility;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Notification;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/18.
 */
public class Materialize_Dematerialize {
    public static void main(String[] args) {
     Observable.just(1,2,3,4).materialize().subscribe(RxUtils.<Notification<Integer>>getObserver());
     Observable.just(1,2,3,4).materialize().dematerialize().subscribe(RxUtils.getObserver());

    }
}
