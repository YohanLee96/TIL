package io.honeymon.boot.springboot.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "my")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class AppProperties {
    private List<String> servers = new ArrayList<>();

    public AppProperties(List<String> servers) {
        this.servers = servers;
    }


    public List<String> getServers() {
        return this.servers;
    }


}
