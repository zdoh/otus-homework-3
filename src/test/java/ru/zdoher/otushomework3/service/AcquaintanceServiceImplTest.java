package ru.zdoher.otushomework3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.zdoher.otushomework3.domain.Profile;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Сервис ввода данных")
@ExtendWith(MockitoExtension.class)
class AcquaintanceServiceImplTest {

    @Mock
    private ConsoleService consoleService;

    @Mock
    private LocalizationService localizationService;

    private AcquaintanceService acquaintanceService;

    @BeforeEach
    void setUp() {
        acquaintanceService = new AcquaintanceServiceImpl(consoleService, localizationService);
    }

    @Test
    void makeAcquantance() {
        Profile profile = new Profile();
        when(consoleService.getString()).thenReturn("Name").thenReturn("Surname");
        acquaintanceService.makeAcquantance(profile);

        assertAll(
                () -> assertEquals("Name", profile.getName()),
                () -> assertEquals("Surname", profile.getSurname())
        );

    }
}