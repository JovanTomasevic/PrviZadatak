package com.test;

import com.calls.CrocodilesAPI;
import com.data.models.RegisterUserRequest;
import com.data.models.RegisterUserResponse;
import com.data.provider.CrocodilesProvider;
import com.test.asserts.CrocodileAsserts;
import com.test.common.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTest extends TestBase {

    RegisterUserRequest registerUserRequest;
    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @BeforeMethod
    public void prepareTestData() {
        registerUserRequest = CrocodilesProvider.prepareUserRequest();
    }

    @Test
    public void registerUserTest() {
        RegisterUserResponse registerUserResponse = CrocodilesAPI.registerUserResponse(registerUserRequest);
        crocodileAsserts.assertRegisterNewUser(registerUserResponse, registerUserRequest);
    }

}

