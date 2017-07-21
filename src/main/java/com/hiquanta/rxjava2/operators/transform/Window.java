package com.hiquanta.rxjava2.operators.transform;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Window {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS).take(12)
                .window(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Observable<Long>>() {
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    public void onNext(@NonNull Observable<Long> longObservable) {
                            longObservable.subscribe(RxUtils.<Long>getObserver());
                    }

                    public void onError(@NonNull Throwable e) {

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
