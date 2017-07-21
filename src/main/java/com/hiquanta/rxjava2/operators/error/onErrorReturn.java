package com.hiquanta.rxjava2.operators.error;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by hiquanta on 2017/7/21.
 */
public class onErrorReturn {
    public static void main(String[] args) {
        // onErrorReturn
        Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                    e.onNext(1);

                    throw new RuntimeException("error");

            }
        }).onErrorReturn(new Function<Throwable, Integer>() {
            public Integer apply(@NonNull Throwable throwable) throws Exception {
                return 5;
            }
        }).subscribe(RxUtils.<Integer>getObserver());
    }
}
