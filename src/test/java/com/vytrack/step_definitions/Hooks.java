package com.vytrack.step_definitions;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {
    protected String url;
    protected WebDriverWait wait;
    protected Select select;
    protected Actions actions;

    @Before
    public void setUp() {
        url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(Driver.get(), 10);


    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();
    }

    @Before ("@db")
    public void setupDb() {
        DBUtils.createConnection();
    }
    @After ("@db")
    public void tearDownDb() {
        DBUtils.close();


    }
}

