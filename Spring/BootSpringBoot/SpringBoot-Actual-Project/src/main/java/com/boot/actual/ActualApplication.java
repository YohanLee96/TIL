package com.boot.actual;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ActualApplication {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(ActualApplication.class);
//        app.addListeners(new ApplicationPidFileWriter(), new WebServerPortFileWriter());
//        app.run(args);
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.LOG)
                .sources(ActualApplication.class)
                .run(args);
    }

}
