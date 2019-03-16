package ru.zdoher.otushomework3.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.Locale;

@ConfigurationProperties(prefix = "config")
public class YamlProps {
    private Locale locale;

    private String testfilename;

    private String[] possibleLocale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String[] getPossibleLocale() {
        return possibleLocale;
    }

    public void setPossibleLocale(String[] possibleLocale) {
        this.possibleLocale = possibleLocale;
    }

    public String getTestfilename() {
        return testfilename;
    }

    public void setTestfilename(String testfilename) {
        this.testfilename = testfilename;
    }

}
