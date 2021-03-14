package com.vytrack.step_definitions;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Pages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Map;

public class VehiclesModelStepDefs {
    Pages pages= new Pages();

    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
        pages.vehiclesModelPage().navigateToModule("Fleet", "Vehicles Model");
    }

    @When("the user clicks the {string} from vehicles model")
    public void the_user_clicks_the_from_vehicles_model(String modelName) {
        pages.vehiclesModelPage().waitUntilLoaderScreenDisappear();
        //BrowserUtils.waitForClickablility(pages.vehiclesModelPage().getVehiclesModelName(modelName), 10);
        pages.vehiclesModelPage().getVehiclesModelName(modelName).click();
    }

    @Then("the information {string} should be same with database")
    public void the_information_should_be_same_with_database(String modelName) {
        pages.vehiclesModelPage().waitUntilLoaderScreenDisappear();

        String actualModelName= pages.vehiclesModelInfoPage().getVehiclesInfo("Model Name").getText();
        String actualMake= pages.vehiclesModelInfoPage().getVehiclesInfo("Make").getText();
        String actualFuelType= pages.vehiclesModelInfoPage().getVehiclesInfo("Fuel Type").getText();

        String query= "select modelname, make, fueltype_id  from oro_ext_vehiclesmodel\n" +
                "where modelname='"+modelName+"'";
       Map<String, Object> rowMap= DBUtils.getRowMap(query);
       String expectedModelName= (String) rowMap.get("ModelName");
        String expectedMake= (String) rowMap.get("Make");
        String expectedFuelType_id= (String) rowMap.get("FuelType_id");

        Assert.assertEquals(expectedModelName, actualModelName);
        Assert.assertEquals(expectedMake, actualMake);
        Assert.assertEquals(expectedFuelType_id, actualFuelType.toLowerCase());









    }
}
