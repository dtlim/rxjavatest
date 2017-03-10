package incomplete;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by dale on 3/10/2017.
 */
public class ChainExample {
    public static void main(String[] a) {
        Observable<String> observable = Observable.from(new String[] {"Apple", "Mango", "Banana", "Rxjava", "Papaya"});

        // filter get only strings that have the letter 'n'
        // reverse them

        Observable<String> filteredObservable;

//        filteredObservable.subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println("Fruit that has n and is reversed: " + s);
//            }
//        });
    }
}
