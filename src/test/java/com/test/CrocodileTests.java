package com.test;


import com.calls.CrocodilesAPI;
import com.data.models.CreateNewCrocodileRequest;
import com.data.models.CreateNewCrocodileResponse;
import com.test.asserts.CrocodileAsserts;
import com.test.common.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CrocodileTests extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {
        CreateNewCrocodileRequest createCrocodileRequest = new CreateNewCrocodileRequest("Jovica", "M", "2020-12-12");
        CreateNewCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodileResponse(accessToken, createCrocodileRequest);

        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, createCrocodileRequest);

    }
}