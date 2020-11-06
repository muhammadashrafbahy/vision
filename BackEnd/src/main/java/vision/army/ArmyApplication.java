package vision.army;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties  // make you to config classes that read from properties files
@EnableAutoConfiguration
@ComponentScan("vision.army")
@SpringBootApplication (scanBasePackages={"vision.army.config","vision.army.entity"})
public class ArmyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArmyApplication.class, args);
    }

}
