package io.honeymon.boot.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class TestConfigurationTest {
    @TestConfiguration
    static class InnerTestConfig {
        @Bean
        RestTemplate restTemplate() {
            return new RestTemplate() {
                @Override
                public <T> T getForObject(String url, Class<T> responseType, Object... urlVariables) throws RestClientException {
                    if (responseType == String.class) {
                        return (T) "Test";
                    } else {
                        throw new RestClientException("Not Support type: " + responseType.getName());
                    }
                }
            };
        }
    }

    @Autowired
    RestTemplate restTemplate;

    @Test
    void getForObject() {
        assertThat(restTemplate.getForObject("2", String.class)).isEqualTo("Test");
    }

    @Test
    void errorGetForObject() {
        assertThat(restTemplate.getForObject("3", Integer.class)).isEqualTo("Test");
    }
}
