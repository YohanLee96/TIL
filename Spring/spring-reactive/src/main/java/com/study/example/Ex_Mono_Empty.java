package com.study.example;

import reactor.core.publisher.Mono;

/**
 * Created by Yohan Lee. Created on 2024-06-20 <br/> 
 **/
public class Ex_Mono_Empty {

    public static void main(String[] args) {
        Mono
            .empty()
            .subscribe(
                none -> System.out.println("# emitted onNext signal"),
                error -> {},
                // onComplete signal > 데이터를 한건도 emit하지 않았기 때문에, onComplete signal 발생.
                () -> System.out.println("# emitted onComplete signal")
            );
    }
}
