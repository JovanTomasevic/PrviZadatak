package com.test.asserts;


import com.data.models.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();
    ;

    public void assertCreateNewCrocodile(CreateNewCrocodileResponse createCrocodileResponse, CreateNewCrocodileRequest createCrocodileRequest) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertPatchCrocodile(PatchCrocodileResponse patchCrocodileResponse, PatchCrocodileRequest patchCrocodileRequest) {
        softAssert.assertEquals(patchCrocodileRequest.getName(), patchCrocodileResponse.getName(), "Name didn't match");
        softAssert.assertAll();
    }

    public void assertRegisterNewUser(RegisterUserResponse registerUserResponse, RegisterUserRequest registerUserRequest) {
        softAssert.assertEquals(registerUserResponse.getUsername(), registerUserRequest.getUsername(), "Username is not correct!");
        softAssert.assertEquals(registerUserResponse.getEmail(), registerUserRequest.getEmail(), "Username is not correct!");
        softAssert.assertAll();
    }

    public void assertUpdateUser(UpdateCrocodileResponse updateCrocodileResponse, UpdateCrocodileRequest updateCrocodileRequest){
        softAssert.assertEquals(updateCrocodileResponse.getName(), updateCrocodileRequest.getName(),"Name is not correct!");
        softAssert.assertEquals(updateCrocodileResponse.getSex(), updateCrocodileRequest.getSex(),"Sex is not correct!");
        softAssert.assertEquals(updateCrocodileResponse.getDateOfBirth(), updateCrocodileRequest.getDateOfBirth(),"Date of birth is not correct!");
        softAssert.assertAll();

    }

    public void assertListOfPublicCrocodiles(GetPublicCrocodileResponse[] getPublicCrocodileResponse) {
        for (int i = 0; i < getPublicCrocodileResponse.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }
}
