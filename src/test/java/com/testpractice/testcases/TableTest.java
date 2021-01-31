package com.testpractice.testcases;

import org.testng.annotations.Test;

import com.testpractice.testBase.TestBase;

public class TableTest extends TestBase{
	@Test
	public void ValidateTable() {
		moreDemo.clickTableSortandSearchLink();
		tabSearch.getTableElementsByColumn("Name");
	}

}
