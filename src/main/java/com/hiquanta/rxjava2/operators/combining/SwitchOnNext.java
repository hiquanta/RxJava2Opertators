package com.hiquanta.rxjava2.operators.combining;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/18.
 */
public class SwitchOnNext {
    public static void main(String[] args) {
        // 每隔500毫秒产生一个observable
      Observable<Observable<Long>> observable=  Observable.interval(500, TimeUnit.MILLISECONDS).map(new Function<Long, Observable<Long>>() {
            public Observable<Long> apply(@NonNull Long aLong) throws Exception {
                // 每隔250毫秒产生一组数据（0,10,20,30,40)

                return Observable.interval(250,TimeUnit.MILLISECONDS).map(new Function<Long,Long>() {
                    public Long apply(@NonNull Long l) throws Exception {
                        return  l * 10;
                    }
                }).take(5);
            }
        }).take(2);
//      observable.subscribe(RxUtils.<Observable<Long>>getObserver());
      Observable.switchOnNext(observable).subscribe(RxUtils.<Long>getObserver(Long.valueOf(1)));
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
