package ru.zdoher.otushomework3.service;

public interface LocalizationService {

    String getMessage(String message);

    String getQuizFilename();

    String[] getPossibleLocale();

    boolean setLocale(String newLocale);
}
