package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.common.Topmenu;

public class Page {

	public WebDriver driver;
	public Topmenu topmenu;

	public Page(WebDriver driver) {

		this.driver = driver;
		topmenu = PageFactory.initElements(driver, Topmenu.class);

	}

	public Topmenu getMenu() {
		// Here is the Change
		return topmenu;
	}

}
