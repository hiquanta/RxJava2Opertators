package com.hiquanta.rxjava2.operators.transform;

import com.hiquanta.rxjava2.operators.utils.RxUtils;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiquanta on 2017/7/17.
 */
public class Buffer {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        Observable.range(1,5).buffer(2).subscribe(RxUtils.getObserver(list));
    }
}
