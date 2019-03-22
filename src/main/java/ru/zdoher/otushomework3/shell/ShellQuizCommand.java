package ru.zdoher.otushomework3.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.zdoher.otushomework3.service.ShellQuizService;

@ShellComponent
public class ShellQuizCommand {
    private ShellQuizService shellQuizService;

    public ShellQuizCommand(ShellQuizService shellQuizService) {
        this.shellQuizService = shellQuizService;
    }

    @ShellMethod("Command to start Quiz app")
    public void quizStart() {
        shellQuizService.quiz();
    }

}
