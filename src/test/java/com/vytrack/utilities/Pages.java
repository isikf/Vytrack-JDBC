package com.vytrack.utilities;

import com.vytrack.pages.Fleet.VehiclesModelInfoPage;
import com.vytrack.pages.Fleet.VehiclesModelPage;
import com.vytrack.pages.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private VehiclesModelPage vehiclesModelPage;
    private VehiclesModelInfoPage vehiclesModelInfoPage;

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public VehiclesModelPage vehiclesModelPage () {
        if (vehiclesModelPage==null) {
            vehiclesModelPage= new VehiclesModelPage();
        }
        return vehiclesModelPage;
    }
    public VehiclesModelInfoPage vehiclesModelInfoPage(){
        if (vehiclesModelInfoPage == null) {
            vehiclesModelInfoPage= new VehiclesModelInfoPage();
        }
        return vehiclesModelInfoPage;
    }

}
