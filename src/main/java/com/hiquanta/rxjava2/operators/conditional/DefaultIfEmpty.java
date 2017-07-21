package com.hiquanta.rxjava2.operators.conditional;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class DefaultIfEmpty {
    public static void main(String[] args) {

        Observable.empty().defaultIfEmpty(0).subscribe(RxUtils.getObserver());
    }
}
