package com.applaudo.challenge.tests.dataproviders;

import org.testng.annotations.DataProvider;


public class DataProviders {
	 @DataProvider (name = "searchValue")
	 public static Object[][] dpSearchValue(){
		 return new Object[][] {{"Skirt","Positive"},{"asd", "Negative"}};
	 }
}
