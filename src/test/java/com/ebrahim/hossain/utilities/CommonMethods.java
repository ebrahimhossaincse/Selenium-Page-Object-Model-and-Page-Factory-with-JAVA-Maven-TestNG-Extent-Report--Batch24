package com.ebrahim.hossain.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.ebrahim.hossain.drivers.BaseDriver;
import com.github.javafaker.Faker;

public class CommonMethods extends BaseDriver {

	public void timeout() throws InterruptedException {
		Thread.sleep(5000);
	}

	public void timeout(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public static void testDataGenerator() throws FileNotFoundException, IOException {

		Faker faker = new Faker();

		String email = faker.internet().emailAddress();
		String password = faker.internet().password();
		
		ExcelUtils excel = new ExcelUtils();
		excel.writeExcelData(email, password);
		System.out.println(email);
		System.out.println(password);
	}

}
