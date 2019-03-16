package ru.zdoher.otushomework3.view;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableConfigurationProperties
@ComponentScan({"ru.zdoher.otushomework3.configuration",
        "ru.zdoher.otushomework3.dao",
        "ru.zdoher.otushomework3.domain",
        "ru.zdoher.otushomework3.service",
        "ru.zdoher.otushomework3.view"})
public class TestContextConfig {
}
