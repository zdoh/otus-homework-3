package ru.zdoher.otushomework3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.zdoher.otushomework3.service.ConsoleService;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Методы тестирования ")
@SpringBootTest
class
TestingImplTest {

    @Autowired
    private Testing testing;

    @MockBean
    private ConsoleService consoleService;

    @Test
    @DisplayName(" работает корректно")
    void doTestRightData() {
        when(consoleService.getString()).thenReturn("2");
        testing.doTest();

        assertAll(
                () -> assertEquals("2", testing.getProfile().getName()),
                () -> assertEquals("2", testing.getProfile().getSurname()),
                () -> assertEquals(testing.getProfile().getPoints(), 2 * testing.getProfile().getRightAnswer())
        );
    }

}