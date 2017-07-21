package com.hiquanta.rxjava2.operators.utils;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class RxUtils {
    public static <T>Observer<T> getObserver(final T observableId){
        return new Observer<T>() {
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("onSubscribe:"+observableId);
                System.out.println("Thread:"+Thread.currentThread());
            }

            public void onNext(@NonNull T t) {
                System.out.println("onNext:"+t);
                System.out.println("Thread:"+Thread.currentThread());
            }

            public void onError(@NonNull Throwable throwable) {
                System.out.println("onError:"+throwable);
                System.out.println("Thread:"+Thread.currentThread());
            }

            public void onComplete() {
                System.out.println("onComplete");
                System.out.println("Thread:"+Thread.currentThread());
            }
        };
    }
    public static <T>Observer<T> getObserver(){
        return new Observer<T>() {
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("onSubscribe");
                System.out.println("Thread:"+Thread.currentThread());
            }

            public void onNext(@NonNull T t) {
                System.out.println("onNext:"+t);
                System.out.println("Thread:"+Thread.currentThread());
            }

            public void onError(@NonNull Throwable throwable) {
                System.out.println("onError:"+throwable);
                System.out.println("Thread:"+Thread.currentThread());
            }

            public void onComplete() {
                System.out.println("onComplete");
                System.out.println("Thread:"+Thread.currentThread());
            }
        };
    }
}
