package ru.zdoher.otushomework3.dao;

import com.opencsv.CSVReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import ru.zdoher.otushomework3.domain.Answer;
import ru.zdoher.otushomework3.service.LocalizationService;

import java.io.*;
import java.util.*;


@Service
public class QuestionnaireDAOImpl implements QuestionnaireDAO {
    private Map<String, List<Answer>> questions = new HashMap<>();

    public QuestionnaireDAOImpl(LocalizationService localizationService, ResourceLoader resourceLoader) throws IOException {

        Resource resource = resourceLoader.getResource(localizationService.getQuizFilename());
        CSVReader csvReader = new CSVReader(new InputStreamReader(resource.getInputStream()));
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            if(nextRecord.length >= 3) {
                List<Answer> answerList = new ArrayList<>();
                answerList.add(new Answer(nextRecord[1], true));

                for (int i = 2; i < nextRecord.length; i++) {
                    answerList.add(new Answer(nextRecord[i], false));
                }

                Collections.shuffle(answerList);

                questions.put(nextRecord[0], answerList);
            }
        }
    }


    @Override
    public Map<String, List<Answer>> getQuestionList() {
        return questions;
    }

}
