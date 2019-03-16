package ru.zdoher.otushomework3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс AnswerTest")
class AnswerTest {

    @Test
    @DisplayName("корректно создается")
    void profileCreateAndGet() {
        Answer answer = new Answer("Answer", true);

        assertAll(
                () -> assertEquals("Answer", answer.getAnswer()),
                () -> assertEquals(true, answer.getRight())
        );
    }

}