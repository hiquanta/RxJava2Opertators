package com.hiquanta.rxjava2.operators.conditional;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class All {
    public static void main(String[] args) {
        Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                        e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onNext(5);
            }
        });
        observable.all(new Predicate<Integer>() {
            public boolean test(@NonNull Integer integer) throws Exception {
                return integer>4;
            }
        })
                .toObservable().subscribe(RxUtils.<Boolean>getObserver());
        observable.subscribe(RxUtils.<Integer>getObserver());
    }
}
