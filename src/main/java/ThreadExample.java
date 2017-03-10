import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by dale on 3/10/2017.
 */
public class ThreadExample {
    public static void main(String[] a) {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("Observable operation on: " + Thread.currentThread().getName());
                subscriber.onNext("hi");
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber operation on: " + Thread.currentThread().getName());
            }
        };

        // 1. All on main thread
        //observable.subscribe(subscriber);


        // 2. All on executor
//        observable
//                .subscribeOn(Schedulers.from(Executors.newSingleThreadExecutor()))
//                .subscribe(subscriber);

        // 3. observable on one thread, subscriber on another
        observable
                .subscribeOn(Schedulers.from(Executors.newSingleThreadExecutor()))
                .observeOn(Schedulers.newThread())
                .subscribe(subscriber);
    }
}
