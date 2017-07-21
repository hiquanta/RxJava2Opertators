package com.hiquanta.rxjava2.operators.transform;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class GroupBy {
    public static void main(String[] args) {
       Observable<GroupedObservable<Long,Long>> observable= Observable.interval(1, TimeUnit.SECONDS).take(10).groupBy(new Function<Long, Long>() {
            public Long apply(@NonNull Long aLong) throws Exception {

                return aLong%3;
            }
        });
        observable.subscribe(new Observer<GroupedObservable<Long, Long>>() {
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe:");
            }

            public void onNext(@NonNull final GroupedObservable<Long, Long> longLongGroupedObservable) {
                longLongGroupedObservable.subscribe(new Consumer<Long>() {
                    public void accept(@NonNull Long aLong) throws Exception {
                        System.out.println("key:" + longLongGroupedObservable.getKey() +", value:" + aLong);
                    }
                });
            }

            public void onError(@NonNull Throwable e) {
                System.out.println("onNext:"+e);
            }

            public void onComplete() {

            }
        });
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
