package io.honeymon.boot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BootSpringBootApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(BootSpringBootApplication.class);
        application.run(args);


        //Builder패턴을 이용한 SpringApplication 실행.
//		new SpringApplicationBuilder()
//				.sources(BootSpringBootApplication.class)
//				.listeners(new ApplicationPidFileWriter())
//			//	.profiles("prod")
//				.run(args);
    }

}
