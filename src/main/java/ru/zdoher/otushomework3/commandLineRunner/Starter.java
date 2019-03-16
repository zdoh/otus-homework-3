package ru.zdoher.otushomework3.commandLineRunner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.zdoher.otushomework3.view.Testing;

@Component
public class Starter implements CommandLineRunner {

    private Testing testing;

    public Starter(Testing testing) {
        this.testing = testing;
    }

    @Override
    public void run(String... args) throws Exception {
        testing.doTest();
    }
}
