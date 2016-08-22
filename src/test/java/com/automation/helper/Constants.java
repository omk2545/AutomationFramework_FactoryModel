package com.automation.helper;

public class Constants {
	
	public static final String textBox_search_DisplayPage = "input[type='text'][name ='q']";
	public static final String button_search_DisplayPage = "#container > div > header > div._1tz-RS > div.Y5-ZPI > div > div > div._1NLCcM > form > div > div.col-1-12 > button";
	
	public static final String menu_Eletronics = "#container > div > header > div.zi6sUf > div > ul > li:nth-child(1) > a > span";

	public static final String 	allproc_list_productDisplay ="div[class = 'col col-3-12 col-md-3-12 MP_3W3']";

	public static final	String USER_DIR = System.getProperty("user.dir");
	public static final String ProductsdisplayedText = "div[id = 'products'] > div[class = 'noResults fk-text-center tmargin20 bmargin20 fk-uppercase omniture-field']";
	/********Constants Products*********************/
	
	
	public static final String validProduct = "Moto X Play" ;
	public static final String invalidProduct ="AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	


	public static enum BROWSERTYPE {
		
		CHROME,FIREFOX
	}
}
