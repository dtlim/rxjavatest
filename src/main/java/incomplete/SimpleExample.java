package incomplete;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by dale on 3/10/2017.
 */
public class SimpleExample {

    public static void main(String[] a) {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello world");
                subscriber.onCompleted();
            }
        });

        Observable<String> observableLambda = Observable.create(s -> {
            s.onNext("Hello world!");
            s.onCompleted();
        });

        // create subscriber here
    }

}
