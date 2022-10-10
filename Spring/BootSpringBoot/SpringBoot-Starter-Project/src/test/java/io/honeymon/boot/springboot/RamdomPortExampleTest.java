package io.honeymon.boot.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RamdomPortExampleTest {

    @Autowired
    private RestTemplate restTemplate;


    @Test
    void test() {
        String body = this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);
        assertThat(body).isEqualTo("Hello World");
    }
}
