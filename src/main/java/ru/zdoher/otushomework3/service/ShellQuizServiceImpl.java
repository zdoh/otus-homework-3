package ru.zdoher.otushomework3.service;

import org.springframework.stereotype.Service;
import ru.zdoher.otushomework3.view.Testing;

@Service
public class ShellQuizServiceImpl implements ShellQuizService {
    private Testing testing;

    private LocalizationService localizationService;

    public ShellQuizServiceImpl(Testing testing, LocalizationService localizationService) {
        this.testing = testing;
        this.localizationService = localizationService;
    }

    @Override
    public void quiz() {
        System.out.println(localizationService.getMessage("message.shell.startApp"));
        testing.doTest();
    }

}
