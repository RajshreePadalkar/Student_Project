package com.neebalgurukul.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FirstjUnit {

    // TODO Auto-generated method stub
    @Test
    public void testAreaRect() {
	AreaUtility autil = new AreaUtility();

	int l = 4;
	int b = 3;
	int expectedOutput = 12;
	assertEquals(expectedOutput, autil.areaRect(l, b));

    }

    @Test
    public void testGetShape() {
	AreaUtility autil = new AreaUtility();
	int l = 5;
	int w = 5;
	String expectedOutput = "Square";
	assertEquals(expectedOutput, autil.getShape(l, w));
    }

    @Test(expected = unSupportedOperationException.class)
    public void testIsEquilateral() throws unSupportedOperationException {
	assertTrue(AreaUtility.isPolymo(2, 3));
    }

}
