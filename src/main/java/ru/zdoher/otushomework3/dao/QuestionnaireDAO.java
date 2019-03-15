package ru.zdoher.otushomework3.dao;

import ru.zdoher.otushomework3.domain.Answer;

import java.util.List;
import java.util.Map;

public interface QuestionnaireDAO {

    Map<String, List<Answer>> getQuestionList();
}
