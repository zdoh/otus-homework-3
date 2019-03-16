package ru.zdoher.otushomework3.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.zdoher.otushomework3.configuration.YamlProps;

import java.util.Arrays;
import java.util.Locale;


@Service
public class LocalizationServiceImpl implements LocalizationService {

    private final Locale locale;

    private String fileNameMes;

    private MessageSource ms;

    public LocalizationServiceImpl(MessageSource ms, YamlProps yamlProps) {
        this.ms = ms;

        if(Arrays.asList(yamlProps.getPossibleLocale()).contains(yamlProps.getLocale().getLanguage())) {
            this.locale = yamlProps.getLocale();
        } else {
            this.locale = new Locale(yamlProps.getPossibleLocale()[0]);
        }

        this.fileNameMes = locale + "_" + yamlProps.getTestfilename();
    }


    public String getMessage(String field) {
        return ms.getMessage(field, null, locale);
    }

    public String getQuizFilename() {
        return fileNameMes;
    }
}
