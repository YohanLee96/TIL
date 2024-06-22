package com.study.example.sequence;

import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Created by Yohan Lee. Created on 2024-06-23 <br/> 
 **/

@Slf4j
public class Ex_Cold_And_Hot_HTTP {

    public static void main(String[] args) throws InterruptedException {
        coldSequence();
        System.out.println("=====================================");
        hotSequence();
    }

    private static void hotSequence() throws InterruptedException {
        Mono<String> mono = callWorldTime().cache(); //최초 구독한 데이터 캐싱.
        mono.subscribe(datetime -> log.info("# dateTime1 : {}", datetime));
        Thread.sleep(2000);
        //여기서 datetime1에서 캐싱한 데이터를 사용한다.
        mono.subscribe(datetime -> log.info("# dateTime2 : {}", datetime));
        Thread.sleep(2000);
    }

    private static void coldSequence() throws InterruptedException {
        Mono<String> mono = callWorldTime();
        mono.subscribe(datetime -> log.info("# dateTime1 : {}", datetime));
        Thread.sleep(2000);
        mono.subscribe(datetime -> log.info("# dateTime2 : {}", datetime));
        Thread.sleep(2000);
    }

    private static Mono<String> callWorldTime() {
        return WebClient.create()
                        .get()
                        .uri("http://worldtimeapi.org/api/timezone/Asia/Seoul")
                        .retrieve()
                        .bodyToMono(String.class)
                        .map(response -> JsonPath.parse(response)
                                                 .read("$.datetime")
                        );
    }
}
