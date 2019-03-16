package ru.zdoher.otushomework3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.zdoher.otushomework3.configuration.YamlProps;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class OtusHomework3Application {

    public static void main(String[] args) {
        SpringApplication.run(OtusHomework3Application.class, args);
    }

}
