package io.honeymon.boot.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JforCacheService {

    @Cacheable("add")
    public int add(int a, int b) {
        log.info("a : {}, b : {}", a, b);
        return a + b;
    }
}
