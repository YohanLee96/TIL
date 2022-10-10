package com.boot.actual.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class actualHttpTraceRepository extends InMemoryHttpTraceRepository{

    public void add(HttpTrace trace) {
        super.add(trace);
        log.info("Request URI: [{}]", trace.getRequest().getUri());
        log.info("Response Headers: [{}]", trace.getResponse().getHeaders().toString());
    }

}
