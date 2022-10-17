package test.suites;

import calls.CrocodilesAPI;
import data.models.crocodile.*;
import data.provider.CrocodilesProvider;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;


public class CrocodileTests extends TestBase {


    CommonCrocodileRequest commonCrocodileRequest;
    RegisterUserRequest registerUserRequest;
    public Integer crocId;
    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @BeforeMethod
    public void prepareTestData() {
        commonCrocodileRequest = CrocodilesProvider.prepareCommonCrocodileRequest();
        registerUserRequest = CrocodilesProvider.prepareRegisterUserRequest();
        crocId = CrocodilesAPI.createNewCrocodile(accessToken, commonCrocodileRequest).getId();
    }


    @Test(priority = 1)
    @Description("verify crocodile is created")
    public void createCrocodileTest() {

        CommonCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, commonCrocodileRequest);

    /*    crocId = createCrocodileResponse.getId(); Nisam siguran da li bi trebalo da crocId
     izvucem u BeforeMethod ili da ga kupim ovde. Razlog zasto nisam siguran je zato sto vec
     imam test za kreiranje krokodila i ne znam da li ima smisla onda da opet imam taj poziv
     u Before Method?*/

        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, commonCrocodileRequest);

    }

    @Test(priority = 2)
    @Description("Verify crocodile is updated")
    public void updateCrocodileTest() {

        CommonCrocodileResponse updateCrocodileResponse = CrocodilesAPI.updateCrocodileResponse(accessToken, crocId, commonCrocodileRequest);

        crocodileAsserts.assertUpdateCrocodile(updateCrocodileResponse, commonCrocodileRequest);
    }


    @Test(priority = 3)
    @Description("Verify crocodile is patched")
    public void patchCrocodileTest() {

        PatchCrocodileRequest patchCrocodileRequest = new PatchCrocodileRequest("jovica");

        PatchCrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchCrocodileResponse(accessToken, crocId, patchCrocodileRequest);

        crocodileAsserts.assertPatchCrocodile(patchCrocodileResponse, patchCrocodileRequest);
    }


    @Test(priority = 4)
    @Description("Verify crocodile is deleted")
    public void deleteCrocodileTest() {
        CrocodilesAPI.deleteCrocodile(accessToken, crocId);

        Assert.assertEquals(CrocodilesAPI.crocodileNotFound(accessToken, crocId), 404);

    }

    @Test(priority = 5)
    @Description("Verify user is created")
    public void registerUser() {

        RegisterUserResponse registerUserResponse = CrocodilesAPI.registerUserResponse(registerUserRequest);
        crocodileAsserts.assertUserCreated(registerUserResponse, registerUserRequest);
    }

    @Test
    @Description("dsds")
    public void getListOfPublicCrocodiles() {
        GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();

        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

}
