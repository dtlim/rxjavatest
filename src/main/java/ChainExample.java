import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dale on 3/10/2017.
 */
public class ChainExample {
    public static void main(String[] a) {
        Observable<String> filteredObservable = Observable.from(new String[] {"Apple", "Mango", "Banana", "Rxjava", "Papaya"})
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s.contains("n");
                    }
                })
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return new StringBuilder(s).reverse().toString();
                    }
                });

        Observable<String> filteredObservableLabmda = Observable.from(new String[] {"Apple", "Mango", "Banana", "Rxjava", "Papaya"})
                .filter(s -> s.contains("n"))
                .map(s -> new StringBuilder(s).reverse().toString());

        filteredObservable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s + " :tiurF");
            }
        });
    }
}
