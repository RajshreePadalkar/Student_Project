package com.neebalgurukul.utility;

public class AreaUtility {

    public int areaRect(int length, int width) {
	return length * width;
    }

    public String getShape(int side1, int side2) {
	if (side1 == side2)
	    return "Square";
	else
	    return "Recangle";
    }

    public static Boolean isPolymo(int hight, int width) throws unSupportedOperationException {
	throw new unSupportedOperationException("not polymo");
    }

}
