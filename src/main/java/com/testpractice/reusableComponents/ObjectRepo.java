package com.testpractice.reusableComponents;

import com.aventstack.extentreports.ExtentTest;

import PageObjects.AutomobileInsurancePage;
import PageObjects.DemoAppHomePage;
import PageObjects.DemoAppMoreElementsPage;
import PageObjects.DempAppOtherWebElementsPage;
import PageObjects.EnterInsurantDataPage;
import PageObjects.EnterVehicleDataPage;
import PageObjects.HomePage;
import PageObjects.TableSortAndSearchPage;
import PageObjectsSpecific.Altoconvertpdftoword;
import PageObjectsSpecific.BasicAuthHeroKu;
import PageObjectsSpecific.HerokuApp;
import PageObjectsSpecific.UnitedFlight;

public class ObjectRepo {
	public static HomePage homePage = new HomePage();
	public static ExtentTest extentTest;
	public static AutomobileInsurancePage autoinsurePage = new AutomobileInsurancePage();
	public static EnterVehicleDataPage vehData = new EnterVehicleDataPage();
	public static EnterInsurantDataPage insData = new EnterInsurantDataPage();
	
	//Demo App Pages
	public static DemoAppHomePage demoHome = new DemoAppHomePage();
	public static DempAppOtherWebElementsPage otherPage = new DempAppOtherWebElementsPage();
	public static DemoAppMoreElementsPage moreDemo = new DemoAppMoreElementsPage();
	public static TableSortAndSearchPage tabSearch = new TableSortAndSearchPage();
	
	//United Flight
	public static UnitedFlight united = new UnitedFlight();
	
	//HeroKuApp
	public static HerokuApp hero = new HerokuApp();
	public static BasicAuthHeroKu auth = new BasicAuthHeroKu();
	
	//Altoconvertpdftoword
	public static Altoconvertpdftoword uploadsPage = new Altoconvertpdftoword();

}
