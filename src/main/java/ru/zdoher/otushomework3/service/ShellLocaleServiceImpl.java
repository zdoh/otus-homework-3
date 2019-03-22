package ru.zdoher.otushomework3.service;

import org.springframework.stereotype.Service;
import ru.zdoher.otushomework3.dao.QuestionnaireDAO;

@Service
public class ShellLocaleServiceImpl implements ShellLocaleService {
    private LocalizationService localizationService;
    private QuestionnaireDAO questionnaireDAO;

    public ShellLocaleServiceImpl(LocalizationService localizationService, QuestionnaireDAO questionnaireDAO) {
        this.localizationService = localizationService;
        this.questionnaireDAO = questionnaireDAO;
    }

    @Override
    public String localeShow() {
        String[] locale = localizationService.getPossibleLocale();

        StringBuilder stringBuilder = new StringBuilder("");

        if(locale.length == 1) {
            stringBuilder.append(locale[0]);
        } else if (locale.length == 2) {
            stringBuilder.append(locale[0]);
            stringBuilder.append(" or ");
            stringBuilder.append(locale[1]);
        } else if (locale.length > 2) {
            for(int i = 0; i < locale.length - 2; i++) {
                stringBuilder.append(locale[i]);
                stringBuilder.append(", ");
            }

            stringBuilder.append(locale[locale.length - 2]);
            stringBuilder.append(" or ");
            stringBuilder.append(locale[locale.length - 1]);
        }


        return stringBuilder.toString();

    }

    @Override
    public String localeSet(String locale) {
        if(!localizationService.setLocale(locale)) {
            return "Can't set locale " + locale;
        }
        questionnaireDAO.rebaseHash();
        return "Locale set to " + locale;
    }
}
