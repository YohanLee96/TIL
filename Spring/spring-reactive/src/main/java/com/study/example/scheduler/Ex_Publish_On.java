package com.study.example.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Yohan Lee. Created on 2024-06-28 <br/> 
 **/
@Slf4j
public class Ex_Publish_On {

    public static void main(String[] args) throws InterruptedException {
        Flux.fromArray(new Integer[]{1, 3, 5, 7})
            .doOnNext(data -> log.info("#doOnNext: {}", data))
            .doOnSubscribe(subscription -> log.info("#doOnSubscribe"))
            .publishOn(Schedulers.parallel()) //Downstream으로 데이터를 emit하는 스레드를 변경.
            .subscribe(data -> log.info("#onNext : {}", data)); //여기서부터 실행 스레드가 변경된다.

        Thread.sleep(500L);
    }
}
