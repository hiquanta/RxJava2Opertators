package com.hiquanta.rxjava2.operators.create;


import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Create {
    public static void main(String[] args) {
        /**
         * 创建事件源，也可以说是被观察者
         */
     Observable<Integer> observable=   Observable.create(new ObservableOnSubscribe<Integer>()
        {
            public void subscribe(@NonNull ObservableEmitter<Integer> observableEmitter) throws Exception {

                observableEmitter.onNext(0);
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                observableEmitter.onNext(3);
                observableEmitter.onNext(4);
                observableEmitter.onNext(5);
                observableEmitter.onComplete();
            }
        });
        /**
         * 创建事件接收，也可以说是观察者,且一个时间可以被多个观察者订阅
         */
        Observer<Integer> observer= RxUtils.getObserver(1);
        Observer<Integer> observer2=RxUtils.getObserver(2);
        /**
         * 订阅事件流
         */
        observable.subscribe(observer);
        observable.subscribe(observer2);

    }


}
