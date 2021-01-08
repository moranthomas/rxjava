package com.example.rxjava;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class CombiningObservables implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Observable src1 = Observable.just(10, 20, 30, 40, 50);
        Observable src2 = Observable.just(60, 70, 80, 90, 100);

        Observable.merge(src1, src2)
                .subscribe( e -> log.info("Received = " + e));

        Observable src3 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src3 : " +e).take(10);
        Observable src4 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src4 : " +e).take(10);

        Observable.concat(src3, src4)
                .subscribe( e -> log.info("Received = " + e));

        Thread.sleep(20000);

        List<String> list = List.of("Hello", "Reactive", "Programming");

        Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split(" ")))
                .subscribe(x -> log.info(x.toString()));
    }
}
