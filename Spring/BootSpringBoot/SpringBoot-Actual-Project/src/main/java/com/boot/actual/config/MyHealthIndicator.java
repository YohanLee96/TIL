package com.boot.actual.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 액추에이터의 Health정보에 부가적으로 넣고 싶은정보가 있을 경우 이 구현체를 사용한다.
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.down().withDetail("Error Code", 3).build();
    }
}
