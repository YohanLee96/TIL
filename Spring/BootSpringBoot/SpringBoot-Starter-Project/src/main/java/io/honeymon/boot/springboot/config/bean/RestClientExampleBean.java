package io.honeymon.boot.springboot.config.bean;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientExampleBean {
    private final RestTemplate restTemplate;

    public RestClientExampleBean(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String findOne(int num) {
        return this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + num, String.class);
    }
}
