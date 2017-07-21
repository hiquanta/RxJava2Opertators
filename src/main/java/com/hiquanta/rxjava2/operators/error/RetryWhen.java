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
public class RetryWhen {
    public static void main(String[] args) {
       Observable.create(new ObservableOnSubscribe<Integer>() {
        public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
            try {
                for (int i = 0; i < 10; i++) {
                    if (i == 4) {
                        throw new Exception(
                                "this is number 4 error！");
                    }
                    e.onNext(i);
                }
                e.onComplete();
            } catch (Throwable ex) {
                e.onError(ex);
            }
        }
    }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
           public ObservableSource<?> apply(@NonNull Observable<Throwable> throwableObservable) throws Exception {
               return Observable.just(12,13);
           }
       }).subscribe(RxUtils.<Integer>getObserver());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
