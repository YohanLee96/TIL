package com.study.example.backpressure;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

/**
 * Created by Yohan Lee. Created on 2024-06-23 <br/> 
 **/

@Slf4j
public class Ex_Bp_1 {

    public static void main(String[] args) {
        Flux.range(1, 5)
            .doOnRequest(data -> log.info("# doOnRequest : {}", data))
            .subscribe(new BaseSubscriber<>() {
                @Override
                protected void hookOnSubscribe(Subscription subscription) {
                    request(1); //데이터를 1개씩 요청하는걸 로깅할 목적.
                }

                @Override
                @SneakyThrows
                protected void hookOnNext(Integer value) {
                    Thread.sleep(2000);
                    log.info("# hookOnNext : {}", value); //처리된 데이터
                    request(1); //데이터를 1개씩 요청한다.
                }
            });
    }
}
