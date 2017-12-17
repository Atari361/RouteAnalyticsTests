package tests;

import config.AppConfig;
import pageObjectPattern.HomePage;

public class RouteAnalyticsTestExecutor extends BasicTestExecutor{

    protected HomePage goToHomePage(){
        webDriver.get(AppConfig.getStartUrl());
        return new HomePage(webDriver);
    }

}
