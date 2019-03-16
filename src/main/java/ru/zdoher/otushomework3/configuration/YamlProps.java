package ru.zdoher.otushomework3.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "config")
public class YamlProps {
    private String locale;

    private String testfilename;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTestfilename() {
        return testfilename;
    }

    public void setTestfilename(String testfilename) {
        this.testfilename = testfilename;
    }
}
