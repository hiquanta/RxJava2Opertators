package com.hiquanta.rxjava2.operators.create;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Range {
    public static void main(String[] args) {
        Observable.range(3, 10).subscribe(RxUtils.getObserver(0));

    }
}
