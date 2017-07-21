package com.hiquanta.rxjava2.operators.transform;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Map {
    public static void main(String[] args) {
        Observable.just("大","小").map(new Function<String, String>() {
            public String apply(@NonNull String s) throws Exception {
                return s+"sb";
            }
        }).subscribe(RxUtils.getObserver("0"));
    }
}
