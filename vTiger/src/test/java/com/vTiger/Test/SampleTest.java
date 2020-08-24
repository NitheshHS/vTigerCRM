package com.vTiger.Test;

import org.testng.annotations.Test;

import com.vTiger.GenericLib.BaseClass;

public class SampleTest extends BaseClass{
	
	@Test
	public void sampleTest() {
		test=report.createTest("sample test");
		System.out.println("sucess");
	}

}
