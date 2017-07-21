package com.hiquanta.rxjava2.operators.create;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class RepeatWhen {
    public static void main(String[] args) {
        Observable.range(1, 5).repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
            public ObservableSource<?> apply(@NonNull Observable<Object> objectObservable) throws Exception {
                //延时六秒发送数据
                return objectObservable.delay(6, TimeUnit.SECONDS);
            }
        }).subscribe(RxUtils.getObserver(0));
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
