package dev.uublabs.rxjava.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 11/28/2017.
 */

public class Just
{
    public static void main(String[] args)
    {
        Observable<String> stringObservable = Observable.just("first","second", "third", "fourth");
        Observer<String> stringObserver = new Observer<String>()
        {
            @Override
            public void onSubscribe(Disposable d)
            {
                System.out.println("onSubscribe" + Thread.currentThread().getName());
            }

            @Override
            public void onNext(String s)
            {
                System.out.println("onNext" + Thread.currentThread().getName());
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e)
            {
                System.out.println("onError" + Thread.currentThread().getName());
            }

            @Override
            public void onComplete()
            {
                System.out.println("onComplete" + Thread.currentThread().getName());
            }
        };

        stringObservable
                .observeOn(Schedulers.newThread())
                .subscribe(stringObserver);
    }
}
