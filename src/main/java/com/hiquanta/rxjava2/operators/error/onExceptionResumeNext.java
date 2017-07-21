package com.hiquanta.rxjava2.operators.error;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by hiquanta on 2017/7/21.
 */
public class onExceptionResumeNext {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(3);
                throw new RuntimeException("error");
            }
        }).onExceptionResumeNext(Observable.just(5,6,7)).subscribe(RxUtils.<Integer>getObserver());
    }
}
