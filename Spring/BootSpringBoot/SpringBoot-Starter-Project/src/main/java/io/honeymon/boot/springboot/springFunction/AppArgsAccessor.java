package io.honeymon.boot.springboot.springFunction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AppArgsAccessor {

    /**
     * 어플리케이션 실행 시, 전달되는 실행인자에 접근하여 인자에 어떤정보들이
     * 전달되는지 볼 수 있다.
     *
     * @param args SpringApplication 실행 인자[SpringApplication.run(args) -> args]
     */
    @Autowired
    public AppArgsAccessor(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        log.debug("debug={}", debug);
        List<String> files = args.getNonOptionArgs();
        log.debug("files={}", files);
        log.info("options= {}", args.getOptionNames());

    }
}
