package com.hiquanta.rxjava2.operators.combining;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Join {
    public static void main(String[] args) {
        //产生0,5,10,15,20数列
        Observable<Long> observable1 = Observable.interval(500,TimeUnit.MILLISECONDS)
               // .delay(600,TimeUnit.MILLISECONDS)
                .map(new Function<Long, Long>() {
            public Long apply(@NonNull Long aLong) throws Exception {
                return  aLong*5;
            }
        });
        // 产生0,10,20,30,40数列
        Observable<Long> observable2=Observable.interval(500,TimeUnit.MILLISECONDS)
            // .delay(1000,TimeUnit.MILLISECONDS)
                .map(new Function<Long, Long>() {
            public Long apply(@NonNull Long aLong) throws Exception {
                return aLong*10;
            }
        });
//        observable2.subscribe(RxUtils.<Long>getObserver());
        observable1.join(observable2, new Function<Long, ObservableSource<String>>() {
            public ObservableSource<String> apply(@NonNull Long aLong) throws Exception {
                return Observable.just(String.valueOf(aLong)).delay(600, TimeUnit.MILLISECONDS);
            }
        }, new Function<Long, ObservableSource<String>>() {
            public ObservableSource<String> apply(@NonNull Long aLong) throws Exception {
                return Observable.just(String.valueOf(aLong));
            }
        }, new BiFunction<Long, Long, String>() {
            public String apply(@NonNull Long aLong, @NonNull Long aLong2) throws Exception {
                return aLong + ":" + aLong2;
            }
        })
                .subscribe(RxUtils.<String>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
