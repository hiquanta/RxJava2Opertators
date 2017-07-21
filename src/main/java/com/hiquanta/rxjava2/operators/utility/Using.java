package com.hiquanta.rxjava2.operators.utility;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/19.
 */
public class Using {
    public static void main(String[] args) {
        Observable.interval(3, TimeUnit.SECONDS)
                .using(new Callable<Long>() {
                    public Long call() throws Exception {
                        return  Long.valueOf(2);
                    }
                }, new Function<Long, ObservableSource<?>>() {
                    public ObservableSource<?> apply(@NonNull Long aLong) throws Exception {
                        return new ObservableSource<Long>() {
                            public void subscribe(@NonNull Observer<? super Long> observer) {
                                observer.onNext(Long.valueOf(2));
                            }
                        };
                    }
                }, new Consumer<Long>() {
                    public void accept(@NonNull Long aLong) throws Exception {
                                System.out.println(aLong);
                    }
                })
                .subscribe(RxUtils.getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
