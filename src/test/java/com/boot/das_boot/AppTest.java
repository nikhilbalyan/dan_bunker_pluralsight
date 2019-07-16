package com.boot.das_boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boot.das_boot.controller.HomeController;

public class AppTest {
	
	@Test // for flagging that it is a test case
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "Das Boot, reporting for duty!");
	}
	
}
