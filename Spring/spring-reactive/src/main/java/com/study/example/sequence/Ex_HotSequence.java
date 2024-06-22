package com.study.example.sequence;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * Created by Yohan Lee. Created on 2024-06-23 <br/> 
 **/

@Slf4j
public class Ex_HotSequence {


    public static void main(String[] args) throws InterruptedException {
        String[] singers = {"Singer A", "Singer B", "Singer C", "Singer D", "Singer E"};
        log.info("# Begin concert:");
        Flux<String> concertFlux = Flux
            .fromArray(singers)
            .delayElements(Duration.ofSeconds(1)) //각 데이터의 emit을 1초씩 지연시킨다.
            .share(); // Cold > Hot Sequence로 동작하게끔 해주는 Operator

        concertFlux.subscribe(
            singer -> log.info("Subscriber 1: {}", singer)
        );

        Thread.sleep(2500);
        //Subscriber2는 Subscribe1이 이미 구독완료한 데이터 다음부터 구독한다.
        //현재 로직대로라면 C부터 구독.
        concertFlux.subscribe(
            singer -> log.info("Subscriber 2: {}", singer)
        );
        Thread.sleep(3000);

    }
}
