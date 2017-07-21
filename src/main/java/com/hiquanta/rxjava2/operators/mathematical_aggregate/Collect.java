package com.hiquanta.rxjava2.operators.mathematical_aggregate;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hiquanta on 2017/7/20.
 */
public class Collect {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Observable.fromIterable(list).collect(new Callable<ArrayList<Integer>>() {
            public ArrayList<Integer> call() throws Exception {
                return new ArrayList<Integer>();
            }
        }, new BiConsumer<ArrayList<Integer>, Integer>() {
            public void accept(ArrayList<Integer> integers, Integer integer) throws Exception {
                integers.add(integer);
            }
        }).toObservable().subscribe(RxUtils.<ArrayList<Integer>>getObserver());
    }
}
