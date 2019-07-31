package bs2.cim.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The CIM microservice runner class.
 * 
 * @author Anton Nazarov
 * @since 03/06/2019
 */
@SpringBootApplication
@ComponentScan(basePackages = { "bs2.cim.service", "bs2.cim.persistence.handler", "bs2.commons.cim" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
