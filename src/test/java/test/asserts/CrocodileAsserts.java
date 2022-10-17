package test.asserts;

import calls.CrocodilesAPI;
import data.models.crocodile.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();
    ;

    public void assertCreateNewCrocodile(CommonCrocodileResponse createCrocodileResponse, CommonCrocodileRequest createCrocodileRequest) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertUpdateCrocodile(CommonCrocodileResponse updateCrocodileResponse, CommonCrocodileRequest updateCrocodileRequest) {
        softAssert.assertEquals(updateCrocodileResponse.getName(), updateCrocodileRequest.getName());
        softAssert.assertEquals(updateCrocodileResponse.getSex(), updateCrocodileRequest.getSex());
        softAssert.assertEquals(updateCrocodileResponse.getDateOfBirth(), updateCrocodileRequest.getDateOfBirth());
        softAssert.assertAll();
    }

    public void assertPatchCrocodile(PatchCrocodileResponse patchCrocodileResponse, PatchCrocodileRequest patchCrocodileRequest) {
        softAssert.assertEquals(patchCrocodileResponse.getName(), patchCrocodileRequest.getName());
        // softAssert.assertEquals(patchCrocodileResponse.getSex(), patchCrocodileRequest.getSex());
        // softAssert.assertEquals(patchCrocodileResponse.getDateOfBirth(), patchCrocodileRequest.getDateOfBirth());
        softAssert.assertAll();
    }

    public void assertUserCreated(RegisterUserResponse registerUserResponse,RegisterUserRequest registerUserRequest) {
        softAssert.assertEquals(registerUserResponse.getEmail(), registerUserRequest.getEmail());
        softAssert.assertEquals(registerUserResponse.getUsername(), registerUserRequest.getUsername());
        softAssert.assertEquals(registerUserResponse.getFirstName(), registerUserRequest.getFirstName());
        softAssert.assertEquals(registerUserResponse.getLastName(), registerUserRequest.getLastName());
        softAssert.assertAll();
    }


    public void assertListOfPublicCrocodiles(GetPublicCrocodileResponse[] getPublicCrocodileResponse) {
        for (int i = 0; i < getPublicCrocodileResponse.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

}
