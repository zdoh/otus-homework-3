package ru.zdoher.otushomework3.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.zdoher.otushomework3.service.ShellLocaleService;

@ShellComponent
public class ShellLocaleCommand {
    private ShellLocaleService shellLocaleService;

    public ShellLocaleCommand(ShellLocaleService shellLocaleService) {
        this.shellLocaleService = shellLocaleService;
    }

    @ShellMethod("show available locale")
    public String localeShow() {
        return shellLocaleService.localeShow();
    }

    @ShellMethod("set locale from available. Use localeShow to get available locale")
    public String localeSet(@ShellOption String localName) {
        return shellLocaleService.localeSet(localName);
    }
}
