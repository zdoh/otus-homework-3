package ru.zdoher.otushomework3.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.zdoher.otushomework3.configuration.YamlProps;

import java.util.Arrays;
import java.util.Locale;


@Service
public class LocalizationServiceImpl implements LocalizationService {

    private Locale locale;

    private MessageSource ms;

    private YamlProps yamlProps;

    public LocalizationServiceImpl(MessageSource ms, YamlProps yamlProps) {
        this.ms = ms;
        this.yamlProps = yamlProps;
        setLocale(yamlProps.getLocale().getLanguage());
    }


    public String getMessage(String field) {
        return ms.getMessage(field, null, locale);
    }

    public String getQuizFilename() {
        return locale + "_" + yamlProps.getTestfilename();
    }

    public String[] getPossibleLocale() {
        return yamlProps.getPossibleLocale();
    }

    public boolean setLocale(String newLocale) {
        if(Arrays.asList(yamlProps.getPossibleLocale()).contains(newLocale)) {
            this.locale = new Locale(newLocale);
            return true;
        } else {
            this.locale = new Locale(yamlProps.getPossibleLocale()[0]);
            return false;
        }
    }
}
