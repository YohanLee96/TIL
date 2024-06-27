package com.study.example.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Yohan Lee. Created on 2024-06-28 <br/> 
 **/
@Slf4j
public class Ex_Parallel {

    public static void main(String[] args) throws InterruptedException {
        parallel();
        System.out.println("====================================================");
        Thread.sleep(1000L);
        parallelCountFix();
    }


    private static void parallel() throws InterruptedException {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19})
            //emit되는 데이터를 CPU의 물리적인 스레드수에 맞게 골고루 분배하는 역할을 하는 Operator
            .parallel()
            //실질적으로 병렬작업을 수행할 스레드를 할당하는 Operator. 해당코드를 주석하면 병렬처리가 되지 않는다.
            .runOn(Schedulers.parallel())
            .subscribe(data -> log.info("#onNext : {}", data));

        Thread.sleep(100L);
    }

    private static void parallelCountFix() throws InterruptedException {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19})
            // ** 병렬처리에 사용할 물리적인 스레드 개수도 지정할 수 있다.
            .parallel(4)
            //실질적으로 병렬작업을 수행할 스레드를 할당하는 Operator. 해당코드를 주석하면 병렬처리가 되지 않는다.
            .runOn(Schedulers.parallel())
            .subscribe(data -> log.info("#onNext : {}", data));

        Thread.sleep(100L);
    }
}
