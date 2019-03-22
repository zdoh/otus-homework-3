package ru.zdoher.otushomework3.shell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Проверка локали")
@SpringBootTest(properties = {
    ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false",
    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false"
})
class ShellLocaleCommandTest {


    @Autowired
    private Shell shell;


    @DisplayName(" получение списка локали произошло корректно")
    @Test
    public void localeShoeTest() {
        assertThat(shell.evaluate(() -> "locale-show")).isEqualTo("ru or en");
    }


}