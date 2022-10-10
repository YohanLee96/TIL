package com.flux.study.handler;


import com.flux.study.dto.Customer;
import com.flux.study.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Component
public class UserHandler {

    public Mono<ServerResponse> getUser(ServerRequest request) {
        Long userNo = Long.valueOf(request.pathVariable("user"));

        User user = User.builder()
                .userNo(userNo)
                .name("이요한")
                .id("johnxx1")
                .customerList(Collections.singletonList(new Customer("권유진")))
                .build();

        log.info("유저정보를 가져왔습니다.");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class);
    }

    public Mono<ServerResponse> getUserCustomers(ServerRequest request) {
        Long userNo = Long.valueOf(request.pathVariable("user"));

        User user = User.builder()
                .userNo(userNo)
                .name("이요한")
                .id("johnxx1")
                .customerList(Arrays.asList(
                        new Customer("권유진"),
                        new Customer("김덕배"))
                )
                .build();

        log.info("유저의 고객정보를 가져왔습니다.");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class);

    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        Long userNo = Long.valueOf(request.pathVariable("user"));
        log.info("USER_NO : [{}] 유저정보를 삭제하였습니다.", userNo);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(String.format("%d 삭제 완료", userNo)), String.class);
    }


}
