package com.hiquanta.rxjava2.operators.filter;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Debounce {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 100; i++) {
                        e.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    e.onComplete();
                }catch(Exception ex){
                    e.onError(ex);
                }
            }
        }).debounce(500, TimeUnit.MILLISECONDS).subscribe(RxUtils.<Integer>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
