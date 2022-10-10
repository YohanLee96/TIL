package io.honeymon.boot.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        //formatterRegistry.addFormatter(); //Formatter 구현체.
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //converters.add() //HttpMessageConverter 구현체.
    }
}
