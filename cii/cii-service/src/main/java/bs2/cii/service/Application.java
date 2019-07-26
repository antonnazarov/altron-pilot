package bs2.cii.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * The CII- microservice runner class.
 * 
 * @author Anton Nazarov
 * @since 18/06/2019
 */
@SpringBootApplication
@EnableBinding(Source.class)
@EnableFeignClients
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "bs2.cii.service", "bs2.commons.metrics", "bs2.commons.cim" })
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
