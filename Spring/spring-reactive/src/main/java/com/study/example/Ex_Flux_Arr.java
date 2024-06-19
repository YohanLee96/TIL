package com.study.example;

import reactor.core.publisher.Flux;

/**
 * Created by Yohan Lee. Created on 2024-06-20 <br/> 
 **/
public class Ex_Flux_Arr {

    public static void main(String[] args) {
        Flux.just(new Integer[]{3, 6, 7, 9})
            .filter(num -> 6 < num)
            .map(num -> num * 2)
            .subscribe(System.out::println);
        //just() 사용 시, 내부적으로 아래와 같이 fromArray() 호출을 통해 처리한다.
        Flux.fromArray(new Integer[]{3, 6, 7, 9})
            .filter(num -> 6 < num)
            .map(num -> num * 2)
            .subscribe(System.out::println);
    }
}
