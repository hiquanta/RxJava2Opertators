package com.hiquanta.rxjava2.operators.conditional;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class Amb {
    public static void main(String[] args) {

        List<ObservableSource<Integer>> list= new ArrayList<ObservableSource<Integer>>();
        list.add( Observable.just(1,2,4));
        list.add( Observable.just(4,5,6).delay(3,TimeUnit.SECONDS));
        Observable.amb(list).subscribe(RxUtils.<Integer>getObserver());

    }
}
