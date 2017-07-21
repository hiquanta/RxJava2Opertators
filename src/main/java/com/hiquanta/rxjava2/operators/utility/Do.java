package com.hiquanta.rxjava2.operators.utility;

import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.subscribers.DisposableSubscriber;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/18.
 */
public class Do {
    public static void main(String[] args) {
        //doOnEach
//        Observable.just(1,2,3,4,5).doOnEach(RxUtils.<Integer>getObserver()).subscribe();
        /**
         * onNext:1
         Thread:Thread[main,5,main]
         onNext:2
         Thread:Thread[main,5,main]
         onNext:3
         Thread:Thread[main,5,main]
         onNext:4
         Thread:Thread[main,5,main]
         onNext:5
         Thread:Thread[main,5,main]
         onComplete
         Thread:Thread[main,5,main]
         */
        //doOnNext
//        Observable.just(1,2,3,4,5).doOnNext(new Consumer<Integer>() {
//            public void accept(@NonNull Integer integer) throws Exception {
//                if(integer>3)
//                    throw new RuntimeException("error");
//            }
//        }).subscribe(RxUtils.<Integer>getObserver());
        /**
         * onSubscribe
         Thread:Thread[main,5,main]
         onNext:1
         Thread:Thread[main,5,main]
         onNext:2
         Thread:Thread[main,5,main]
         onNext:3
         Thread:Thread[main,5,main]
         onError:java.lang.RuntimeException: error
         Thread:Thread[main,5,main]
         */
        //doOnSubscribe
//        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6).doOnSubscribe(new Consumer<Disposable>() {
//            public void accept(@NonNull Disposable disposable) throws Exception {
//                System.out.println("published");
//            }
//        });
//        observable.subscribe(RxUtils.<Integer>getObserver());
//        observable.subscribe(RxUtils.<Integer>getObserver());

        /**
         * published
         onSubscribe
         Thread:Thread[main,5,main]
         onNext:1
         Thread:Thread[main,5,main]
         onNext:2
         Thread:Thread[main,5,main]
         onNext:3
         Thread:Thread[main,5,main]
         onNext:4
         Thread:Thread[main,5,main]
         onNext:5
         Thread:Thread[main,5,main]
         onNext:6
         Thread:Thread[main,5,main]
         onComplete
         Thread:Thread[main,5,main]
         published
         onSubscribe
         Thread:Thread[main,5,main]
         onNext:1
         Thread:Thread[main,5,main]
         onNext:2
         Thread:Thread[main,5,main]
         onNext:3
         Thread:Thread[main,5,main]
         onNext:4
         Thread:Thread[main,5,main]
         onNext:5
         Thread:Thread[main,5,main]
         onNext:6
         Thread:Thread[main,5,main]
         onComplete
         Thread:Thread[main,5,main]
         */
        //doOnUnsubscribe 2.0 has removed instead of
        DisposableSubscriber<Long> disposableSubscriber = new DisposableSubscriber<Long>() {
            public void onNext(Long along) {
                System.out.println(along);
            }

            public void onError(Throwable throwable) {
                System.out.println(throwable);
            }

            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        Flowable.interval(1000, TimeUnit.MILLISECONDS).doOnCancel(new Action() {
            public void run() throws Exception {
                System.out.println("doOnCancel");
            }
        }).subscribe(disposableSubscriber);

            disposableSubscriber.dispose();

    }
}
