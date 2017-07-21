package com.hiquanta.rxjava2.operators.conditional;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class Contains {
    public static void main(String[] args) {
       Observable<Integer> observable= Observable.just(1,2,3,4);
        Single<Boolean> bollean= observable.contains(6);
        System.out.println(bollean.blockingGet());
    }
}
