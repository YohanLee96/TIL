package com.study.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Yohan Lee. Created on 2024-06-23 <br/> 
 **/
public class Ex_Mono_Concat {


    public static void main(String[] args) {
        concatWith();
        System.out.println("---------------");
        concat();
    }

    private static void concat() {
        Flux.concat(
                Flux.just("a", "b", "c"),
                Flux.just("d", "e", "f"),
                Flux.just("g", "h", "i")
            )
            //emit하는 데이터들을 모아서 하나의 List 원소로 만들어주는 Operator이므로, Mono로 반환된다.
            .collectList()
            .subscribe(System.out::println);

    }

    private static void concatWith() {
        Flux<String> flux = Mono.justOrEmpty("Steve")
                                .concatWith(Mono.justOrEmpty("Jobs"));
        flux.subscribe(System.out::println);
    }
}
