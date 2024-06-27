package com.study.example.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Yohan Lee. Created on 2024-06-28 <br/> 
 **/
@Slf4j
public class Ex_Subscribe_On {

    public static void main(String[] args) throws InterruptedException {
        Flux.fromArray(new Integer[]{1, 3, 5, 7})
            //구독이 발생한 직후 실행될 스레드를 지정하는 Operator
            .subscribeOn(Schedulers.boundedElastic())
            .doOnNext(data -> log.info("#doOnNext: {}", data))
            //구독이 발생한 시점에 실행되는 Operator(구독 발생 시, 제일 처음에 동작)
            .doOnSubscribe(subscription -> log.info("#doOnSubscribe"))
            .subscribe(data -> log.info("#onNext : {}", data));

        Thread.sleep(500L);
    }
}
