package com.test;


import com.calls.CrocodilesAPI;
import com.data.models.*;
import com.data.provider.CrocodilesProvider;
import com.environment.ConfigSetup;
import com.test.asserts.CrocodileAsserts;
import com.test.common.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class CrocodileTests extends TestBase {

    CreateNewCrocodileRequest createNewCrocodileRequest;
    UpdateCrocodileRequest updateCrocodileRequest;
    PatchCrocodileRequest patchCrocodileRequest;
    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();
    public String accessToken;
    Integer crocId;


    @BeforeMethod
    public void prepareTestData() {
        createNewCrocodileRequest = CrocodilesProvider.prepareCrocodileRequest();
        updateCrocodileRequest = CrocodilesProvider.prepareUpdateCrocodileRequest();
        patchCrocodileRequest = CrocodilesProvider.preparePatchCrocodileRequest();
        accessToken = CrocodilesAPI.login(new LoginRequest(ConfigSetup.getMainUser(), ConfigSetup.getDefaultPsw())).getAccess();
        crocId = CrocodilesAPI.createNewCrocodileResponse(accessToken, createNewCrocodileRequest).getId();
    }


    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {

        CreateNewCrocodileResponse createNewCrocodileResponse = CrocodilesAPI.createNewCrocodileResponse(accessToken,createNewCrocodileRequest);
        crocodileAsserts.assertCreateNewCrocodile(createNewCrocodileResponse, createNewCrocodileRequest);
    }

    @Test
    public void updateCrocodileTest(){
        UpdateCrocodileResponse updateCrocodileResponse = CrocodilesAPI.updateCrocodileResponse(accessToken,crocId,updateCrocodileRequest);
        crocodileAsserts.assertUpdateUser(updateCrocodileResponse,updateCrocodileRequest);
    }

    @Test
    public void patchCrocodileTest() {
        PatchCrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchCrocodileResponse(accessToken,crocId,patchCrocodileRequest);
        crocodileAsserts.assertPatchCrocodile(patchCrocodileResponse, patchCrocodileRequest);
    }

}