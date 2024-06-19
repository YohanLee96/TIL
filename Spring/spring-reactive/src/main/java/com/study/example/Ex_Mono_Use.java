package com.study.example;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

/**
 * Created by Yohan Lee. Created on 2024-06-20 <br/> 
 **/
public class Ex_Mono_Use {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Mono
            .just(
                restTemplate
                    .exchange(
                        "http://worldtimeapi.org/api/timezone/Asia/Seoul",
                        HttpMethod.GET,
                        new HttpEntity<>(headers),
                        String.class
                    )
            )
            .map(response -> {
                //JSON 파싱
                DocumentContext jsonContext = JsonPath.parse(response.getBody());
                return jsonContext.<String>read("$.datetime");
            })
            .subscribe(
                data -> System.out.println("# emitted data : " + data),
                error -> {
                    System.out.println(error);
                },
                () -> System.out.println("# onComplete signal")
            );
    }
}
