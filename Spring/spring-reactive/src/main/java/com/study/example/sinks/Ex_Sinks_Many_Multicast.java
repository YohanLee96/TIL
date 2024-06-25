package com.study.example.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitFailureHandler;

/**
 * Created by Yohan Lee. Created on 2024-06-25 <br/> 
 **/

@Slf4j
public class Ex_Sinks_Many_Multicast {

    public static void main(String[] args) throws InterruptedException {
        Sinks.Many<Integer> multicastSink = Sinks.many().multicast().onBackpressureBuffer();

        Flux<Integer> fluxView = multicastSink.asFlux();
        multicastSink.emitNext(1, EmitFailureHandler.FAIL_FAST);
        multicastSink.emitNext(2, EmitFailureHandler.FAIL_FAST);

        fluxView.subscribe(data -> log.info("# Subscriber1 : {}", data));
        fluxView.subscribe(data -> log.info("# Subscriber2 : {}", data));
        //Subscriber1,2 모두 emit된 3을 받는다.
        multicastSink.emitNext(3, EmitFailureHandler.FAIL_FAST);
        Thread.sleep(1000);
    }
}
