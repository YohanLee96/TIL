package com.study.example.sequence;

import java.util.Arrays;
import reactor.core.publisher.Flux;

/**
 * Created by Yohan Lee. Created on 2024-06-23 <br/> 
 **/

public class Ex_ColdSequence {


    public static void main(String[] args) throws InterruptedException {
        Flux<String> coldFlux = Flux
            .fromIterable(Arrays.asList("a", "b", "c"))
            .map(String::toUpperCase);
        coldFlux.subscribe(System.out::println);
        System.out.println("----------------------------");
        Thread.sleep(2000);
        //Cold Sequence > 다시 구독을 해도 처음부터 시작한다.
        coldFlux.subscribe(System.out::println);

    }
}
