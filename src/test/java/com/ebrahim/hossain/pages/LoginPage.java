package com.ebrahim.hossain.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.ebrahim.hossain.drivers.PageDriver;
import com.ebrahim.hossain.utilities.CommonMethods;
import com.ebrahim.hossain.utilities.GetScreenShot;

public class LoginPage extends CommonMethods {

	/*
	 * Locators Methods
	 */

	ExtentTest test;

	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	@FindBys({ @FindBy(xpath = "//input[@id='email']") })
	WebElement userEmail;

	@FindBys({ @FindBy(xpath = "//input[@id='password']") })
	WebElement password;

	@FindBys({ @FindBy(xpath = "//input[@value='Login']"),
			@FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]") })
	WebElement signIn;
	
	@FindBys({
		@FindBy(xpath ="//a[contains(text(),'asdfsadfsa')]")
	})
	WebElement newUser;

	// Report
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
	}

	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	// Fail
	@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}

	public void login() throws IOException {
		try {
			test.info("Please enter your email address");
			if (userEmail.isDisplayed()) {
				userEmail.sendKeys("devina54@navalcadets.com");
				passCase("You have successfully entered your email");
				timeout(3000);
				try {
					test.info("Please enter your password");
					if (password.isDisplayed()) {
						password.sendKeys("Test@123456");
						passCase("You have successfully entered your password");
						timeout(3000);
						try {
							test.info("Click on Sign In");
							if (signIn.isDisplayed()) {
								signIn.click();
								timeout(10000);
								passCaseWithSC("You have successfully clicked on Sign In button", "login_pass");
							}
						} catch (Exception e) {
							failCase("Sign In button locator was not found", "login_fail");
						}
					}
				} catch (Exception e) {
					failCase("Password locator was not found", "pass_fail");
				}
			}
		} catch (Exception e) {
			failCase("User email locator was not found", "user_fail");
		}
	}

	
	public void createUser() throws IOException {
		try {
			test.info("Click on New User");
			if(newUser.isDisplayed()) {
				newUser.click();
				timeout(3000);
				passCaseWithSC("Clicked on New User Button", "pass_new_user");
			}
		} catch (Exception e) {
			failCase("New user button locator was not found", "fail_new_user");
		}
	}
}
