package ru.zdoher.otushomework3.service;

import ru.zdoher.otushomework3.domain.Answer;

import java.util.List;
import java.util.Map;

public interface QuestionnaireService {

    Map<String, List<Answer>> getQuestionList();
}
