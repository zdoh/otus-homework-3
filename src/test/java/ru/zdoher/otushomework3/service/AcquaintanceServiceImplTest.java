package ru.zdoher.otushomework3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import ru.zdoher.otushomework3.domain.Profile;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@DisplayName("Сервис получение фамилии и имени")
@SpringBootTest
class AcquaintanceServiceImplTest {

    @MockBean
    private ConsoleService consoleService;

    @SpyBean
    private LocalizationService localizationService;

    private AcquaintanceService acquaintanceService;

    @BeforeEach
    void setUp() {
        acquaintanceService = new AcquaintanceServiceImpl(consoleService, localizationService);
    }

    @Test
    @DisplayName(" работает корректно")
    void makeAcquantance() {
        Profile profile = new Profile();
        //when(consoleService.getString()).thenReturn("Name").thenReturn("Surname");
        doReturn("Name", "Surname").when(consoleService.getString());
        acquaintanceService.makeAcquantance(profile);

        assertAll(
                () -> assertEquals("Name", profile.getName()),
                () -> assertEquals("Surname", profile.getSurname())
        );

    }
}