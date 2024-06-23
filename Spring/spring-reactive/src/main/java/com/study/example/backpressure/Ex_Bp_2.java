package com.study.example.backpressure;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Created by Yohan Lee. Created on 2024-06-23 <br/> 
 **/
@Slf4j
public class Ex_Bp_2 {

    public static void main(String[] args) throws InterruptedException {
        //Backpressure IGNORE = Backpressure를 사용하지 않음.
        //        ERROR();
        //        DROP();
        //        LATEST();
//        BUFFER(BufferOverflowStrategy.DROP_LATEST);
        BUFFER(BufferOverflowStrategy.DROP_OLDEST);
    }

    /**
     * 버퍼가 가득찬 상태에서 오버플로가 발생했을 때, 데이터가 드랍됨.
     * @param strategy DROP_LATEST = 버퍼가 가득찰 경우, 버퍼에서 가장 최근에 추가된 데이터를 폐기.
     *                 DROP_OLDEST = 버퍼가 가득찰 경우, 버퍼에 가장 오래된 데이터를 폐기.
     */
    private static void BUFFER(BufferOverflowStrategy strategy) throws InterruptedException {
        Flux
            .interval(Duration.ofMillis(300))
            .doOnNext(data -> log.info("# emitted by original Flux : {}", data))
            .onBackpressureBuffer(2,
                                  droppedData -> log.info("# dropped : {}", droppedData),
                                  strategy)
            .doOnNext(data -> log.info("[# emitted by Buffer : {} ]", data))
            .publishOn(Schedulers.parallel(), false, 1)
            .subscribe(data -> {
                           try {
                               Thread.sleep(1000L);
                           } catch (InterruptedException e) {
                           }
                           log.info("# onNext : {}", data);
                       },
                       Throwable::printStackTrace
            );
        Thread.sleep(3000L);
    }

    //버퍼가 가득찰 경우, 가장 최근에 emit된 데이터만 남겨두고 나머지 폐기.
    private static void LATEST() throws InterruptedException {
        Flux
            .interval(Duration.ofMillis(1))
            .onBackpressureLatest() //Backpressure를 처리하는 방법을 ERROR전략으로 설정.
            .publishOn(Schedulers.parallel())
            .subscribe(data -> {
                           try {
                               Thread.sleep(5);
                           } catch (InterruptedException e) {
                           }
                           log.info("# onNext : {}", data);
                       },
                       Throwable::printStackTrace
            );

        Thread.sleep(2000L);
    }

    //버퍼가 가득차면 버퍼가 비어질때까지 데이터를 버림.
    private static void DROP() throws InterruptedException {
        Flux
            .interval(Duration.ofMillis(1))
            .onBackpressureDrop(droppedData -> log.info("# dropped : {}", droppedData)) //Backpressure를 처리하는 방법을 ERROR전략으로 설정.
            .publishOn(Schedulers.parallel())
            .subscribe(data -> {
                           try {
                               Thread.sleep(5);
                           } catch (InterruptedException e) {
                           }
                           log.info("# onNext : {}", data);
                       },
                       Throwable::printStackTrace
            );

        Thread.sleep(2000L);
    }


    //버퍼가 가득차면 Ex를 발생시키는 ERROR 전략.
    private static void ERROR() throws InterruptedException {
        Flux
            .interval(Duration.ofMillis(1))
            .onBackpressureError() //Backpressure를 처리하는 방법을 ERROR전략으로 설정.
            .doOnNext(data -> log.info("# doOnNext : {}", data))
            .publishOn(Schedulers.parallel())
            .subscribe(data -> {
                           try {
                               Thread.sleep(5);
                           } catch (InterruptedException e) {
                           }
                           log.info("# onNext : {}", data);
                       },
                       Throwable::printStackTrace
            );

        Thread.sleep(2000L);
    }
}
