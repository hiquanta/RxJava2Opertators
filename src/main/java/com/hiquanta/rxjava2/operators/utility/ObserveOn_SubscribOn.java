package com.hiquanta.rxjava2.operators.utility;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class ObserveOn_SubscribOn {
    public static void main(String[] args) {

      //  Observable.just(1,2,3,4,5).observeOn( Schedulers.newThread()).subscribeOn(Schedulers.computation()).subscribe(RxUtils.<Integer>getObserver());
        Observable.just(1,2,3,4,5).subscribeOn( Schedulers.newThread()).subscribeOn(Schedulers.computation()).subscribe(RxUtils.<Integer>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
