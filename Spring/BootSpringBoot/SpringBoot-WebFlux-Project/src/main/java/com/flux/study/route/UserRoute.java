package com.flux.study.route;


import com.flux.study.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRoute {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        return route(GET("users/{user}").and(accept(MediaType.APPLICATION_JSON)),
                userHandler::getUser)
                .andRoute(GET("users/{user}/customers").and(accept(MediaType.APPLICATION_JSON)),
                        userHandler::getUserCustomers)
                .andRoute(DELETE("users/{user}").and(accept(MediaType.APPLICATION_JSON)),
                        userHandler::deleteUser);
    }
}
