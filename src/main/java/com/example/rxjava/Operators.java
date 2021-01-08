package com.example.rxjava;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Operators implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Observable.just(50, 60, 70, 80, 40, 85, 62, 55, 100, 99)
                .filter (e -> e > 65)
                .sorted()
                .subscribe( e -> log.info("Marks = " + e));
    }
}
