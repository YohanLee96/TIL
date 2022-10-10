package io.honeymon.boot.springboot.api;

import io.honeymon.boot.springboot.config.bean.RestClientExampleBean;
import io.honeymon.boot.springboot.service.JforCacheService;
import io.honeymon.boot.springboot.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final JforCacheService jforCacheService;
    private final RestClientExampleBean restClientExampleBean;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok("Hello, Boot Spring Boot!!");
    }


    @GetMapping("/errorTest")
    public String errorTest() throws Exception {
        throw new Exception("Error!!");
    }

    @PostMapping("/cacheServiceTest")
    public int cacheServiceTest(@RequestParam int first, @RequestParam int second) {
        return jforCacheService.add(first, second);
    }

    @GetMapping("/restTemplateTest")
    public String restTemplateTest(@RequestParam int num) {
        return restClientExampleBean.findOne(num);
    }


}
