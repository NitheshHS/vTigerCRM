package com.vTiger.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.GenericLib.BaseClass;
@Listeners(com.vTiger.GenericLib.ListenerIMP.class)
public class SampleTest extends BaseClass{
	
	@Test
	public void sampleTest() {
		
		System.out.println("sucess");
		Assert.assertEquals(true, false);
		
	}

}
