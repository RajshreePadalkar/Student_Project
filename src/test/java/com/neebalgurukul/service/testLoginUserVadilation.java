package com.neebalgurukul.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testLoginUserVadilation {
    @Test
    public void testLoginUserValidations() throws Exception {
	LoginService service = new LoginService();

	// boolean expectedOutput = true;
	assertTrue(service.isValidUser("Rajshree", "Rajshree123"));

    }
}
