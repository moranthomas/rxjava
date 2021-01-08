package com.example.rxjava;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SingleMaybeCompletable implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Observable<String> source = Observable.just("tom", "dick", "harry");

        // Create the source
        source
               .first("Name")
               .subscribe(x -> log.info(x));

        // Single
        Single.just("Alex")
        .subscribe( x -> log.info(x));

        // Maybe
        source.firstElement()
                .subscribe(x-> log.info("First Maybe - " + x));

        // Completable
        //Completable completable = Completable.complete();
        Completable.fromRunnable( () -> log.info("some process "))
        .subscribe( () -> log.info(" comp'd"));

        source.subscribe( e -> log.info("Observer 1 : " + e));
        source.subscribe( e -> log.info("Observer 2 : " + e));

        Thread.sleep(10000);
    }
}
