package com.test;

import com.calls.CrocodilesAPI;
import com.data.models.*;
import com.test.asserts.CrocodileAsserts;
import com.test.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEnd extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();
    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    public void registerUserTest() {

        RegisterUserRequest registerUserRequest = new RegisterUserRequest("JovanHTEC677","jovan.tomasevic+6765658@gmail.com","test123");
        RegisterUserResponse registerUserResponse = CrocodilesAPI.registerUserResponse(registerUserRequest);

        crocodileAsserts.assertRegisterNewUser(registerUserResponse,registerUserRequest);
    }

    @Test
    public void createCrocodileTest() {
        CreateNewCrocodileRequest createCrocodileRequest = new CreateNewCrocodileRequest("Jovica", "M", "2020-12-12");
        CreateNewCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodileResponse(accessToken, createCrocodileRequest);

        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, createCrocodileRequest);

    }
    @Test
    public void updateCrocodileTest(){
        UpdateCrocodileRequest updateCrocodileRequest = new UpdateCrocodileRequest("Jovan", "M", "2019-05-05");
        UpdateCrocodileResponse updateCrocodileResponse = CrocodilesAPI.updateCrocodileResponse(updateCrocodileRequest);

        crocodileAsserts.assertUpdateUser(updateCrocodileResponse,updateCrocodileRequest);
    }

    @Test
    public void patchCrocodileTest(){
        PatchCrocodileRequest patchCrocodileRequest = new PatchCrocodileRequest("JovoPatch");
        PatchCrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchCrocodileResponse(patchCrocodileRequest);

        crocodileAsserts.assertPatchCrocodile(patchCrocodileResponse,patchCrocodileRequest);
    }
}
