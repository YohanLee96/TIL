package com.study.example.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitFailureHandler;

/**
 * Created by Yohan Lee. Created on 2024-06-25 <br/> 
 **/

@Slf4j
public class Ex_Sinks_One {

    public static void main(String[] args) throws InterruptedException {
        Sinks.One<String> sinksOne = Sinks.one();
        Mono<String> mono = sinksOne.asMono();
        sinksOne.emitValue("Hello Reactor", EmitFailureHandler.FAIL_FAST);
        //아래 emit한 데이터는 FAIL_FAST 전략으로인해 무시한다. 교착상태를 방지하기 위한 전략.
        sinksOne.emitValue("Hello Reactor2", EmitFailureHandler.FAIL_FAST);


        mono.subscribe(data -> log.info("# Subscriber1 : {}", data));
        mono.subscribe(data -> log.info("# Subscriber2 : {}", data));
        Thread.sleep(1000L);
    }
}
