package com.test;

import com.calls.CrocodilesAPI;
import com.data.models.RegisterUserRequest;
import com.data.models.RegisterUserResponse;
import com.test.asserts.CrocodileAsserts;
import com.test.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTest extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void registerUserTest() {

        RegisterUserRequest registerUserRequest = new RegisterUserRequest("JovanHTEC77","jovan.tomasevic+6768@gmail.com","test123");
        RegisterUserResponse registerUserResponse = CrocodilesAPI.registerUserResponse(registerUserRequest);

        crocodileAsserts.assertRegisterNewUser(registerUserResponse,registerUserRequest);
    }
}
