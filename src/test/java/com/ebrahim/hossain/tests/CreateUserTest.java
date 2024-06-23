package com.ebrahim.hossain.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ebrahim.hossain.drivers.PageDriver;
import com.ebrahim.hossain.pages.LoginPage;
import com.ebrahim.hossain.utilities.CommonMethods;
import com.ebrahim.hossain.utilities.ExtentFactory;

public class CreateUserTest extends CommonMethods{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		timeout();
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:13px\"><b>Create User</b></p>").assignAuthor("QA Team").assignDevice("Windows");
		
	}
	
//	@Test (priority = 0)
//	public void loginIntoShop() throws IOException {
//		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:13px\"><b>Login</b></p>");
//		LoginPage loginPage = new LoginPage(childTest);
//		loginPage.login();
//	}
	
	@Test (priority = 1)
	public void createNewUser() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:13px\"><b>New User</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.createUser();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
	
}
