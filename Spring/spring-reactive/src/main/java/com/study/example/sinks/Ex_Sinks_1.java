package com.study.example.sinks;

import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Schedules;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitFailureHandler;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Yohan Lee. Created on 2024-06-25 <br/> 
 **/
@Slf4j
public class Ex_Sinks_1 {


    public static void main(String[] args) throws InterruptedException {
        int tasks =6;

        Sinks.Many<String> unicastSink = Sinks.many().unicast().onBackpressureBuffer();
        Flux<String> fluxView = unicastSink.asFlux();
        IntStream
            .range(1, tasks)
            .forEach(n -> {
                try {
                    new Thread(() -> {
                        unicastSink.emitNext(doTask(n), EmitFailureHandler.FAIL_FAST);
                        log.info("# emitted : {}", n);
                    }).start();
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            });

        fluxView
            .publishOn(Schedulers.parallel())
            .map("%s success!"::formatted)
            .doOnNext(n -> log.info("# map() : {}", n))
            .publishOn(Schedulers.parallel())
            .subscribe(data -> log.info("# onNext : {}", data));

        Thread.sleep(200);
    }

    private static String doTask(int taskNum) {
        return "task %d result".formatted(taskNum);
    }
}
