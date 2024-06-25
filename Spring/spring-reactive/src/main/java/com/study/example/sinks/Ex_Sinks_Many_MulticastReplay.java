package com.study.example.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitFailureHandler;

/**
 * Created by Yohan Lee. Created on 2024-06-25 <br/> 
 **/

@Slf4j
public class Ex_Sinks_Many_MulticastReplay {

    public static void main(String[] args) throws InterruptedException {

        //limit(2) => emit된 최근 데이터중 2개만 받는다.
        Sinks.Many<Integer> replaySink = Sinks.many().replay().limit(2);

        Flux<Integer> fluxView = replaySink.asFlux();
        replaySink.emitNext(1, EmitFailureHandler.FAIL_FAST);
        replaySink.emitNext(2, EmitFailureHandler.FAIL_FAST);
        replaySink.emitNext(3, EmitFailureHandler.FAIL_FAST);

        //최근 이벤트  2, 3만 Subscribe
        fluxView.subscribe(data -> log.info("# Subscriber1 : {}", data));

        replaySink.emitNext(4, EmitFailureHandler.FAIL_FAST);
        //최근 이벤트 3, 4만 Subscribe
        fluxView.subscribe(data -> log.info("# Subscriber2 : {}", data));
        Thread.sleep(1000);
    }
}
