package StepDef;

import io.cucumber.java.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

import static Helper.Utility.quitDriver;
import static Helper.Utility.startDriver;


public class Hooks {
    String tagsRunning = null;

    @Before
    public void beforeTest(Scenario scenario) {
        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@web")) {
            startDriver();
        }
    }
    @BeforeEach
    public void beforeEach() throws InterruptedException {
        Thread.sleep(7000);
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException {
        if (Objects.equals(tagsRunning, "@web")) {
            quitDriver();
        }
    }
}