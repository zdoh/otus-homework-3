package ru.zdoher.otushomework3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.zdoher.otushomework3.dao.QuestionnaireDAO;
import ru.zdoher.otushomework3.domain.Answer;
import ru.zdoher.otushomework3.service.ConsoleService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@SpringBootTest
class TestingImplTest {

    @Autowired
    private Testing testing;

    @MockBean
    private ConsoleService consoleService;

    @MockBean
    private QuestionnaireDAO questionnaireDAO;

    @BeforeEach
    void setUp() {
        Map<String, List<Answer>> testQuesDAO = new HashMap<>();
        testQuesDAO.put("Question1", new ArrayList<>(Arrays.asList(
                new Answer("answer1", true),
                new Answer("answer2", false))));

        testQuesDAO.put("Question2", new ArrayList<>(Arrays.asList(
                new Answer("answer1", true),
                new Answer("answer2", false))));

        testQuesDAO.put("Question3", new ArrayList<>(Arrays.asList(
                new Answer("answer1", false),
                new Answer("answer2", true))));

        given(questionnaireDAO.getQuestionList()).willReturn(testQuesDAO);

        testing.getProfile().setPoints(0);
        testing.getProfile().setRightAnswer(0);
    }

    @Test
    void doTestAlwaysFirst() {
        when(consoleService.getString()).thenReturn("1");
        testing.doTest();

        assertAll(
                () -> assertEquals("1", testing.getProfile().getName()),
                () -> assertEquals("1", testing.getProfile().getSurname()),
                () -> assertEquals(4, testing.getProfile().getPoints()),
                () -> assertEquals(2, testing.getProfile().getRightAnswer())
        );
    }

    @Test
    void doTestAlwaysSecond() {
        when(consoleService.getString()).thenReturn("2");
        testing.doTest();

        assertAll(
                () -> assertEquals("2", testing.getProfile().getName()),
                () -> assertEquals("2", testing.getProfile().getSurname()),
                () -> assertEquals(2, testing.getProfile().getPoints()),
                () -> assertEquals(1, testing.getProfile().getRightAnswer())
        );
    }

}