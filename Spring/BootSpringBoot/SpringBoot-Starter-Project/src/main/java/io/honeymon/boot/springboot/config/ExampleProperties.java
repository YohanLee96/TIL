package io.honeymon.boot.springboot.config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("example")
@Getter
@ToString
public class ExampleProperties {
    private final List<MyPojo> list = new ArrayList<>();

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MyPojo {
        private String name;
        private String description;

        @Builder
        public MyPojo(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

}
