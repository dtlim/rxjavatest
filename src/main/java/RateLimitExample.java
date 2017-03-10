import rx.Observable;
import rx.Subscriber;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by daleansleylim on 10/03/2017.
 */
public class RateLimitExample {
    public static void main(String[] a) {
        Random random = new Random();
        Observable<Integer> rng = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                while (true) {
                    int x = random.nextInt();
                    System.out.println("Emit: " + x);
                    subscriber.onNext(x);
                    try {
                        Thread.sleep(40);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        rng.sample(1, TimeUnit.SECONDS).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer);
            }
        });
    }
}
