package com.hiquanta.rxjava2.operators.create;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Repeat {
    public static void main(String[] args) {
        Observable.range(1, 5).repeat(5).subscribe(RxUtils.getObserver(0));
    }
}
