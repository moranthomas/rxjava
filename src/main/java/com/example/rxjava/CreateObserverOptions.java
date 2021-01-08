package com.example.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class CreateObserverOptions implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Observable<String> source = Observable.just("apple", "pear", "orange");

        // OPTION 1 - create() method (NOTE - the last 2 arguments are optional - for the onError() and onComplete()
        source.subscribe(i -> log.info(" event :" + i), Throwable::printStackTrace, ()-> log.info("completed from Observer 1 !"));
    }
}
