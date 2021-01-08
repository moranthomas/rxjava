package com.example.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
//public class CreateObservableOptions implements CommandLineRunner {
public class CreateObservableOptions {

    //@Override
    public void run(String... args) throws Exception {

        // OPTION 1 - create() method
        Observable<Integer> source = Observable.create(
                e -> {
                    e.onNext(13);
                    e.onNext(14);
                    e.onNext(15);
                    e.onComplete();
                }
        );
        source.subscribe(x -> log.info("OPTION 1: create() Method -> " + x));
        // OPTION 2 - just() method
        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(x -> log.info("OPTION 2: just() Method -> " +x));

        // OPTION 3 - fromIterable() method
        List<String> list = List.of("John", "Paul", "Mike");
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(x -> log.info("OPTION 3: fromIterable() Method -> " +x));

        // OPTION 4 - range() method
        Observable<Integer> range = Observable.range(3,10);
        range.subscribe(x -> log.info("OPTION 4: range() Method -> " +x));

        // OPTION 5 - interval() method
        // This will create an infinite stream of events.
        @NonNull Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);
        interval.subscribe(x -> log.info("OPTION 5: interval() Method -> " +x));
        //Thread.sleep(10000);
    }
}
