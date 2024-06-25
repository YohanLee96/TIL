package com.study.example.sinks;

import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Yohan Lee. Created on 2024-06-25 <br/> 
 **/
@Slf4j
public class Ex_CreateOperator {

    public static void main(String[] args) throws InterruptedException {
        int tasks = 6;
        Flux
            .create((FluxSink <String> sink) -> {
                IntStream
                    .range(1, tasks)
                    .forEach(value -> sink.next(doTask(value)));
            })
            .subscribeOn(Schedulers.boundedElastic())
            .doOnNext(n -> log.info("# create(): {}", n))
            .publishOn(Schedulers.parallel())
            .map("%s success!"::formatted)
            .doOnNext(n -> log.info("# map(): {}", n))
            .publishOn(Schedulers.parallel())
            .subscribe(data -> log.info("# onNext: {}", data));
        Thread.sleep(5000);
    }

    private static String doTask(int value) {
        return "task %d result".formatted(value);
    }
}
