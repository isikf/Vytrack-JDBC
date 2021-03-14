package com.vytrack.pages.Fleet;

import com.mysql.cj.exceptions.DataReadException;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesModelInfoPage {
    public WebElement getVehiclesInfo (String info) {
        String xpath= "//*[text()='"+ info +"']/following-sibling::div/div";
        return Driver.get().findElement(By.xpath(xpath));

    }

}
