package com.hiquanta.rxjava2.operators.filter;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Filter {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5).filter(new Predicate<Integer>() {
            public boolean test(@NonNull Integer integer) throws Exception {
                return integer>3;
            }
        }).subscribe(RxUtils.<Integer>getObserver());


    }

}
