package com.example.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Slf4j
public class ObserverAndObservable implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("hey there");

        Observable<Integer> source = new ObservableCreate<Integer> (new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                try {
                    emitter.onNext(10);
                    emitter.onNext(11);
                    emitter.onComplete();
                } catch (Throwable t) {
                    emitter.onError(t);
                }
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                log.info("Subscribed");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                log.info("onNext: integer = "+ integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                 e.printStackTrace();
            }

            @Override
            public void onComplete() {
                log.info("completed");
            }
        };


        source.subscribe(observer);

    }
}
