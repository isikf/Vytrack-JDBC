package com.vytrack.pages.Fleet;

import com.vytrack.pages.BasePage;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

public class VehiclesModelPage extends BasePage {

    public WebElement getVehiclesModelName (String modelName) {
        String xpath= "//*[contains(text(),'"+modelName+"') and @data-column-label='Model Name']";
        return Driver.get().findElement(By.xpath(xpath));
    }

}
