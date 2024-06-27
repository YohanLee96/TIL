package com.study.example.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Yohan Lee. Created on 2024-06-28 <br/>
 * PublishOn과 SubscribeOn이 명확히 다른점은<br/>
 * <b>PublishOn Operator는 체인내에 위치에따라 실행스레드를 변경하고, SubscribeOn Operator는 구독시점부터 실행스레드를 변경한다.</b>
 *
 **/
@Slf4j
public class EX_PublishOn_SubscribeOn {

    public static void main(String[] args) throws InterruptedException {
//        noOn();
//        PublishOn_1();
//        PublishOn_2();
        PublishOn_And_SubscribeOn();
        Thread.sleep(500L);
    }

    private static void noOn() {
        //publishOn과 subscribeOn을 사용하지 않으면, 기본적으로 main 스레드에서 실행된다.
        Flux.fromArray(new Integer[]{1, 3, 5, 7})
            .doOnNext(data -> log.info("#doOnNext fromArray : {}", data))
            .filter(data -> data > 3)
            .doOnNext(data -> log.info("#doOnNext filter : {}", data))
            .map(data -> data * 10)
            .doOnNext(data -> log.info("#doOnNext map : {}", data))
            .subscribe(data -> log.info("#onNext : {}", data));
    }

    private static void PublishOn_1() {
        //publishOn을 사용하면, 해당 Operator 이후의 Operator들이 지정한 스케줄러에서 실행된다.
        Flux.fromArray(new Integer[]{1, 3, 5, 7})
            .doOnNext(data -> log.info("#doOnNext fromArray : {}", data))
            .publishOn(Schedulers.parallel()) //아래 Downstream부터는 실행 스레드가 바뀜.
            .filter(data -> data > 3)
            .doOnNext(data -> log.info("#doOnNext filter : {}", data))
            .map(data -> data * 10)
            .doOnNext(data -> log.info("#doOnNext map : {}", data))
            .subscribe(data -> log.info("#onNext : {}", data));
    }

    private static void PublishOn_2() {
        Flux.fromArray(new Integer[]{1, 3, 5, 7})
            .doOnNext(data -> log.info("#doOnNext fromArray : {}", data)) //실행스레드 바뀜.
            .publishOn(Schedulers.parallel())
            .filter(data -> data > 3)
            .doOnNext(data -> log.info("#doOnNext filter : {}", data))
            .publishOn(Schedulers.parallel()) //publishOn을 추가했기때문에 Downstream부터는 실행스레드가 또바뀜.
            .map(data -> data * 10)
            .doOnNext(data -> log.info("#doOnNext map : {}", data))
            .subscribe(data -> log.info("#onNext : {}", data));
    }

    private static void PublishOn_And_SubscribeOn() {
        Flux.fromArray(new Integer[]{1, 3, 5, 7})
            .subscribeOn(Schedulers.boundedElastic()) //구독 시점부터 실행 스레드가 바뀜.
            .doOnNext(data -> log.info("#doOnNext fromArray : {}", data))
            .filter(data -> data > 3)
            .doOnNext(data -> log.info("#doOnNext filter : {}", data))
            .publishOn(Schedulers.parallel()) //Downstream부터는 실행스레드가 또바뀜.
            .map(data -> data * 10)
            .doOnNext(data -> log.info("#doOnNext map : {}", data))
            .subscribe(data -> log.info("#onNext : {}", data));
    }
}
