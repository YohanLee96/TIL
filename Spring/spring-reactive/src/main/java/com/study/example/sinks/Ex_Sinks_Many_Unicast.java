package com.study.example.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitFailureHandler;

/**
 * Created by Yohan Lee. Created on 2024-06-25 <br/> 
 **/

@Slf4j
public class Ex_Sinks_Many_Unicast {

    public static void main(String[] args) throws InterruptedException {
        Sinks.Many<Integer> unicastSink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Integer> fluxView = unicastSink.asFlux();
        unicastSink.emitNext(1, EmitFailureHandler.FAIL_FAST);
        unicastSink.emitNext(2, EmitFailureHandler.FAIL_FAST);

        fluxView.subscribe(data -> log.info("# Subscriber1 : {}", data));
        unicastSink.emitNext(3, EmitFailureHandler.FAIL_FAST);
        //unicast방식이므로 에러발생. 최초 구독자외에는 허용하지 않는다.
        fluxView.subscribe(data -> log.info("# Subscriber2 : {}", data));
        Thread.sleep(100);
    }
}
