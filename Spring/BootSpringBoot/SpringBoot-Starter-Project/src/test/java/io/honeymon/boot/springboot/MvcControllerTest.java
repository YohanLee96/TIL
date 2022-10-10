package io.honeymon.boot.springboot;

import io.honeymon.boot.springboot.api.HelloController;
import io.honeymon.boot.springboot.config.bean.RestClientExampleBean;
import io.honeymon.boot.springboot.service.JforCacheService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(HelloController.class)
public class MvcControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestClientExampleBean restClientExampleBean;

    @MockBean
    private JforCacheService jforCacheService;

    @Test
    @SneakyThrows(Exception.class)
    void test() {
        this.mvc.perform(get("/greeting").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Boot Spring Boot!!"));
    }
}
