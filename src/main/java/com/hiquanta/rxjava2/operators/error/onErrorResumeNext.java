package com.hiquanta.rxjava2.operators.error;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by hiquanta on 2017/7/21.
 */
public class onErrorResumeNext {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(3);
                throw new RuntimeException("error");
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
            public ObservableSource<? extends Integer> apply(@NonNull Throwable throwable) throws Exception {
                return Observable.just(5,6,7);
            }
        }).subscribe(RxUtils.<Integer>getObserver());
    }
}
