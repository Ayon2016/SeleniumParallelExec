package com.testpractice.testcases;

import org.testng.annotations.Test;

import com.testpractice.testBase.TestBase;

public class FramesTest extends TestBase{
	
	@Test
	public void ValidateFrame() {
		demoHome.navigateToOtherWebElements();
		otherPage.clickFramesLink();
		otherPage.clickFrameCheckBox();
	}

}
